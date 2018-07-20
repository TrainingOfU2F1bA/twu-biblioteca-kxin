package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.services.NewBookCheoutItem;
import com.twu.biblioteca.services.NewOptionalItem;
import com.twu.biblioteca.services.UserService;

import java.util.List;
import java.util.Scanner;

public class BibliotecaSystemRelease2 extends BibliotecaSystem{

    private List<NewOptionalItem> items;
    private User user;
    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setItems(List<NewOptionalItem> items) {
        this.items = items;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void userLogin(){
        while (user==null) {
            System.out.println("Please Login First:");
            System.out.println("Account:");
            String account = getScanner().readLine();
            System.out.println("Password:");
            String psw = getScanner().readLine();
            user = userService.login(account, psw);
        }
    }

    @Override
    public void mainMenu() {
        System.out.println("1.List Books\r\n2.Return Books\r\n3.Checkout Books\r\n" +
                "4.Record List\r\n5.Find books\r\n6.List Movie\r\n7.Checkout Movie\r\n"+
        "8.My infomation");
    }

    @Override
    public int chooseItem() {
        final int index = getScanner().readInt();
        if (items.size()>index) {
            try {
                return items.get(index).run(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return 1;
    }
}
