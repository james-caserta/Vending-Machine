package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void instantiationTestGum(){
        Gum gum = new Gum("D1", "U-Chews", new BigDecimal("0.85"));

        String actualLocation=gum.getLocation();
        String expectedLocation="D1";

        assertEquals(expectedLocation, actualLocation);

        String actualName=gum.getName();
        String expectedName="U-Chews";
        assertEquals(expectedName,actualName);

        BigDecimal actualPrice=gum.getPrice();
        BigDecimal expectedPrice=new BigDecimal("0.85");
        assertEquals(expectedPrice, actualPrice);

        int actualStock= gum.getStock();
        int expectedStock=5;
        assertEquals(expectedStock, actualStock);

        String actualSound=gum.getSound();
        String expectedSound="\"Chew Chew, Yum!\"";
        assertEquals(expectedSound,actualSound);

    }

    @Test
    public void testSetStock(){
        Gum gum = new Gum("D1", "U-Chews", new BigDecimal("0.85"));

        gum.setStock(4);
        int actualResult = gum.getStock();
        int expectedResult=4;

        assertEquals(expectedResult, actualResult);
    }

}