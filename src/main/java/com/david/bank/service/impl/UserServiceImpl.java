package com.david.bank.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.david.bank.domain.model.User;
import com.david.bank.domain.model.repository.UserRepository;
import com.david.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists.");
        }
        return userRepository.save(user);
    }

}
