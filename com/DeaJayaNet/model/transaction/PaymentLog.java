package com.DeaJayaNet.model.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentLog {
    private int transactionId;
    private String PaymentLogName;
    private Boolean isSuccessful = true;
    private String createdAt;

    private String generateCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // --- Constructor
    public PaymentLog() {
        this.createdAt = generateCurrentTime();
    }

    public PaymentLog(int transactionId) {
        this.transactionId = transactionId;
        this.createdAt = generateCurrentTime();
    }

    public PaymentLog(int transactionId, String PaymentLogName) {
        this.transactionId = transactionId;
        this.PaymentLogName = PaymentLogName;
        this.createdAt = generateCurrentTime();
    }

    public PaymentLog(int transactionId, String PaymentLogName, Boolean isSuccessful) {
        this.transactionId = transactionId;
        this.PaymentLogName = PaymentLogName;
        this.isSuccessful = isSuccessful;
        this.createdAt = generateCurrentTime();
    }

    // --- Setter ---
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public void setPaymentLogName(String PaymentLogName) {
        this.PaymentLogName = PaymentLogName;
    }

    // --- Getter ---
    public int getTransactionId() {
        return this.transactionId;
    }

    public String getPaymentLogName() {
        return this.PaymentLogName;
    }

    public Boolean isSuccessful() {
        return this.isSuccessful;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

}