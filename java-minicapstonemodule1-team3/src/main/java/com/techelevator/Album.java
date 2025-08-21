package com.techelevator;

import java.math.BigDecimal;

public class Album extends Product{
    private String artist;
    private int tracks;
    private String label;

    public Album(String type, String title, int year, String genre, String uniqueID, BigDecimal price, String artist, int tracks, String label, int quantity) {
        super(type, title, year, genre, uniqueID, price, quantity);
        this.artist = artist;
        this.tracks = tracks;
        this.label = label;
    }

    public String getArtist() {
        return artist;
    }

    public int getTracks() {
        return tracks;
    }

    public String getLabel() {
        return label;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

