package com.twu.biblioteca.services;

import com.twu.biblioteca.model.User;

public class NewBookListItem implements NewOptionalItem{
    private BookService bookService;

    public NewBookListItem(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public int run(User user) {
        bookService.listBooks();
        return 1;
    }
}
