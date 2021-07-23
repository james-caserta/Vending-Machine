package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Wallet {

    private BigDecimal currentBalance = new BigDecimal("0.00");

    public BigDecimal getCurrentBalance(){
        return this.currentBalance;
    }

    public void setCurrentBalance(BigDecimal amount){
        this.currentBalance = amount;
    }

    public String getChange() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        String change = "";
        while (currentBalance.compareTo(currentBalance.subtract(new BigDecimal("0.25"))) >=0) {
            currentBalance.subtract(new BigDecimal("0.25"));
            quarters++;
        }
        while (currentBalance.compareTo(currentBalance.subtract(new BigDecimal("0.10"))) >=0) {
            currentBalance.subtract(new BigDecimal("0.10"));
            dimes++;
        }
        while (currentBalance.compareTo(currentBalance.subtract(new BigDecimal("0.05"))) >=0) {
            currentBalance.subtract(new BigDecimal("0.05"));
            nickels++;
        }
        change = "Your change is: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels."
        return change;
    }










}
