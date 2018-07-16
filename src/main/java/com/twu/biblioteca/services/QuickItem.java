package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;

public class QuickItem implements OptionalItem{
    @Override
    public int service(BookService bookService, BibliotecaScanner scanner) {
        return 0;
    }
}
