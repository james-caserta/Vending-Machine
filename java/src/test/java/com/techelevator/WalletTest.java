package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WalletTest {

    @Test
    public void testGetChange(){
        Wallet wallet = new Wallet();

        wallet.setCurrentBalance(new BigDecimal("1.15"));

        String actualResult = wallet.getChange();
        String expectedResult = "Your change is: 4 quarters, 1 dimes, 1 nickels.";

        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void testGetCurrentBalance(){
        Wallet wallet = new Wallet();

        BigDecimal actualResult = wallet.getCurrentBalance();
        BigDecimal expectedResult = new BigDecimal("0.00");

        assertEquals(expectedResult, actualResult);

        wallet.setCurrentBalance(new BigDecimal("1.00"));

        BigDecimal actualResult2 = wallet.getCurrentBalance();
        BigDecimal expectedResult2 = new BigDecimal("1.00");

        assertEquals(expectedResult2, actualResult2);

    }

}