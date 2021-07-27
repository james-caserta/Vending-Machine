package com.techelevator;

import com.techelevator.view.Menu;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VendingMachineCLITest {

    @Test
    public void loadMachineHolder() {
        Wallet wallet = new Wallet();
        VendingMachine vendingMachine = new VendingMachine();
        Records records = new Records("log.txt");
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


        } catch (
                FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }

    @Test
    public void test_start_vend_out_of_stock() {
        Wallet wallet = new Wallet();
        VendingMachine vendingMachine = new VendingMachine();
        Records records = new Records("log.txt");
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


        } catch (
                FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }


       // actualResult =;
       // expectedResult =;
    }

    @Test
    public void test_start_vend_proper_vend() {
        Menu menu = new Menu(InputStream.nullInputStream(), OutputStream.nullOutputStream());
        VendingMachineCLI vendingMachineCLI = new VendingMachineCLI(menu);

        Wallet wallet = new Wallet();
        VendingMachine vendingMachine = new VendingMachine();
        Records records = new Records("log.txt");
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


        } catch (
                FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }

        wallet.setCurrentBalance(new BigDecimal("5.00"));

        vendingMachineCLI.startVend("D4");

        int actualStock = 0;
        for (Vendables v : vendingMachine.getVendablesList()) {
            if (v.getLocation().equals("D4")) {
                v.setStock(4);
                actualStock = v.getStock();
            }
        }
        int expectedStock = 4;

        assertEquals(expectedStock, actualStock);

        BigDecimal actualWallet = wallet.getCurrentBalance();
        BigDecimal expectedWallet = new BigDecimal("1.95");

        assertEquals(expectedWallet, actualWallet);

    }

    @Test
    public void test_start_vend_invalid_location() {
        Menu menu = new Menu(InputStream.nullInputStream(), OutputStream.nullOutputStream());
        VendingMachineCLI vendingMachineCLI = new VendingMachineCLI(menu);

        Wallet wallet = new Wallet();
        VendingMachine vendingMachine = new VendingMachine();
        Records records = new Records("log.txt");
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


        } catch (
                FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }

        wallet.setCurrentBalance(new BigDecimal("5.00"));

        String location = "D427";
        String actualResult = vendingMachineCLI.startVend(location);
        String expectedResult = "bad location";

        assertTrue(expectedResult.equals(actualResult));

    }
}

