package com.DeaJayaNet.model.food;

import java.time.LocalDateTime;
import java.util.List;

// Asumsi: Class ini nantinya akan lu refactor juga jadi bahasa Inggris
import com.DeaJayaNet.model.computer.*;     // Sebelumnya: pc
import com.DeaJayaNet.model.user.*;   // Sebelumnya: pengguna

// Class diubah ke PascalCase
public class Order {
    
    private User user;                       // Pengganti 'pengguna'
    private Computer computer;               // Pengganti 'pc'
    private List<OrderDetail> orderDetails;  // Pengganti 'detail_pesanan'
    private int totalPrice;                  // Pengganti 'total_harga'
    private String paymentMethod;            // Pengganti 'metode_pembayaran'
    private String status;                   // Tetap 'status'
    private LocalDateTime orderTime;         // Pengganti 'waktu_pemesanan'

    public Order() {
    }

    public Order(User user, Computer computer, List<OrderDetail> orderDetails, String paymentMethod, String status, LocalDateTime orderTime) {
        this.user = user;
        this.computer = computer;
        this.orderDetails = orderDetails;
        this.totalPrice = calculateTotalPrice(); // Memanggil method yang udah di-rename
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.orderTime = orderTime;
    }

    // --- Getter & Setter ---

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    // Method 'hitungTotalHarga' diubah ke bahasa Inggris dengan camelCase
    public int calculateTotalPrice() {
        int total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.getSubtotal();
        }
        return total;
    }
}