package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    private static final String[] PURCHASE_OPTIONS = {"Feed money", "Select product", "Finish transaction"};
    private static final String[] FEED_OPTIONS = {"1", "2", "5", "10", "Return"};
    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }


    private Wallet wallet = new Wallet();
    private VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        loadMachine();
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                System.out.println(vendingMachine.toString());
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                displaySecondLevelMenu();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(0);
            } else {
                choice = null;
            }
        }
    }

    public void displaySecondLevelMenu() {

        boolean stay = true;

        while (stay) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_OPTIONS);
            if (choice.equals("Feed money")) {
                displayFeedMenu();
            } else if (choice.equals("Select product")) {
                System.out.println(vendingMachine.toString());
                Scanner userInput = new Scanner(System.in);
                System.out.println("Enter Product Code:");
                String location = userInput.nextLine().toUpperCase();
                startVend(location);

            } else if (choice.equals("Finish transaction")) {
                System.out.println(wallet.getChange());
                stay = false;
            } else {
                choice = null;
            }
            System.out.println("Current Money Provided: $" + wallet.getCurrentBalance());
        }
    }

    public void displayFeedMenu() {

        boolean stay = true;

        while (stay) {
            String choice = (String) menu.getChoiceFromOptions(FEED_OPTIONS);
            if (choice.equals("1")) {
                wallet.setCurrentBalance(wallet.getCurrentBalance().add(new BigDecimal("1")));
            } else if (choice.equals("2")) {
                wallet.setCurrentBalance(wallet.getCurrentBalance().add(new BigDecimal("2")));
            } else if (choice.equals("5")) {
                wallet.setCurrentBalance(wallet.getCurrentBalance().add(new BigDecimal("5")));
            } else if (choice.equals("10")) {
                wallet.setCurrentBalance(wallet.getCurrentBalance().add(new BigDecimal("10")));
            } else if (choice.equals("Return")) {
                stay = false;
            } else {
                choice = null;
            }
            //System.out.println("Current Money Provided: $"+wallet.getCurrentBalance());
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void loadMachine() {
        File vendingMachineInput = new File("vendingmachine.csv");

        try {
            Scanner fileScanner = new Scanner(vendingMachineInput);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|");

                String location = lineArray[0];
                String name = lineArray[1];
                BigDecimal price = new BigDecimal(lineArray[2]);
                Vendables item;

                if (lineArray[3].equals("Chip")) {
                    item = new Chip(location, name, price);
                    vendingMachine.addStock(item);
                } else if (lineArray[3].equals("Candy")) {
                    item = new Candy(location, name, price);
                    vendingMachine.addStock(item);
                } else if (lineArray[3].equals("Drink")) {
                    item = new Drink(location, name, price);
                    vendingMachine.addStock(item);
                } else if (lineArray[3].equals("Gum")) {
                    item = new Gum(location, name, price);
                    vendingMachine.addStock(item);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }

    public void startVend(String location) {
        int counter = 0;
        for (Vendables v : vendingMachine.getVendablesList()) {
            if (v.getLocation().equals(location)) {
                if (!vendingMachine.getItemStock(location).equals("SOLD OUT")) {
                    if (v.getPrice().compareTo(wallet.getCurrentBalance()) > 0) {
                        System.out.println("Insufficient Funds");
                        }
                    else {
                        wallet.setCurrentBalance(wallet.getCurrentBalance().subtract(v.getPrice()));
                        v.setStock(v.getStock() - 1);
                        System.out.println(v.getSound());
                        //salesCount++;
                        }
                    }
                System.out.println("Stock: " + vendingMachine.getItemStock(location));
                }
            counter++;
            if (counter > 16) {
                System.out.println("Invalid Item Location");
                }
            }
        }
    }



