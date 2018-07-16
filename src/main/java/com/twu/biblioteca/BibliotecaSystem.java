package com.twu.biblioteca;

import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.OptionalItem;

import java.util.List;

public class BibliotecaSystem {
    public static final String WELCOME_BIBLIOTECA_SYSTEM = "WELCOME BIBLIOTECA SYSTEM!\r\n";
    private BookService bookService;
    private BibliotecaScanner scanner;
    private List<OptionalItem> optionalItems;

    public List<OptionalItem> getOptionalItems() {
        return optionalItems;
    }

    public void setOptionalItems(List<OptionalItem> optionalItems) {
        this.optionalItems = optionalItems;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }


    public void welcome() {
        System.out.print(WELCOME_BIBLIOTECA_SYSTEM);
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
        System.out.print("1.List Books\r\n2.Return Books\r\n3.Checkout Books");
    }

    public int chooseItem() {
        final int index = scanner.readInt();
        if (optionalItems.size()>index) return optionalItems.get(index).service(bookService,scanner);
        warningValidOption();
        return 1;
    }
}
