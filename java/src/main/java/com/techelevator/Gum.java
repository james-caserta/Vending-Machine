package com.techelevator;

import java.math.BigDecimal;

public class Gum implements Vendables{

    private String location = null;
    private String name = null;
    private BigDecimal price = new BigDecimal("");
    private int stock = 0;
    private String makeSound = null;

//Constructor


    public Gum(String location, String name, BigDecimal price, int stock, String makeSound) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.makeSound = makeSound;
    }


    @Override
    public String getSound() {
        return "\"Chew Chew, Yum!\"";
    }
}
