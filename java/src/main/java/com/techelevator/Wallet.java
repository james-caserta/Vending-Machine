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


        while (currentBalance.compareTo(new BigDecimal("0")) >0) {
            BigDecimal subtractedBalance = currentBalance.subtract(new BigDecimal("0.25"));
            if(subtractedBalance.compareTo(new BigDecimal("0")) >=0) {
                currentBalance = currentBalance.subtract(new BigDecimal("0.25")).setScale(2, RoundingMode.HALF_UP);
                quarters++;
            }
            else{
                break;
            }
        }
        while (currentBalance.compareTo(new BigDecimal("0")) >0) {
            BigDecimal subtractedBalance = currentBalance.subtract(new BigDecimal("0.10"));
            if(subtractedBalance.compareTo(new BigDecimal("0")) >=0) {
                currentBalance = currentBalance.subtract(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_UP);
                dimes++;
            }
            else{
                break;
            }
        }
        while (currentBalance.compareTo(new BigDecimal("0")) >0) {
            BigDecimal subtractedBalance = currentBalance.subtract(new BigDecimal("0.05"));
            if(subtractedBalance.compareTo(new BigDecimal("0")) >=0) {
                currentBalance = currentBalance.subtract(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
                nickels++;
            }
            else{
                break;
            }
        }
        change = "Your change is: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.";
        return change;
    }









}
