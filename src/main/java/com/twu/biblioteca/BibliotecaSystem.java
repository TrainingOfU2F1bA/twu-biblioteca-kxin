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
        bookRepository.list().forEach(book -> {
            System.out.println("Book Name:"+book.getBookName());
            System.out.println("Author:"+book.getAuthorName());
            System.out.println("Publish Year:"+book.getPublishDate().getYear());
            System.out.println();
        });

    }

}
