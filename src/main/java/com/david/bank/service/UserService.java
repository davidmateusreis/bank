package com.david.bank.service;

import com.david.bank.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
