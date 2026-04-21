package com.DeaJayaNet.model.transaction; // Asumsi: package nanti diubah ke 'transaction'

import com.DeaJayaNet.dao.transaction.TransactionDao;
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

    private TransactionDao transactionDao = new TransactionDao();

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
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);

    }

    public Transaction(String userId, String packageId) {
        this.userId = userId;
        this.packageId = packageId;
        this.createdAt = generateCurrentTime();
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
    }

    public Transaction(String userId, String packageId, String orderId) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.createdAt = generateCurrentTime();
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
    }

    public Transaction(String userId, String packageId, String orderId, String type) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.createdAt = generateCurrentTime();
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.totalAmount = totalAmount;
        this.createdAt = generateCurrentTime();
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
    }

    public Transaction(String userId, String packageId, String orderId, String type, int totalAmount, String status) {
        this.userId = userId;
        this.packageId = packageId;
        this.orderId = orderId;
        this.type = type;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = generateCurrentTime();
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
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
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
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
        transactionDao.createTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString, this.createdAt);
    }

    // --- Setter ---
    public void setUserId(String userId) {
        this.userId = userId;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setOrderId(String orderId ) {
        this.orderId = orderId;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setType(String type) {
        this.type = type;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setStatus(String status) {
        this.status = status;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
    }

    public void setQrisString(String qrisString) {
        this.qrisString = qrisString;
        transactionDao.updateTransaction(this.userId, this.packageId, this.orderId, this.type, this.totalAmount, this.status, this.paymentMethod, this.qrisString);
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