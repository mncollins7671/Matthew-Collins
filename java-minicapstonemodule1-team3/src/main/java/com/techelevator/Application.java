package com.techelevator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

public class Application {
	private final Scanner userInput = new Scanner(System.in);
	private Logger logger;
	private List<Product> productList;



//	public Application(){
//		logger = new Logger("file.txt");
//	}

	public static void main(String[] args) throws FileNotFoundException {

		Application app = new Application();
		app.run();
	}

	public void run() throws FileNotFoundException {
//		Scanner userInput = new Scanner(System.in);
		boolean exit = false;
		boolean exitProductMenu = false;
		boolean exitMoneyMenu = false;
		Inventory inventory = new Inventory();
		productList = inventory.createProductList();
		MoneyManger moneyManger = new MoneyManger();

		System.out.println("-----------------------------------------");
		System.out.println("----- Welcome to the Media Machine! -----");
		System.out.println("-----------------------------------------");



		while (!exit) {
			MenuOptions.mainMenu();
			String input = userInput.nextLine();
			int choice = Integer.parseInt(input);

			switch (choice) {
				case 1:
					MenuOptions.productMenu();
					String productChoice = userInput.nextLine();
					while (!exitProductMenu){
						if(productChoice.equalsIgnoreCase("A")){
							for (Product prod: productList){
								if (prod.getType().equals("BOOK")){
									System.out.println(prod);
								}
							}
							exitProductMenu = true;
						} else if (productChoice.equalsIgnoreCase("B")) {
							for (Product prod: productList){
								if (prod.getType().equals("MOVIE")){
									System.out.println(prod);
								}
							}
							exitProductMenu = true;
						} else if (productChoice.equalsIgnoreCase("C")){
							for (Product prod: productList){
								if (prod.getType().equals("ALBUM")){
									System.out.println(prod);
								}
							}
							exitProductMenu = true;
						} else if (productChoice.equalsIgnoreCase("D")){
							for (Product prod: productList){
								if (prod.getType().equals("VIDEOGAME")){
									System.out.println(prod);
								}
							}
							exitProductMenu = true;
						} else if (productChoice.equalsIgnoreCase("E")) {
							for (Product prod: productList){
								if (prod.getType().equals("AUDIOBOOK")){
									System.out.println(prod);
								}
							}
							exitProductMenu = true;
						} else if (productChoice.equalsIgnoreCase("F")){
							for (Product item : productList){
								System.out.println(item);
							}
							exitProductMenu = true;
						}
					}
					exitProductMenu = true;
					break;
				case 2:
					//Version we want to work
					MenuOptions.moneyMenu(moneyManger.getCurrentBalance());
					while (!exitMoneyMenu){
						String moneyMenuChoice = userInput.nextLine();
						if (moneyMenuChoice.equals("1")){
							moneyManger.feedMoney();

						}
						if (moneyMenuChoice.equals("2")){
							for (Product item : productList){
								System.out.println(item.toString());
							}
						}
						if (moneyMenuChoice.equals("3")){
							moneyManger.returnChange();

						}

					}
					break;
				case 3:
					exit = true;
					break;
				default:  // final else - if you didn't type 1, 2, 3, or 4
					System.out.println("Invalid entry!");

			}
		}
	}























// Money Manager class goes here


//	public void run(){
//		productList = loadFile(); //loads csv file
//		//printMainMenu();
//
//	}
//	public List<Product> loadFile(){
//		File productList = new File(mediaInput.csv);
//
//	}


}
