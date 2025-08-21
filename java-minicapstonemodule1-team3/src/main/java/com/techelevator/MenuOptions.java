package com.techelevator;

public class MenuOptions{

    public static void mainMenu(){
        System.out.println("--------------- Main Menu ---------------");
        System.out.println("(1) Display Media Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.print("Enter choice: ");

    }

    public static void productMenu() {
        System.out.println("(A) Books");
        System.out.println("(B) Movies");
        System.out.println("(C) Albums");
        System.out.println("(D) Video Games");
        System.out.println("(E) Audio Books");
        System.out.println("(F) Return all");
        System.out.print("Enter choice: ");
    }

    public static void moneyMenu(double currentBalance){

        System.out.println("-----------------------------------------");
        System.out.println("-------------- Money Menu ---------------");
        System.out.println("-----------------------------------------");
        System.out.println("Current Money Provided: " + currentBalance);
        System.out.println("");
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println("Enter choice: ");

    }
}
