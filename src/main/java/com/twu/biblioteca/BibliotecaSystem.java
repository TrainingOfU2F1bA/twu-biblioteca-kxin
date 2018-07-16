package com.twu.biblioteca;

import com.twu.biblioteca.repositories.BookRepository;

import java.util.Scanner;

public class BibliotecaSystem {
    public static final String WELCOME_BIBLIOTECA_SYSTEM = "WELCOME BIBLIOTECA SYSTEM!\r\n";
    private BookRepository bookRepository;
    private BibliotecaScanner scanner;

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

    public void setScanner(BibliotecaScanner scanner) {
        this.scanner = scanner;

    }

    public BibliotecaScanner getScanner() {
        return scanner;
    }

    public void warningValidOption() {
        System.out.print("Select a valid option!\r\n");
    }

    public void mainMenu() {
        System.out.print("1.List Books\r\n");
    }

    public void chooseItem() {
        int i = scanner.readInt();
        if (i==1) displayBookList();
        else warningValidOption();
    }
}
