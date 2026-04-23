package com.DeaJayaNet.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.food.FoodMenus; 

public class FoodMenusDao {

    // Cek apakah menu sudah ada
    public boolean checkFoodMenus(String menuName) {

        String sql = "SELECT count(*) FROM food_menus WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, menuName);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Menu sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false; // Menu belum ada
    }

    // Create
    public void createFoodMenus(String name, int price, int stock) {

        String sql = "INSERT INTO food_menus(name, price, stock) VALUES(?,?,?)";

        if (checkFoodMenus(name)) {
            System.out.println("Gagal menambahkan menu makanan: Menu '" + name + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, name);
                pstmt.setInt(2, price);
                pstmt.setInt(3, stock);
                pstmt.executeUpdate();

                System.out.println("Menu makanan '" + name + "' berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    // Read
    public void readFoodMenu(String name) {

        int id = getFoodMenuId(name);
        String sql = "SELECT * FROM food_menus WHERE food_menu_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Menu makanan: " + rs.getString("name") + "\n"
                     + "Harga: " + rs.getInt("price") + "\n"
                     + "Stok: " + rs.getInt("stock") + "\n");
                } else {
                    System.out.println("Menu makanan tidak ditemukan.\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Update
    public void updateFoodMenu(String name, int price, int stock) {

        int id = getFoodMenuId(name);
        String sql = "UPDATE food_menus SET price = ?, stock = ? WHERE food_menu_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, price);
            pstmt.setInt(2, stock);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("Menu makanan '" + name + "' berhasil diperbarui.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Delete
    public void deleteFoodMenu(String name) {
        
        int id = getFoodMenuId(name);
        String sql = "DELETE FROM food_menus WHERE food_menu_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Menu makanan '" + name + "' berhasil dihapus.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Mengambil ID berdasarkan nama menu
    public int getFoodMenuId(String name) {
        String sql = "SELECT food_menu_id FROM food_menus WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("food_menu_id");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
        return -1; // Menu makanan tidak ditemukan
    }

    

}