package com.twu.biblioteca;

import com.twu.biblioteca.repositories.BookRepositoryImpl;
import com.twu.biblioteca.services.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<OptionalItem> optionalItems = Stream.of(
                new QuickItem(), new BookListItem(), new BookCheoutItem(), new BookReturnItem()).collect(Collectors.toList());
        BibliotecaSystem system = new BibliotecaSystem();
        BookService service = new BookService();
        service.setBookRepository(new BookRepositoryImpl());
        systemInit(optionalItems, system, service);
        do {
            system.mainMenu();
        } while (system.chooseItem() != 0);
    }

    private static void systemInit(List<OptionalItem> optionalItems, BibliotecaSystem system, BookService service) {
        system.setBookService(service);
        system.setOptionalItems(optionalItems);
        system.welcome();
        system.setScanner(new BibliotecaScanner());
    }
}
