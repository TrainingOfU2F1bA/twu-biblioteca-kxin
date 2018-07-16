package com.twu.biblioteca.services;

import com.sun.javafx.binding.StringFormatter;
import com.twu.biblioteca.repositories.MovieRepository;

public class MovieService {
    MovieRepository movieRepository;

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void displayMovieList() {
        movieRepository.list().forEach(movie -> {
            System.out.print(StringFormatter.format("ID:%s\r\nMovie Name:%s\r\nDirector:%s\r\nRating:%s\r\nRelease Year:%s\r\n\r\n"
                    , movie.getId(), movie.getMovieName(), movie.getDirect(), movie.getRating(), movie.getReleaseTime().getYear()).get()
            );
        });
    }
}
