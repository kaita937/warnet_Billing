package com.DeaJayaNet.model.food;

import com.DeaJayaNet.dao.food.OrderDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    
    private String orderCode;
    private int userId;                      
    private int computerId;              
    private String status;                   
    private String created_at;

    OrderDao orderDao = new OrderDao();
    
    private String generateCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Order() {
        this.created_at = generateCurrentTime();
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public Order(String orderCode) {
        this.orderCode = orderCode;
        this.created_at = generateCurrentTime();
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public Order(String orderCode, int userId) {
        this.orderCode = orderCode;
        this.userId = userId;
        this.created_at = generateCurrentTime();
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public Order(String orderCode, int userId, int computerId) {
        this.orderCode = orderCode;
        this.userId = userId;
        this.computerId = computerId;
        this.created_at = generateCurrentTime();
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public Order(String orderCode, int userId, int computerId, String status) {
        this.orderCode = orderCode;
        this.userId = userId;
        this.computerId = computerId;
        this.status = status;
        this.created_at = generateCurrentTime();
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    // --- Getter & Setter ---

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
        orderDao.updateOrder(orderCode, userId, computerId, status, created_at);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
        orderDao.createOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        orderDao.updateOrder(this.orderCode, this.userId, this.computerId, this.status, this.created_at);
    }

    public String getCreated_at() {
        return created_at;
    }

}