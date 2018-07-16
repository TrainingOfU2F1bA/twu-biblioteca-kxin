package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.services.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private PrintStream out = new PrintStream(new ByteArrayOutputStream());
    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public void setUp() {
        bookService = new BookService();
        bookRepository = mock(BookRepository.class);
        Book book1=new Book(1l,"The Wealth of the Nations","Adam Smith",new Date(2012,1,1));
        Book book2=new Book(2l,"Moral Sentiment Theory","Adam Smith",new Date(2012,1,1));
        when(bookRepository.list()).thenReturn(Stream.of(book1,book2).collect(Collectors.toList()));
        when(bookRepository.find(1l)).thenReturn(book1);
        System.setOut(out);
        bookService.setBookRepository(bookRepository);
    }

    @Test
    public void testCheckout() {
        bookService.checkoutBook(1l);
        Assert.assertTrue(out.toString().endsWith("Thank you! Enjoy the book"));
        when(bookRepository.find(-100l)).thenReturn(null);
        bookService.checkoutBook(-100l);
        Assert.assertTrue(out.toString().endsWith("That book is not available."));
    }

    @Test
    public void testResturn() {

    }
}
