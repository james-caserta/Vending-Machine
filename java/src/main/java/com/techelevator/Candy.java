package com.techelevator;

import java.math.BigDecimal;

public class Candy implements Vendables{

    private String location = null;
    private String name = null;
    private BigDecimal price = new BigDecimal("");
    private int stock = 5;
    private String makeSound = null;

//Constructor
    public Candy(String location, String name, BigDecimal price, int stock, String makeSound) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.makeSound = makeSound;
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
    public void setStock() {

    }

    public String getSound(){
        return "\"Munch Munch, Yum!\"";
    }

}
