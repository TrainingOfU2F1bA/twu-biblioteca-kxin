package com.twu.biblioteca.services;

import com.twu.biblioteca.model.User;

public class NewUserInfoItem implements NewOptionalItem{
    UserService userService;

    public NewUserInfoItem(UserService userService) {
        this.userService = userService;
    }

    @Override
    public int run(User user) {
        System.out.println( userService.getUserInfo(user));
        return 7;
    }
}
