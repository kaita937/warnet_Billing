package com.DeaJayaNet.model.food;

import com.DeaJayaNet.dao.food.OrderDetailDao;

public class OrderDetail {
    
    private int orderId;          
    private int foodMenuId;
    private int quantity;       
    private int subtotal;   
    
    OrderDetailDao orderDetailDao = new OrderDetailDao();

    // Constructor
    public OrderDetail() {
        orderDetailDao.createOrderDetail(this.orderId, this.foodMenuId, this.quantity, this.subtotal);
    }   

    public OrderDetail(int orderId) {
        this.orderId = orderId;
        orderDetailDao.createOrderDetail(this.orderId, this.foodMenuId, this.quantity, this.subtotal);
    }

    public OrderDetail(int orderId, int foodMenuId) {
        this.orderId = orderId;
        this.foodMenuId = foodMenuId;
        orderDetailDao.createOrderDetail(this.orderId, this.foodMenuId, this.quantity, this.subtotal);
    }

    public OrderDetail(int orderId, int foodMenuId, int quantity) {
        this.orderId = orderId;
        this.foodMenuId = foodMenuId;
        this.quantity = quantity;
        orderDetailDao.createOrderDetail(this.orderId, this.foodMenuId, this.quantity, this.subtotal);
    }

    public OrderDetail(int orderId, int foodMenuId, int quantity, int subtotal) {
        this.orderId = orderId;
        this.foodMenuId = foodMenuId;
        this.quantity = quantity;
        this.subtotal = subtotal;
        orderDetailDao.createOrderDetail(this.orderId, this.foodMenuId, this.quantity, this.subtotal);
    }

    // --- Getter & Setter ---
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
        orderDetailDao.updateOrderDetail(orderId, foodMenuId, quantity, subtotal);
    }

    public int getFoodMenuId() {
        return foodMenuId;
    }

    public void setFoodMenuId(int foodMenuId) {
        this.foodMenuId = foodMenuId;
        orderDetailDao.updateOrderDetail(orderId, foodMenuId, quantity, subtotal);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        orderDetailDao.updateOrderDetail(orderId, foodMenuId, quantity, subtotal);
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
        orderDetailDao.updateOrderDetail(orderId, foodMenuId, quantity, subtotal);
    }
}