package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String[] PURCHASE_OPTIONS = {"Feed money", "Select product", "Finish transaction"};
	private static final String[] FEED_OPTIONS = {"1", "2", "5","10","Return"};
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			//	vendingmachine.toString();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displaySecondLevelMenu();
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
				//	vendingmachine.toString();

			} else if (choice.equals("Finish transaction")) {
				//getChange();
				stay = false;
			}
		}
	}

	public void displayFeedMenu() {

		boolean stay = true;

		while (stay) {
			String choice = (String) menu.getChoiceFromOptions(FEED_OPTIONS);
			if (choice.equals("1")) {
				//wallet.setBalance(wallet.getBalance+1);
			} else if (choice.equals("2")) {
				//wallet.setBalance(wallet.getBalance+2);
			} else if (choice.equals("5")) {
				//wallet.setBalance(wallet.getBalance+5);
			} else if (choice.equals("10")) {
				//wallet.setBalance(wallet.getBalance+10);
			} else if (choice.equals("Return")) {
				stay = false;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void loadMachine(){
		VendingMachine vendingMachine = new VendingMachine();
		Wallet wallet = new Wallet();
		File vendingMachineInput = new File("vendingmachine.csv");

		try {
			Scanner fileScanner = new Scanner(vendingMachineInput);

			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("|");

				String location = lineArray[0];
				String name = lineArray[1];
				BigDecimal price = new BigDecimal(lineArray[2]);
				Vendables item;

				if (lineArray[3].equals("Chip")){
					item = new Chip(location, name, price);
					vendingMachine.addStock(item);
				} else if (lineArray[3].equals("Candy")){
					item = new Candy(location, name, price);
					vendingMachine.addStock(item);
				} else if (lineArray[3].equals("Drink")){
					item = new Drink(location, name, price);
					vendingMachine.addStock(item);
				} else if (lineArray[3].equals("Gum")) {
					item = new Gum(location, name, price);
					vendingMachine.addStock(item);
				}
			}
			////fdashfaiulhfuei




		} catch (FileNotFoundException e) {
			System.out.println("Error: file not found.");
		}
	}




}
