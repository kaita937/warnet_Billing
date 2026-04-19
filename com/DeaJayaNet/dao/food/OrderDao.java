package com.DeaJayaNet.dao.food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.food.Order; 

public class OrderDao {
    // Create
    public void createOrder() {
        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO orders() VALUES()";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

            System.out.println("Order berhasil ditambahkan ke database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Read
    public void readOrder(int orderId) {
        DatabaseConnection.createNewTable();
        String sql = "SELECT * FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, orderId);
            ResultSet rs = psmt.executeQuery();

            // BUG FIX: Tambahkan rs.next() untuk mengecek ketersediaan data
            if (rs.next()) {
                System.out.println("Order ID : " + orderId);
                System.out.println("Total Price: " + rs.getInt("total_price"));   
            } else {
                System.out.println("Order tidak ditemukan.");
            }
            System.out.println();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Update
    public void updateOrder(int orderId, int totalPrice) {
        DatabaseConnection.createNewTable();
        String sql = "UPDATE orders SET total_price = ? WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, totalPrice);
            psmt.setInt(2, orderId);
            psmt.executeUpdate();

            System.out.println("Order dengan ID " + orderId + " berhasil diperbarui.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Delete
    public void deleteOrder(int orderId) {
        
        DatabaseConnection.createNewTable();
        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, orderId);
            psmt.executeUpdate();

            System.out.println("Order dengan ID " + orderId + " berhasil dihapus.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Mengambil ID pesanan terakhir
    public int getLatestOrderId() {
        DatabaseConnection.createNewTable();
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt("order_id");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
        
        return -1;
    }
}