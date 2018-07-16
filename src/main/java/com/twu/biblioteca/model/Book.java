package com.twu.biblioteca.model;

import java.util.Date;

public class Book {
    private Long id;
    private String bookName;
    private String authorName;
    private Date publishDate;
    private BookStatus status;

    public Book() {
    }

    public Book(String bookName, String authorName, Date publishDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public Book(Long id, String bookName, String authorName, Date publishDate) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public Book(Long id, String bookName, String authorName, Date publishDate, BookStatus status) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
