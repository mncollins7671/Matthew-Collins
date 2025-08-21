package com.techelevator;

import java.math.BigDecimal;

public class AudioBook extends Product{

    private String author;
    private int duration;
    private String narrator;

    public AudioBook(String type, String title, int year, String genre, String uniqueID, BigDecimal price, String author, int duration, String narrator, int quantity) {
        super(type, title, year, genre, uniqueID, price, quantity);
        this.author = author;
        this.duration = duration;
        this.narrator = narrator;
    }

    public String getAuthor() {
        return author;
    }

    public int getDuration() {
        return duration;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }
}

