package com.twu.biblioteca.model;

import java.util.Date;

public class Movie extends RentalGoods{
    String direct;
    String rating;
    Date ReleaseTime;

    public Movie() {
    }

    public Movie(Long id, String movieName, String direct, String rating, Date releaseTime) {
        this.id = id;
        this.name = movieName;
        this.direct = direct;
        this.rating = rating;
        ReleaseTime = releaseTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleaseTime() {
        return ReleaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        ReleaseTime = releaseTime;
    }
}
