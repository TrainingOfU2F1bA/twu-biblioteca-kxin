package com.twu.biblioteca.model;

public class Record {
    Customer customer;
    RentalGoods rentalGoods;

    public Record(Customer customer) {
        this.customer = customer;
    }

    public Record(Customer customer, RentalGoods rentalGoods) {
        this.customer = customer;
        this.rentalGoods = rentalGoods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RentalGoods getRentalGoods() {
        return rentalGoods;
    }

    public void setRentalGoods(RentalGoods rentalGoods) {
        this.rentalGoods = rentalGoods;
    }
}
