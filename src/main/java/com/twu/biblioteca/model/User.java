package com.twu.biblioteca.model;

public class User {
    private Long id;
    private String userName;
    private String account;
    private int age;
    private String password;

    public User() {
    }

    public User(Long id, String userName, String account, int age, String password) {
        this.id = id;
        this.userName = userName;
        this.account = account;
        this.age = age;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
