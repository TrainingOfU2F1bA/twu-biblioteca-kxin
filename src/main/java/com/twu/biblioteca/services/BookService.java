package com.twu.biblioteca.services;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookStatus;
import com.twu.biblioteca.model.status.BookAvailableStatus;
import com.twu.biblioteca.model.status.BookBeenLentedStaus;
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
        Book book = bookRepository.find(i);
        if (book!=null){
            BookStatus status = book.getStatus();
            if (status.getClass().equals(BookAvailableStatus.class)) {
                book.setStatus(new BookBeenLentedStaus());
            }
            System.out.print(status);
            return;
        }
        System.out.print("That book is not available.\r\n");
    }
}
