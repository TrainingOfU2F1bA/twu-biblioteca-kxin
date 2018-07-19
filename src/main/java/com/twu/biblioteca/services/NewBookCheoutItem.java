package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

public class NewBookCheoutItem implements NewOptionalItem{

    private BookService bookService;

    @Override
    public int run(User user) {
        System.out.println("Which Book do you want to checkout:");
        int i = new BibliotecaScanner().readInt();
        Book book = bookService.returnBook(i);
        return 3;
    }
}
