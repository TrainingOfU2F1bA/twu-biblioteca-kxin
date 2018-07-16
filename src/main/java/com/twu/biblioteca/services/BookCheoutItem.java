package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;

public class BookCheoutItem implements OptionalItem{
    @Override
    public int service(BookService bookService, BibliotecaScanner scanner) {
        System.out.println("which book do you want to check out:");
        bookService.checkoutBook(scanner.readInt());
        return 1;
    }
}
