package com.twu.biblioteca.services;

import com.twu.biblioteca.exception.AccountNotExistExcepetion;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String account, String password) {
        for (User user : userRepository.list())
            if (user.getAccount().endsWith(account)) return user.getPassword().endsWith(password);
        throw new AccountNotExistExcepetion("Account did not exist!");
    }
}
