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
                    , movie.getId(), movie.getName(), movie.getDirect(), movie.getRating(), movie.getReleaseTime().getYear()).get()
            );
        });
    }

    public void checkoutMovie(long id) {
        if (movieRepository.find(id)==null) {
            System.out.print("Invalid Movie ID!\r\n");
        }else System.out.print("Just Enjoy the Movie at Home!\r\n");
    }
}
