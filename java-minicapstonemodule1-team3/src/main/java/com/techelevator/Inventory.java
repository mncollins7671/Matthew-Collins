package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    public  List<Product> createProductList() throws FileNotFoundException {
        List<Product> ProductList = new ArrayList<>();
        File file = new File("mediaInput.csv");
        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNextLine()){
            String line = fileInput.nextLine();
            String[] parts = line.split(",");
            String type = parts[0];
            String title = parts[1];
            int year = Integer.parseInt(parts[2]);
            String genre = parts[3];
            String uniqueID = parts[4];
            BigDecimal price = new BigDecimal(parts[5]);
            int quantity = Integer.parseInt(parts[9]);
            if(type.equals("BOOK")){
                String author = parts[6];
                String ISBN = parts[7];
                int pageCount = Integer.parseInt(parts[8]);
                Book book = new Book(type, title, year, genre, uniqueID, price, author, ISBN, pageCount, quantity);
                ProductList.add(book);
            }
            if (type.equals("MOVIE")){
                String director = parts[6];
                int runtime = Integer.parseInt(parts[7]);
                String rating = parts[8];
                Movie movie = new Movie(type, title, year, genre, uniqueID, price, director, runtime, rating, quantity);
                ProductList.add(movie);
            }
            if (type.equals("ALBUM")){
                String artist = parts[6];
                int tracks = Integer.parseInt(parts[7]);
                String label = parts[8];
                Album album = new Album(type, title, year, genre, uniqueID, price, artist, tracks, label, quantity);
                ProductList.add(album);
            }
            if (type.equals("VIDEOGAME")){
                String platform = parts[6];
                String developer = parts[7];
                String ESRB = parts[8];
                VideoGame videoGame = new VideoGame(type, title, year, genre, uniqueID, price, platform, developer, ESRB, quantity);
                ProductList.add(videoGame);
            }
            if (type.equals("AUDIOBOOK")){
                String author = parts[6];
                int duration = Integer.parseInt(parts[7]);
                String narrator = parts[8];
                AudioBook audioBook = new AudioBook(type, title, year, genre, uniqueID, price, author, duration, narrator, quantity);
                ProductList.add(audioBook);
            }

        }

        return ProductList;
    }

}
