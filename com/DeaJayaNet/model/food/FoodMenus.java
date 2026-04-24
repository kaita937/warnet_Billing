package com.DeaJayaNet.model.food;

public class FoodMenus {
    
    private String name;
    private int price;
    private int stock;

    // Constructor
    public FoodMenus() {
    }

    public FoodMenus(String name) {
        this.name = name;
    }

    public FoodMenus(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public FoodMenus(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}