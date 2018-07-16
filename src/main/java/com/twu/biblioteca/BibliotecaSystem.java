package com.twu.biblioteca;

import com.twu.biblioteca.repositories.BookRepository;

public class BibliotecaSystem {
    public static final String WELCOME_BIBLIOTECA_SYSTEM = "WELCOME BIBLIOTECA SYSTEM!\r\n";
    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void welcome() {
        System.out.print(WELCOME_BIBLIOTECA_SYSTEM);
    }


    public void displayBookList() {

    }

}
