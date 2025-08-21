package com.techelevator;

import java.util.Scanner;
import java.util.Set;

public class MoneyManger extends MenuOptions{

    private double currentBalance = 2.00;

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void feedMoney() {

        boolean isDone = false;

        Scanner input = null;
        String userInput;
        while (!isDone) {
            System.out.println("Please Select the Amount of money you want to feed: ");
            System.out.println("(int) 1, 5, 10, 20, or 50: ");
            input = new Scanner(System.in);
            userInput = input.nextLine();

            Set<Integer> validAmounts = Set.of(1, 5, 10, 20, 50);
            int parsedUserInputString = Integer.parseInt(userInput);

            if (!validAmounts.contains(parsedUserInputString)) {
                System.out.println("Invalid Currency amount!");
                System.out.println("Please select a valid Currency amount");
                System.out.println("Insert either 1, 5, 10, 20, 50");
            } else {
                currentBalance += parsedUserInputString;
                System.out.println("**********************************");
                System.out.println("your wallet now has: $" + currentBalance);
                System.out.println("**********************************");
                System.out.println("Would you like to add More Money? Y/N");
                userInput = input.nextLine();
                if (userInput.equals("Y")) {
                    isDone = false;
                } else if (userInput.equals("N")) {
                    isDone = true;
                }
            }
        }
        MenuOptions.moneyMenu(getCurrentBalance());

    }
    public void returnChange(){

        Scanner input = new Scanner(System.in);

        System.out.println("**********************************");
        System.out.println("Would you like your change? Y/N");
        String userInput = input.nextLine();
        if (userInput.contains("Y") || userInput.contains("y")) {
            System.out.println("Current wallet amount before computation: " + currentBalance);
            int dollars = 0;
            int quarters = 0;
            int dimes = 0;
            int nickels = 0;
            int pennies = 0;
            boolean computation = false;

            while (!computation) {
                if (currentBalance > 0) {
                    dollars = (int) (currentBalance / 1);
                    currentBalance -= dollars;
                }
                if (currentBalance > 0) {
                    quarters = (int) (currentBalance / 0.25);
                    currentBalance -= (quarters * 0.25);
                }
                if (currentBalance > 0) {
                    dimes = (int) (currentBalance / 0.10);
                    currentBalance -= dimes;
                }
                if (currentBalance > 0) {
                    nickels = (int) (currentBalance / 0.05);
                    currentBalance -= nickels;
                }
                if (currentBalance > 0) {
                    pennies = (int) (currentBalance / 0.01);
                    currentBalance -= pennies;
                }
                computation = true;
                System.out.println("Current Wallet is: " + currentBalance);
                System.out.println("your changes is: \n" + "Dollars: " + dollars + "\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies);

            }

            System.out.println("Thank you for using the Media Machine!");
        }
        if (userInput.contains("N") || userInput.contains("n")) {
            System.out.println("Thank you for donation \nOur Ceo needs a bonus");
        }
    }



}
