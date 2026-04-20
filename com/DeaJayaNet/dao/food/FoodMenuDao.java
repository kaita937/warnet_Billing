package com.DeaJayaNet.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.food.FoodMenu; 

public class FoodMenuDao {
    // Create
    public void createFoodMenu(FoodMenu menu) {

        String sql = "INSERT INTO food_menus(name, price) VALUES(?,?)";

        if (checkMenu(menu.getName())) {
            System.out.println("Gagal menambahkan menu makanan: Menu '" + menu.getName() + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, menu.getName());
                pstmt.setInt(2, menu.getPrice());
                pstmt.executeUpdate();

                System.out.println("Menu makanan '" + menu.getName() + "' berhasil ditambahkan ke database.\n");
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
                    System.out.println("Menu makanan: " + rs.getString("name")
                                     + " dengan harga " + rs.getInt("price") + "\n");
                } else {
                    System.out.println("Menu makanan tidak ditemukan.\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Update
    public void updateFoodMenu(FoodMenu menu) {

        int id = getFoodMenuId(menu.getName());
        String sql = "UPDATE food_menus SET price = ? WHERE food_menu_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, menu.getPrice());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            System.out.println("Menu makanan '" + menu.getName() + "' berhasil diperbarui.\n");
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

    // Cek apakah menu sudah ada
    public boolean checkMenu(String name) {
        String sql = "SELECT food_menu_id FROM food_menus WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
        return false;
    }

}