package com.twu.biblioteca.services;

import com.sun.javafx.binding.StringFormatter;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookStatus;
import com.twu.biblioteca.model.status.BookAvailableStatus;
import com.twu.biblioteca.model.status.BookBeenLentedStaus;
import com.twu.biblioteca.repositories.BookRepository;

public class BookService {
    public static final String BOOK_NAME_S_AUTHOR_S_PUBLISH_YEAR_S = "Book Name:%s\r\nAuthor:%s\r\nPublish Year:%s\r\n\r\n";
    public static final String THAT_BOOK_IS_NOT_AVAILABLE = "That book is not available.\r\n";
    public static final String THAT_IS_NOT_A_VALID_BOOK_TO_RETURN = "That is not a valid book to return.\r\n";
    public static final String THANK_YOU_FOR_RETURNING_THE_BOOK = "Thank you for returning the book.\r\n";
    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void listBooks() {
        bookRepository.list().stream()
                .filter(book -> !book.getStatus().getClass().equals(BookBeenLentedStaus.class))
                .forEach(book -> {
                    System.out.print(StringFormatter.format(BOOK_NAME_S_AUTHOR_S_PUBLISH_YEAR_S
                            , book.getName(), book.getAuthorName(), book.getPublishDate().getYear()).get());
                });
    }

    public Book checkoutBook(long i) {
        Book book = bookRepository.find(i);
        if (book == null) System.out.print(THAT_BOOK_IS_NOT_AVAILABLE);
        else {
            BookStatus status = book.getStatus();
            if (status.getClass().equals(BookAvailableStatus.class)) book.setStatus(new BookBeenLentedStaus());
            System.out.print(status);
        }
        return book;
    }

    public Book returnBook(long id) {
        Book book = bookRepository.find(id);
        if (book == null || !book.getStatus().getClass().equals(BookBeenLentedStaus.class))
            System.out.print(THAT_IS_NOT_A_VALID_BOOK_TO_RETURN);
        else {
            book.setStatus(new BookAvailableStatus());
            System.out.print(THANK_YOU_FOR_RETURNING_THE_BOOK);
        }
        return book;
    }
}
