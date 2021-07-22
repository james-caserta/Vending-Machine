package com.techelevator;

import com.techelevator.view.Menu;

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
}
