package com.example.bottledispenser;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;


public class BottleDispenser {

    private static BottleDispenser bDisp = new BottleDispenser();

    private int bottles;
    // The array for the Bottle-objects
    private ArrayList<Bottle> bottle_array;
    private double money;


    private BottleDispenser() {
        bottles = 5;
        money = 0;
        // Initialize the array
        bottle_array = new ArrayList<Bottle>();
        // Add Bottle-objects to the array b
        bottle_array.add(new Bottle());
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.90, 1.5, 2.2));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 0.5, 2.0));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 1.5, 2.5));
        bottle_array.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5, 1.95));
    }

    public static BottleDispenser getInstance() {
        return bDisp;
    }


    private void deleteBottle(int bottle) {
        bottle_array.remove(bottle);
    }

    public String addMoney(int amt) {
        money += amt;
         return "Klink! Added " + amt + " money!";
    }

    public String buyBottle(int btl) {
        if (money < bottle_array.get(btl).getPrice()) {
            return "Add money first!";
        } else {
            if (bottles == 0) {
                return "No more bottles!";
            } else {
                money -= bottle_array.get(btl).getPrice();
                bottles -= 1;
                String returnStr =  "KACHUNK! " + bottle_array.get(btl).getName() +
                        " came out of the dispenser!";
                deleteBottle(btl);
                return returnStr;
            }
        }
    }

    public String returnMoney() {
        DecimalFormat df = new DecimalFormat("##0.00");
        String returnStr = "Klink klink. Money came out! You got " + df.format(money) + "€ back";
        money = 0;
        return returnStr;
    }

    public ArrayList<String> listBottles() {
        ArrayList<String> returnArray = new ArrayList<String>();
        String returnStr = "";
        for (int i = 0; i < bottle_array.size(); i++) {
            returnStr = bottle_array.get(i).getName() + ", " + bottle_array.get(i).getSize() +
                    ", " + bottle_array.get(i).getPrice();
            returnArray.add(returnStr);
            returnStr = "";
//            Scanner sc = new Scanner(System.in);
        }
        return returnArray;

    }
}
