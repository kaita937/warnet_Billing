package com.DeaJayaNet.model.food;

public class OrderDetail {
    
    private int orderId;          
    private int foodMenuId;
    private int quantity;       
    private int subtotal;   

    // Constructor
    public OrderDetail() {
    }   

    public OrderDetail(int orderId) {
        this.orderId = orderId;
    }

    public OrderDetail(int orderId, int foodMenuId) {
        this.orderId = orderId;
        this.foodMenuId = foodMenuId;
    }

    public OrderDetail(int orderId, int foodMenuId, int quantity) {
        this.orderId = orderId;
        this.foodMenuId = foodMenuId;
        this.quantity = quantity;
    }

    public OrderDetail(int orderId, int foodMenuId, int quantity, int subtotal) {
        this.orderId = orderId;
        this.foodMenuId = foodMenuId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // --- Getter & Setter ---
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodMenuId() {
        return foodMenuId;
    }

    public void setFoodMenuId(int foodMenuId) {
        this.foodMenuId = foodMenuId;
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