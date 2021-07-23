package com.techelevator;

import java.math.BigDecimal;

public class Chip implements Vendables{

    private String location = null;
    private String name = null;
    private BigDecimal price;
    private int stock = 5;
    private String makeSound = null;

//Constructor
    public Chip(String location, String name, BigDecimal price) {
        this.location = location;
        this.name = name;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int amount) {
        this.stock = this.stock - amount;
    }


    public String getSound(){
        return "\"Crunch Crunch, Yum!\"";
    }
}
