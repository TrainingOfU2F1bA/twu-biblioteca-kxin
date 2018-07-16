package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;

public class BookReturnItem implements OptionalItem{
    @Override
    public int service(BookService bookService, BibliotecaScanner scanner) {
        System.out.println("which book do you want to return:");
        bookService.returnBook(scanner.readInt());
        return 3;
    }
}
