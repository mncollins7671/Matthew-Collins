package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product extends Application{

    private String type;

    private String title;

    private int year;

    private String genre;

    private String uniqueID;

    private BigDecimal price;

    private int quantity;

    public Product(String type, String title, int year, String genre, String uniqueID, BigDecimal price, int quantity){
        this.type = type;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.uniqueID = uniqueID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString(){
        return uniqueID + " |" + type + " |" + title + " |" + price + "  |" + quantity;
    }

}
