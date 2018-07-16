package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;

public class BookListItem implements OptionalItem{
    @Override
    public int service(BookService bookService, BibliotecaScanner scanner) {
        bookService.listBooks();
        return 2;
    }
}
