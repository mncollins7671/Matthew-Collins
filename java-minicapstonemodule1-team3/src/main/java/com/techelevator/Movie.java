package com.techelevator;

import java.math.BigDecimal;

public class Movie extends Product{

    private String director;
    private int runTime;
    private String rating;

    public Movie(String type, String title, int year, String genre, String uniqueID, BigDecimal price, String director, int runTime, String rating, int quantity) {
        super(type, title, year, genre, uniqueID, price, quantity);
        this.director = director;
        this.runTime = runTime;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public int getRunTime() {
        return runTime;
    }

    public String getRating() {
        return rating;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
