package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void instantiationTestCandy(){
        Candy candy = new Candy("B1", "Moonpie", new BigDecimal("1.80"));

        String actualLocation=candy.getLocation();
        String expectedLocation="B1";

        assertEquals(expectedLocation, actualLocation);

        String actualName=candy.getName();
        String expectedName="Moonpie";
        assertEquals(expectedName,actualName);

        BigDecimal actualPrice=candy.getPrice();
        BigDecimal expectedPrice=new BigDecimal("1.80");
        assertEquals(expectedPrice, actualPrice);

        int actualStock= candy.getStock();
        int expectedStock=5;
        assertEquals(expectedStock, actualStock);

        String actualSound=candy.getSound();
        String expectedSound="\"Munch Munch, Yum!\"";
        assertEquals(expectedSound,actualSound);

    }

    @Test
    public void testSetStock(){
        Candy candy = new Candy("B1", "Moonpie", new BigDecimal("1.80"));

        candy.setStock(4);
        int actualResult = candy.getStock();
        int expectedResult=4;

        assertEquals(expectedResult, actualResult);
    }
}