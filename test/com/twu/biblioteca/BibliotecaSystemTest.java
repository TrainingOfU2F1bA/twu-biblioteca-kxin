package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.status.BookAvailableStatus;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.services.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaSystemTest {

    public static final String WELCOME_BIBLIOTECA_SYSTEM = "WELCOME BIBLIOTECA SYSTEM!\r\n";
    public static final String DISPLAY_BOOK_LIST = "1.List Books\r\n";
    public static final String SELECT_A_VALID_OPTION = "Select a valid option!\r\n";
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private BibliotecaSystem bibliotecaSystem = new BibliotecaSystem();
    private BookRepository bookRepository;
    List<OptionalItem> optionalItems = Stream.of(
            new QuickItem(), new BookListItem(), new BookCheoutItem(), new BookReturnItem()).collect(Collectors.toList());
    private BookService bookService;

    @Before
    public void setUp() {
        bibliotecaSystem.setOptionalItems(optionalItems);
        bookService = new BookService();
        bibliotecaSystem.setBookService(bookService);
        bookRepository = mock(BookRepository.class);
        Book book1 = new Book("The Wealth of the Nations", "Adam Smith", new Date(2012, 1, 1));
        Book book2 = new Book("Moral Sentiment Theory", "Adam Smith", new Date(2012, 1, 1));
        book1.setStatus(new BookAvailableStatus());
        book2.setStatus(new BookAvailableStatus());
        when(bookRepository.list()).thenReturn(Stream.of(book1, book2).collect(Collectors.toList()));
        bookService.setBookRepository(bookRepository);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testWelcome() {
        bibliotecaSystem.welcome();
        Assert.assertEquals(outputStream.toString(), WELCOME_BIBLIOTECA_SYSTEM);
    }

    @Test
    public void testDisplayBookList() {
        bookService.listBooks();
        Assert.assertEquals(outputStream.toString(),
                "Book Name:The Wealth of the Nations\r\nAuthor:Adam Smith\r\nPublish Year:2012\r\n\r\n" +
                        "Book Name:Moral Sentiment Theory\r\nAuthor:Adam Smith\r\nPublish Year:2012\r\n\r\n");
    }

    @Test
    public void testMainMenu() {
        BibliotecaScanner in = mock(BibliotecaScanner.class);
        bibliotecaSystem.setScanner(in);
        when(in.readInt()).thenReturn(1, 100);
        bibliotecaSystem.mainMenu();
        Assert.assertTrue(outputStream.toString().startsWith(DISPLAY_BOOK_LIST));
        bibliotecaSystem.chooseItem();
        Assert.assertTrue(outputStream.toString().endsWith(
                "Book Name:The Wealth of the Nations\r\nAuthor:Adam Smith\r\nPublish Year:2012\r\n\r\n" +
                        "Book Name:Moral Sentiment Theory\r\nAuthor:Adam Smith\r\nPublish Year:2012\r\n\r\n"));
        bibliotecaSystem.chooseItem();
        Assert.assertTrue(outputStream.toString().endsWith(SELECT_A_VALID_OPTION));
    }
}
