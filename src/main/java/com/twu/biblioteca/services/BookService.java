package com.twu.biblioteca.services;

import com.twu.biblioteca.repositories.BookRepository;

public class BookService {
    BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void checkoutBook(long i) {
    }
}
