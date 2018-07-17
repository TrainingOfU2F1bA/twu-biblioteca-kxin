package com.twu.biblioteca.repositories;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.status.BookAvailableStatus;
import com.twu.biblioteca.model.status.BookBeenLentedStaus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    List<Book> books = Arrays.asList(
            new Book(1l, "The Wealth of the Nations", "Adam Smith", new Date(2012, 1, 1), new BookAvailableStatus()),
            new Book(2l, "Moral Sentiment Theory", "Adam Smith", new Date(2012, 1, 1), new BookBeenLentedStaus())
    );

    @Override
    public List<Book> list() {
        return books;
    }

    @Override
    public Book find(Long id) {
        for (Book book : books) if (book.getId().equals(id)) return book;
        return null;
    }

    @Override
    public Book findByName(String name) {
        for (Book book : books) if (book.getBookName().equals(name)) return book;
        return null;
    }


    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
