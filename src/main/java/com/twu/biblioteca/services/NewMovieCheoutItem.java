package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.User;

public class NewMovieCheoutItem implements NewOptionalItem{

    private MovieService movieService;
    private RecordService recordService;

    public NewMovieCheoutItem(MovieService movieService, RecordService recordService) {
        this.movieService = movieService;
        this.recordService = recordService;
    }

    @Override
    public int run(User user) {
        System.out.println("Which Movie do you want to checkout:");
        int i = new BibliotecaScanner().readInt();
        Movie movie = movieService.checkoutMovie(i);
        recordService.createRecord(movie, (Customer) user);
        return 1;
    }
}
