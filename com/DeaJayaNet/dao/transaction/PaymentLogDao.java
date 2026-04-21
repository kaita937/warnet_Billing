package com.DeaJayaNet.dao.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;

public class PaymentLogDao {

    // Autentikasi / Cek ketersediaan
    public boolean checkPaymentLog(String paymentLogName) {

        String sql = "SELECT count(*) FROM payment_logs WHERE payment_log_name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, paymentLogName);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Payment log name sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false; // Payment log name belum ada
    }

    //create
    public void createPaymentLog(int transactionId, String paymentLogName, Boolean isSuccessful, String createdAt) {
        
        String sql = "INSERT INTO payment_logs(transaction_id, payment_log_name, is_successful, created_at) VALUES(?,?,?,?)";

        if (checkPaymentLog(paymentLogName)) {
            System.out.println("Gagal menambahkan payment log: Payment log name '" + paymentLogName + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, transactionId);
                pstmt.setString(2, paymentLogName);
                pstmt.setBoolean(3, isSuccessful);
                pstmt.setString(4, createdAt);
                pstmt.executeUpdate();
                System.out.println("Payment log dengan nama : " + paymentLogName + " berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

    }

    //read
    public void readPaymentLog(String paymentLogName) {
        int paymentLogId = getPaymentLogIdByName(paymentLogName);
        String sql = "SELECT * FROM payment_logs WHERE payment_log_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, paymentLogId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Payment Log ID : " + rs.getString("payment_log_id") + "\n"
                                 + "Transaction ID : " + rs.getString("transaction_id") + "\n"
                                 + "Payment Log Name : " + rs.getString("payment_log_name") + "\n"
                                 + "Is Successful : " + rs.getBoolean("is_successful") + "\n"
                                 + "Created At : " + rs.getString("created_at") + "\n");
            } else {
                System.out.println("Payment log tidak ditemukan.");
            }
            System.out.println();
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    //update
    public void updatePaymentLog(int transactionId, String paymentLogName, Boolean isSuccessful) {
        int paymentLogId = getPaymentLogIdByName(paymentLogName);
        String sql = "UPDATE payment_logs SET transaction_id = ?, payment_log_name = ?, is_successful = ? WHERE payment_log_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, transactionId);
            pstmt.setString(2, paymentLogName);
            pstmt.setBoolean(3, isSuccessful);
            pstmt.setInt(4, paymentLogId);
            pstmt.executeUpdate();
            System.out.println("Payment log dengan nama : " + paymentLogName + " berhasil diperbarui di database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }


    //delete
    public void deletePaymentLog(String paymentLogName) {
        int paymentLogId = getPaymentLogIdByName(paymentLogName);
        String sql = "DELETE FROM payment_logs WHERE payment_log_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, paymentLogId);
            pstmt.executeUpdate();
            
            System.out.println("Payment log dengan ID = " + paymentLogId + " berhasil dihapus.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public int getPaymentLogIdByName(String paymentLogName) {

        String sql = "SELECT payment_log_id FROM payment_logs WHERE payment_log_name = ?";
        int paymentLogId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, paymentLogName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                paymentLogId = rs.getInt("payment_log_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "\n");
        }

        return paymentLogId;
    }

}

