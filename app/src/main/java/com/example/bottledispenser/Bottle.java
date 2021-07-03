package com.example.bottledispenser;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double bottle_size;
    private double price;

    public Bottle() {
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3;
        bottle_size = 0.5;
        price = 1.80;

    }

    public Bottle(String new_name, String manuf, double totE, double size, double cost) {
        name = new_name;
        manufacturer = manuf;
        total_energy = totE;
        bottle_size = size;
        price = cost;

    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getEnergy() {
        return total_energy;
    }

    public double getSize() {
        return bottle_size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double new_price) {
        price = new_price;
    }

}
