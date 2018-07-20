package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.User;

public class NewBookReturnItem implements NewOptionalItem{

    private BookService bookService;
    private RecordService recordService;

    public NewBookReturnItem(BookService bookService, RecordService recordService) {
        this.bookService = bookService;
        this.recordService = recordService;
    }

    @Override
    public int run(User user) {
        System.out.println("Which Book do you want to return");
        int i = new BibliotecaScanner().readInt();
        recordService.deteleGoodsRentRecord(user.getAccount(), (long) i);
        Book book = bookService.returnBook(i);
        return 3;
    }
}
