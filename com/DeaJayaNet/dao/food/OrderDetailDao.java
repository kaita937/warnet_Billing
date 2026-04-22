package com.DeaJayaNet.dao.food;
import com.DeaJayaNet.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDao {

    // revisi
    // buat method autentikasi orderDetailed di tabel
    // buat method get id
    // ubah method CRUD karena atribut dan kolomnya diganti
    // buat kolom dari artribut model kedalam database connection

    // Create
    public void createOrderDetail(int orderId, int foodMenuId, int quantity) {
        // Ingat saran sebelumnya: idealnya createNewTable() ini dihapus kalau udah dipanggil di Main
        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO order_details(order_id, food_menu_id, quantity) VALUES(?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, foodMenuId);
            pstmt.setInt(3, quantity);
            pstmt.executeUpdate();

            System.out.println("Order detail berhasil ditambahkan ke database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Read
    public void readOrderDetail(int orderDetailId) {
        DatabaseConnection.createNewTable();
        String sql = "SELECT * FROM order_details WHERE order_detail_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)){

            psmt.setInt(1, orderDetailId);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                System.out.println("Order Detail ID: " + orderDetailId);
                System.out.println("Food Menu ID: " + rs.getInt("food_menu_id") 
                                 + ", Quantity: " + rs.getInt("quantity"));   
            } else {
                System.out.println("Order detail tidak ditemukan.");
            }
            System.out.println();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Update 
    public void updateOrderDetail(int orderDetailId, int foodMenuId, int quantity) {
        DatabaseConnection.createNewTable();
        String sql = "UPDATE order_details SET food_menu_id = ?, quantity = ? WHERE order_detail_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)){

            psmt.setInt(1, foodMenuId);
            psmt.setInt(2, quantity);
            psmt.setInt(3, orderDetailId);
            psmt.executeUpdate();

            System.out.println("Order detail berhasil diperbarui.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Delete
    public void deleteOrderDetail(int orderDetailId) {
        DatabaseConnection.createNewTable();
        
        String sql = "DELETE FROM order_details WHERE order_detail_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)){

            psmt.setInt(1, orderDetailId);
            psmt.executeUpdate();

            System.out.println("Order detail dengan ID " + orderDetailId + " berhasil dihapus.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
}