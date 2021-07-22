package com.techelevator;

import java.math.BigDecimal;

public interface Vendables {
    String getName();
    String getLocation();
    BigDecimal getPrice();
    int getStock();
    void setStock(int amount);
    public String getSound();




}
