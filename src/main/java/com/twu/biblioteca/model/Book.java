package com.twu.biblioteca.model;

import java.util.Date;

public class Book extends RentalGoods{
    private String authorName;
    private Date publishDate;
    private BookStatus status;

    public Book() {
    }

    public Book(String bookName, String authorName, Date publishDate) {
        this.name = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public Book(Long id, String bookName, String authorName, Date publishDate) {
        this.id = id;
        this.name = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public Book(Long id, String bookName, String authorName, Date publishDate, BookStatus status) {
        this.id = id;
        this.name = bookName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
