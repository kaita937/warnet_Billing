package com.DeaJayaNet.model.transaction; // Asumsi: package nanti diubah ke 'transaction'

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String userId;
    private String packageId;
    private String orderId;
    private String type;
    private int totalAmount;
    private String status;
    private String paymentMethod;
    private String qrisString;
    private String createdAt;

    // Helper method biar DRY (nggak ngulang-ngulang nulis format waktu)
    private String generateCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Transaction() {
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId) {
        this.userId = userId;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId) {
        this.userId = userId;
        this.packageId = packageId;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId, String orderId) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId, String orderId, String type) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.totalAmount = totalAmount;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status, String paymentMethod) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.createdAt = generateCurrentTime();
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status, String paymentMethod, String qrisString) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.qrisString = qrisString;
        this.createdAt = generateCurrentTime();
    }

    // --- Setter ---
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setOrderId(String orderId ) {
        this.orderId = orderId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setQrisString(String qrisString) {
        this.qrisString = qrisString;
    }

    // --- Getter ---
    public String getUserId() {
        return this.userId;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getType() {
        return this.type;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getQrisString() {
        return this.qrisString;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}