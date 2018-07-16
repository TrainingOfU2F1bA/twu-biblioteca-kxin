package com.twu.biblioteca;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class BibliotecaSystemTest {

    public static final String WELCOME_BIBLIOTECA_SYSTEM = "WELCOME BIBLIOTECA SYSTEM!\r\n";
    public static final String DISPLAY_BOOK_LIST = "1.List Books\r\n";
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private BibliotecaSystem bibliotecaSystem = new BibliotecaSystem();
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        Book book1=new Book("The Wealth of the Nations","Adam Smith",new Date(2012,1,1));
        Book book2=new Book("Moral Sentiment Theory","Adam Smith",new Date(2012,1,1));
        when(bookRepository.list()).thenReturn(Stream.of(book1,book2).collect(Collectors.toList()));
        System.setOut(new PrintStream(outputStream));
        bibliotecaSystem.setBookRepository(bookRepository);
    }

    @Test
    public void testWelcome() {
        bibliotecaSystem.welcome();
        Assert.assertEquals(outputStream.toString(), WELCOME_BIBLIOTECA_SYSTEM);
    }

    @Test
    public void testDisplayBookList() {
        bibliotecaSystem.displayBookList();
        Assert.assertEquals(outputStream.toString(),
                "Book Name:The Wealth of the Nations\r\nAuthor:Adam Smith\r\nPublish Year:2012\r\n\r\n" +
                "Book Name:Moral Sentiment Theory\r\nAuthor:Adam Smith\r\nPublish Year:2012\r\n\r\n");
    }

    @Test
    public void testMainMenu() {
        bibliotecaSystem=mock(BibliotecaSystem.class);
        Scanner in = mock(Scanner.class);
        bibliotecaSystem.setScanner(in);
        when(in.nextInt()).thenReturn(1,100);
        bibliotecaSystem.mainMenu();
        Assert.assertTrue(outputStream.toString().startsWith(DISPLAY_BOOK_LIST));
        bibliotecaSystem.chooseItem();
        verify(bibliotecaSystem,times(1)).displayBookList();
        verify(bibliotecaSystem,times(1)).warningValidOption();
    }
}
