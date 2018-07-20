package com.twu.biblioteca;

import com.twu.biblioteca.repositories.BookRepositoryImpl;
import com.twu.biblioteca.repositories.MovieRepositoryImpl;
import com.twu.biblioteca.repositories.RecordRepositoryImpl;
import com.twu.biblioteca.repositories.UserRepositoryImpl;
import com.twu.biblioteca.services.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BibliotecaAppRelease2 {
    public static void main(String[] args) {
        BibliotecaSystemRelease2 system = new BibliotecaSystemRelease2();
        ServiceInitializer serviceInitializer = new ServiceInitializer().invoke();
        MovieService movieService = serviceInitializer.getMovieService();
        BookService bookservice = serviceInitializer.getBookservice();
        RecordService recordService = serviceInitializer.getRecordService();
        UserService userService = serviceInitializer.getUserService();
        itemInit(system, movieService, bookservice, recordService,userService);
        system.setScanner(new BibliotecaScanner());
        system.setUserService(userService);
        while (true) {
            try {
                system.userLogin();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            do {
                if (system.getUser()==null) break;
                system.mainMenu();
            } while (system.chooseItem() != 0);
            system.getScanner().readLine();
            system.setUser(null);
        }
    }

    private static void itemInit(BibliotecaSystemRelease2 system, MovieService movieService, BookService bookservice, RecordService recordService, UserService userService) {
        system.setItems(Stream.of(new NewQuickItem(),
                new NewBookListItem(bookservice)
                , new NewBookReturnItem(bookservice, recordService),
                new NewBookCheoutItem(bookservice, recordService),
                new NewRcordListItem(recordService),
                new FindBookItem(recordService),
                new NewMovieListItem(movieService),
                new NewMovieCheoutItem(movieService, recordService),
                new NewUserInfoItem(userService)).collect(Collectors.toList()));
    }

    private static class ServiceInitializer {
        private MovieService movieService;
        private BookService bookservice;
        private RecordService recordService;
        private UserService userService;

        public UserService getUserService() {
            return userService;
        }

        public MovieService getMovieService() {
            return movieService;
        }

        public BookService getBookservice() {
            return bookservice;
        }

        public RecordService getRecordService() {
            return recordService;
        }

        public ServiceInitializer invoke() {
            movieService = new MovieService();
            bookservice = new BookService();
            userService = new UserService();
            recordService = new RecordService();
            userService.setUserRepository(new UserRepositoryImpl());
            recordService.setRecordRepository(new RecordRepositoryImpl());
            movieService.setMovieRepository(new MovieRepositoryImpl());
            bookservice.setBookRepository(new BookRepositoryImpl());
            return this;
        }
    }
}
