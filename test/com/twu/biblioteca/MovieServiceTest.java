package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repositories.MovieRepository;
import com.twu.biblioteca.repositories.MovieRepositoryImpl;
import com.twu.biblioteca.services.MovieService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovieServiceTest {

    private MovieService service;
    private ByteArrayOutputStream out;
    private List<Movie> movies;
    private MovieRepository movieRepository;

    @Before
    public void setUp() {
        service = new MovieService();
        movieRepository = Mockito.mock(MovieRepository.class);
        movies = Arrays.asList(
                new Movie(1l, "Titan X", "James Chou", "A", new Date(1996, 1, 1)),
                new Movie(2l, "TiTan V", "James Chou", "A", new Date(2006, 1, 1))
        );
        Mockito.when(movieRepository.list()).thenReturn(movies);
        service.setMovieRepository(movieRepository);
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
        Mockito.when(movieRepository.find(1l)).thenReturn(movies.get(0));
        service.checkoutMovie(1l);
        Assert.assertTrue(out.toString().endsWith("Just Enjoy the Movie at Home!\r\n"));
        Mockito.when(movieRepository.find(-8l)).thenReturn(null);
        service.checkoutMovie(-8l);
        Assert.assertTrue(out.toString().endsWith("Invalid Movie ID!\r\n"));
    }
}
