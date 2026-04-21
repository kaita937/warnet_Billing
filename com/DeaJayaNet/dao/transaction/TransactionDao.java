package com.DeaJayaNet.dao.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;

public class TransactionDao {

    // Autentikasi / Cek ketersediaan
    public boolean checkOrderid(String orderid) {

        String sql = "SELECT count(*) FROM transactions WHERE order_Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, orderid);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Order ID sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false; // Order ID belum ada
    }

    //create
    public void createTransaction(String userId, String packageId, String orderId, String type, int totalAmount, String status, String paymentMethod, String qrisString, String createdAt) {
        
        String sql = "INSERT INTO transactions(user_Id, package_Id, order_Id, type, total_Amount, status, payment_method, qris_String, created_At) VALUES(?,?,?,?,?,?,?,?,?)";

        if (checkOrderid(orderId)) {
            System.out.println("Gagal menambahkan transaction: Order ID '" + orderId + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, userId);
                pstmt.setString(2, packageId);
                pstmt.setString(3, orderId);
                pstmt.setString(4, type);
                pstmt.setInt(5, totalAmount);
                pstmt.setString(6, status);
                pstmt.setString(7, paymentMethod);
                pstmt.setString(8, qrisString);
                pstmt.setString(9, createdAt);
                pstmt.executeUpdate();
                System.out.println("Transaction dengan order id : " + orderId + " berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

    }

    //read
    public void readTransaction(String orderid) {
        int transactionId = getTransactionIdByOrderId(orderid);
        String sql = "SELECT * FROM transactions WHERE transaction_Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, transactionId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("transaction ID : " + rs.getString("transaction_id") + "\n"
                                 + "User ID : " + rs.getString("user_Id") + "\n"
                                 + "Package ID : " + rs.getString("package_Id") + "\n"
                                 + "Order ID : " + rs.getString("order_Id") + "\n"
                                 + "Type : " + rs.getString("type") + "\n"
                                 + "Total Amount : " + rs.getInt("total_Amount") + "\n"
                                 + "Status : " + rs.getString("status") + "\n"
                                 + "Payment Method : " + rs.getString("payment_method") + "\n"
                                 + "QRIS String : " + rs.getString("qris_String") + "\n"
                                 + "Created At : " + rs.getString("created_At") + "\n");
            } else {
                System.out.println("Transaction tidak ditemukan.");
            }
            System.out.println();
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    //update
    public void updateTransaction(String userId, String packageId, String orderId, String type, int totalAmount, String status, String paymentMethod, String qrisString) {
        int transactionId = getTransactionIdByOrderId(orderId);
        String sql = "UPDATE transactions SET user_Id = ?, package_Id = ?, order_Id = ?, type = ?, total_Amount = ?, status = ?, payment_method = ?, qris_String = ? WHERE transaction_Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, packageId);
            pstmt.setString(3, orderId);
            pstmt.setString(4, type);
            pstmt.setInt(5, totalAmount);
            pstmt.setString(6, status);
            pstmt.setString(7, paymentMethod);
            pstmt.setString(8, qrisString);
            pstmt.setInt(9, transactionId);
            pstmt.executeUpdate();

            System.out.println("Transaction dengan Order_ID '" + orderId + "' berhasil diperbarui di database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }


    //delete
    public void deleteTransaction(String orderid) {
        int transactionId = getTransactionIdByOrderId(orderid);
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, transactionId);
            pstmt.executeUpdate();
            
            System.out.println("Transaction dengan ID = " + transactionId + " berhasil dihapus.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public int getTransactionIdByOrderId(String orderId) {

        String sql = "SELECT transaction_id FROM transactions WHERE order_Id = ?";
        int transactionId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                transactionId = rs.getInt("transaction_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "\n");
        }

        return transactionId;
    }

}
