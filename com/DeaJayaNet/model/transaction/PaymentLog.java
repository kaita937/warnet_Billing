package com.DeaJayaNet.model.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.DeaJayaNet.dao.transaction.PaymentLogDao;

public class PaymentLog {
    private int transactionId;
    private String PaymentLogName;
    private Boolean isSuccessful = true;
    private String createdAt;

    private PaymentLogDao paymentLogDao = new PaymentLogDao();

    private String generateCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // --- Constructor
    public PaymentLog() {
        this.createdAt = generateCurrentTime();
        paymentLogDao.createPaymentLog(this.transactionId, this.PaymentLogName, this.isSuccessful, this.createdAt);
    }

    public PaymentLog(int transactionId) {
        this.transactionId = transactionId;
        this.createdAt = generateCurrentTime();
        paymentLogDao.createPaymentLog(this.transactionId, this.PaymentLogName, this.isSuccessful, this.createdAt);
    }

    public PaymentLog(int transactionId, String PaymentLogName) {
        this.transactionId = transactionId;
        this.PaymentLogName = PaymentLogName;
        this.createdAt = generateCurrentTime();
        paymentLogDao.createPaymentLog(this.transactionId, this.PaymentLogName, this.isSuccessful, this.createdAt);
    }

    public PaymentLog(int transactionId, String PaymentLogName, Boolean isSuccessful) {
        this.transactionId = transactionId;
        this.PaymentLogName = PaymentLogName;
        this.isSuccessful = isSuccessful;
        this.createdAt = generateCurrentTime();
        paymentLogDao.createPaymentLog(this.transactionId, this.PaymentLogName, this.isSuccessful, this.createdAt);
    }

    // --- Setter ---
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
        paymentLogDao.updatePaymentLog(transactionId, PaymentLogName, isSuccessful);
    }

    public void setSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
        paymentLogDao.updatePaymentLog(transactionId, PaymentLogName, isSuccessful);
    }

    public void setPaymentLogName(String PaymentLogName) {
        this.PaymentLogName = PaymentLogName;
        paymentLogDao.updatePaymentLog(transactionId, PaymentLogName, isSuccessful);
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