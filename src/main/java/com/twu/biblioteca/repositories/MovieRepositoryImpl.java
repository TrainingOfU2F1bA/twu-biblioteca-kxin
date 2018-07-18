package com.twu.biblioteca.repositories;

import com.twu.biblioteca.model.Movie;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    List<Movie> arrayList = Arrays.asList(
            new Movie(1l, "Titan X", "James Chou", "A", new Date(1996, 1, 1)),
            new Movie(2l, "TiTan V", "James Chou", "A", new Date(2006, 1, 1))
    );

    @Override
    public List<Movie> list() {
        return arrayList;
    }

    @Override
    public Movie find(Long id) {
        for (Movie movie : arrayList) if (movie.getId().equals(id)) return movie;
        return null;
    }

    @Override
    public Movie findByName(String name) {
        for (Movie movie : arrayList) if (movie.getName().equals(name)) return movie;
        return null;
    }

    @Override
    public void add(Movie movie) {
        arrayList.add(movie);
    }

    @Override
    public void delete(Long id) {
        arrayList.removeIf(movie -> movie.getId().equals(id));
    }
}
