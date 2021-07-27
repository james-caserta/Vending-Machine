package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void testAddStock(){
        VendingMachine vendingMachine = new VendingMachine();

        Vendables candy = new Candy("A1","TestCandy",new BigDecimal("2.55"));

        vendingMachine.addStock(candy);

        List <Vendables> vendableTestList = new ArrayList<>();
        vendableTestList.add(candy);

        List actualResult = vendingMachine.getVendablesList();
        List expectedResult = vendableTestList;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetItemStock(){
        VendingMachine vendingMachine = new VendingMachine();
        Vendables candy = new Candy("A1","TestCandy",new BigDecimal("2.55"));

        vendingMachine.addStock(candy);

        String actualStatus = vendingMachine.getItemStock("A1");
        String expectedStatus = "5";

        assertEquals(expectedStatus,actualStatus);

        candy.setStock(0);

        String actualStatus2 = vendingMachine.getItemStock("A1");
        String expectedStatus2 = "SOLD OUT";

        assertEquals(expectedStatus2,actualStatus2);

    }

    @Test
    public void testToString (){
        VendingMachine vendingMachine = new VendingMachine();
        Vendables candy = new Candy("A1","TestCandy",new BigDecimal("2.55"));

        vendingMachine.addStock(candy);

        String actualResult=vendingMachine.toString();
        String expectedResult="A1 TestCandy 2.55 5\n";

        assertEquals(expectedResult, actualResult);
    }

}