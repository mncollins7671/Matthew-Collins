package com.techelevator;

import java.io.PrintWriter;
import java.math.BigDecimal;

public class Book extends Product {

    private String author;
    private String ISBN;
    private int pageCount;


    public Book(String type, String title, int year, String genre, String uniqueID, BigDecimal price, String author, String ISBN, int pageCount, int quantity) {
        super(type, title, year, genre, uniqueID, price, quantity);
        this.author = author;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
