package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.User;

public class NewBookReturnItem implements NewOptionalItem{

    private BookService bookService;
    private RecordService recordService;

    @Override
    public int run(User user) {
        System.out.println("Which Book do you want to return");
        int i = new BibliotecaScanner().readInt();
        Book book = bookService.checkoutBook(i);
        recordService.createRecord(book, (Customer) user);
        return 1;
    }
}
