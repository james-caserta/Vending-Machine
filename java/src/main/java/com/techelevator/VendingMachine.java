package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Vendables> vendablesList = new ArrayList<>();

    @Override
    public String toString() {
        String output = "";
        for (Vendables v : vendablesList) {
            output += v.getLocation() + " " + v.getName() + " " + v.getPrice() + " " + v.getStock() + "\n";
        }
        return output;
    }

    public List<Vendables> getVendablesList() {
        return vendablesList;
    }

    public String getItemStock(String location) {
        String stockStatus = "";
        for (Vendables v : vendablesList) {
            if (v.getLocation().equals(location)) {
                if (v.getStock() == 0) {
                    stockStatus = "SOLD OUT";
                }
                else {
                    stockStatus = Integer.toString(v.getStock());
                }
            }
        }
        return stockStatus;
    }

    public void addStock(Vendables vendable) {
        vendablesList.add(vendable);
    }

}
