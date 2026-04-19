package com.DeaJayaNet.model.food;

public class FoodMenu {
    
    private String name;
    private int price;

    // Constructor kosong
    public FoodMenu() {
    }

    // Constructor dengan nama saja
    public FoodMenu(String name) {
        this.name = name;
    }

    // Constructor lengkap
    public FoodMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // --- Getter & Setter ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}