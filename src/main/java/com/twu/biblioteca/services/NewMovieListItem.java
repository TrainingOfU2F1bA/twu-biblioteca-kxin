package com.twu.biblioteca.services;

import com.twu.biblioteca.model.User;

public class NewMovieListItem implements NewOptionalItem{
    private MovieService movieService;

    public NewMovieListItem(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public int run(User user) {
        movieService.displayMovieList();
        return 6;
    }
}
