package com.DeaJayaNet.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.food.Order;

public class OrderDao {

    // create
    public void createOrder(Order order) {
        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO orders (user_id, computer_id, status, order_time) " + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getComputerId());
            pstmt.setString(3, order.getStatus());
            pstmt.setString(4, order.getCreated_at());
            pstmt.executeUpdate();

            System.out.println("Order berhasil ditambahkan ke database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // read
    public void readOrder(int orderId) {
        DatabaseConnection.createNewTable();

        String sql = "SELECT * FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Order ID      : " + rs.getInt("order_id"));
                System.out.println("User ID       : " + rs.getInt("user_id"));
                System.out.println("Computer ID   : " + rs.getInt("computer_id"));
                System.out.println("Total Price   : " + rs.getInt("total_price"));
                System.out.println("Payment Method: " + rs.getString("payment_method"));
                System.out.println("Status        : " + rs.getString("status"));
                System.out.println("Order Time    : " + rs.getString("order_time"));
            } else {
                System.out.println("Order tidak ditemukan.");
            }
            System.out.println();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // update
    public void updateOrder(int orderId, Order order) {
        DatabaseConnection.createNewTable();

        String sql = "UPDATE orders SET user_id = ?, computer_id = ?, status = ? " +
                     "WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getComputerId());
            pstmt.setString(3, order.getStatus());
            pstmt.setInt(4, orderId);
            pstmt.executeUpdate();

            System.out.println("Order dengan ID " + orderId + " berhasil diperbarui.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // delete
    public void deleteOrder(int orderId) {
        DatabaseConnection.createNewTable();

        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();

            System.out.println("Order dengan ID " + orderId + " berhasil dihapus.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // get id
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

    public int getOrderIdByUserId(int userId) {
        DatabaseConnection.createNewTable();

        String sql = "SELECT order_id FROM orders WHERE user_id = ? ORDER BY order_id DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("order_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }

        return -1;
    }

    // cek ordernya ada atau engga, dan apakah order itu milik user yang lagi login atau bukan
    public boolean orderExists(int orderId) {
        DatabaseConnection.createNewTable();

        String sql = "SELECT order_id FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false;
    }

    public boolean orderBelongsToUser(int orderId, int userId) {
        DatabaseConnection.createNewTable();

        String sql = "SELECT order_id FROM orders WHERE order_id = ? AND user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false;
    }
}