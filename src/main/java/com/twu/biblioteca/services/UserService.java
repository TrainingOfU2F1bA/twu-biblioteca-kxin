package com.twu.biblioteca.services;

import com.twu.biblioteca.exception.AccountNotExistExcepetion;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String account, String password) {
        for (User user : userRepository.list()) {
            if (user.getAccount().equals(account)&&user.getPassword().equals(password)) return user;
            if (user.getAccount().equals(account)) return null;
        }
        throw new AccountNotExistExcepetion("Account did not exist!");
    }

    public String getUserInfo(User user) {
        return user.toString();
    }
}
