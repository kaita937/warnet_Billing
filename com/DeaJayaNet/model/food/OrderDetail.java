package com.DeaJayaNet.model.food;

public class OrderDetail {
    
    private FoodMenus foodMenu; 
    private int quantity;       // Pengganti 'jumlah'
    private int subtotal;       // Tetap 'subtotal'

    public OrderDetail() {
    }

    public OrderDetail(FoodMenus foodMenu, int quantity) {
        this.foodMenu = foodMenu;
        this.quantity = quantity;
        // Asumsi method getHarga() di class FoodMenu udah lu ubah jadi getPrice()
        this.subtotal = foodMenu.getPrice() * quantity; 
    }

    // --- Getter & Setter ---
    public FoodMenus getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenus foodMenu) {
        this.foodMenu = foodMenu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}