package com.DeaJayaNet.model.food;

import com.DeaJayaNet.dao.food.FoodMenusDao;

public class FoodMenus {
    
    private String name;
    private int price;
    private int stock;

    FoodMenusDao foodMenusDao = new FoodMenusDao();

    // Constructor
    public FoodMenus() {
        foodMenusDao.createFoodMenus(this.name, this.price, this.stock);
    }

    public FoodMenus(String name) {
        this.name = name;
        foodMenusDao.createFoodMenus(this.name, this.price, this.stock);
    }

    public FoodMenus(String name, int price) {
        this.name = name;
        this.price = price;
        foodMenusDao.createFoodMenus(this.name, this.price, this.stock);
    }

    public FoodMenus(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        foodMenusDao.createFoodMenus(this.name, this.price, this.stock);
    }

    // --- Getter & Setter ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        foodMenusDao.updateFoodMenu(name, price, stock);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        foodMenusDao.updateFoodMenu(name, price, stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        foodMenusDao.updateFoodMenu(name, price, stock);
    }
}