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
        this(); // Memanggil constructor kosong di atas buat otomatis set 'createdAt'
        this.userId = userId;
    }

    public Transaction(String userId, String packageId) {
        this(userId);
        this.packageId = packageId;
    }

    public Transaction(String userId, String packageId, String orderId) {
        this(userId, packageId);
        this.orderId = orderId;
    }

    public Transaction(String userId, String packageId, String orderId, String type) {
        this(userId, packageId, orderId);
        this.type = type;
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount) {
        this(userId, packageId, orderId, type);
        this.totalAmount = totalAmount;
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status) {
        this(userId, packageId, orderId, type, totalAmount);
        this.status = status;
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status, String paymentMethod) {
        this(userId, packageId, orderId, type, totalAmount, status);
        this.paymentMethod = paymentMethod;
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status, String paymentMethod, String qrisString) {
        this(userId, packageId, orderId, type, totalAmount, status, paymentMethod);
        this.qrisString = qrisString;
    }

    // --- Setter ---
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setOrderId(String orderId) {
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