package com.twu.biblioteca.model;

public class Customer extends User{
    private String phoneNumber;
    private String email;

    public Customer(Long id, String userName, String account, int age, String password, String phoneNumber, String email) {
        super(id, userName, account, age, password);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name:"+getUserName()+"\r\nEmail:"+email+"\r\nPhone Number:"+phoneNumber;
    }
}
