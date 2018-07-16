package com.twu.biblioteca;

import com.twu.biblioteca.repositories.MovieRepository;
import com.twu.biblioteca.repositories.MovieRepositoryImpl;
import com.twu.biblioteca.services.MovieService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MovieServiceTest {

    private MovieService service;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        service = new MovieService();
        service.setMovieRepository(new MovieRepositoryImpl());
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testMovieList() {
        service.displayMovieList();
        final String s = "ID:1\r\n" + "Movie Name:Titan X\r\n" + "Director:James Chou\r\n" + "Rating:A\r\n" + "Release Year:1996\r\n\r\n" +
                "ID:2\r\n" + "Movie Name:TiTan V\r\n" + "Director:James Chou\r\n" + "Rating:A\r\n" + "Release Year:2006\r\n\r\n";
        Assert.assertTrue(out.toString().endsWith(s));
    }

    @Test
    public void testCheckOut() {
        service.checkoutMovie(1l);
        Assert.assertTrue(out.toString().endsWith("Just Enjoy the Movie at Home!\r\n"));
//        Assert.assertEquals(out.toString(),"ss");
        service.checkoutMovie(-8l);
        Assert.assertTrue(out.toString().endsWith("Invalid Movie ID!\r\n"));
    }
}
