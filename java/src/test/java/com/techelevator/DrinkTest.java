package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void instantiationTestDrink(){
        Drink drink = new Drink("C1", "Cola", new BigDecimal("1.25"));

        String actualLocation=drink.getLocation();
        String expectedLocation="C1";

        assertEquals(expectedLocation, actualLocation);

        String actualName=drink.getName();
        String expectedName="Cola";
        assertEquals(expectedName,actualName);

        BigDecimal actualPrice=drink.getPrice();
        BigDecimal expectedPrice=new BigDecimal("1.25");
        assertEquals(expectedPrice, actualPrice);

        int actualStock= drink.getStock();
        int expectedStock=5;
        assertEquals(expectedStock, actualStock);

        String actualSound=drink.getSound();
        String expectedSound="\"Glug Glug, Yum!\"";
        assertEquals(expectedSound,actualSound);

    }

    @Test
    public void testSetStock(){
        Drink drink = new Drink("C1", "Cola", new BigDecimal("1.25"));

        drink.setStock(4);
        int actualResult = drink.getStock();
        int expectedResult=4;

        assertEquals(expectedResult, actualResult);
    }
}