package com.DeaJayaNet.model.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentLog {
    private int transactionId;
    private int totalAmount;
    private Boolean isSuccessful;
    private String createdAt;

    // Helper method buat DRY (Don't Repeat Yourself)
    private String generateCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // --- Constructor Chaining ---
    public PaymentLog() {
        this.createdAt = generateCurrentTime();
        this.isSuccessful = false;
    }

    public PaymentLog(int transactionId) {
        this(); // Memanggil constructor kosong di atas buat set createdAt & isSuccessful
        this.transactionId = transactionId;
    }

    public PaymentLog(int transactionId, int totalAmount) {
        this(transactionId); // Memanggil constructor di atasnya
        this.totalAmount = totalAmount;
    }

    // --- Setter ---
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }  

    public void setSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    // --- Getter ---
    public int getTransactionId() {
        return this.transactionId;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    // Untuk tipe Boolean, best practice penamaannya biasa tidak pakai 'get' jika sudah ada prefix 'is' atau sejenisnya
    public Boolean isSuccessful() {
        return this.isSuccessful;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

}