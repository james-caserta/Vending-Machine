package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipTest {
    @Test
    public void instantiationTestChip(){
        Chip chip = new Chip("A1", "Potato Crisps", new BigDecimal("3.05"));

        String actualLocation=chip.getLocation();
        String expectedLocation="A1";

        assertEquals(expectedLocation, actualLocation);

        String actualName=chip.getName();
        String expectedName="Potato Crisps";
        assertEquals(expectedName,actualName);

        BigDecimal actualPrice=chip.getPrice();
        BigDecimal expectedPrice=new BigDecimal("3.05");
        assertEquals(expectedPrice, actualPrice);

        int actualStock= chip.getStock();
        int expectedStock=5;
        assertEquals(expectedStock, actualStock);

        String actualSound=chip.getSound();
        String expectedSound="\"Crunch Crunch, Yum!\"";
        assertEquals(expectedSound,actualSound);

    }

    @Test
    public void testSetStock(){
        Chip chip = new Chip("A1", "Potato Crisps", new BigDecimal("3.05"));

        chip.setStock(4);
        int actualResult = chip.getStock();
        int expectedResult=4;

        assertEquals(expectedResult, actualResult);
    }

}