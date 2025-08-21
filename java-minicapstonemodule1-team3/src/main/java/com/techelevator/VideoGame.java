package com.techelevator;

import java.math.BigDecimal;

public class VideoGame extends Product{
    private String platform;
    private String developer;
    private String ESRB;

    public VideoGame(String type, String title, int year, String genre, String uniqueID, BigDecimal price, String platform, String developer, String ESRB, int quantity) {
        super(type, title, year, genre, uniqueID, price, quantity);
        this.platform = platform;
        this.developer = developer;
        this.ESRB = ESRB;
    }

    public String getPlatform() {
        return platform;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getESRB() {
        return ESRB;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setESRB(String eSRB) {
        this.ESRB = eSRB;
    }
}
