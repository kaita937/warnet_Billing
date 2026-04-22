package com.DeaJayaNet.dao.user; // Package diubah menyesuaikan
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;

public class UserDao {

    // Autentikasi / Cek ketersediaan
    public boolean checkUsername(String username) {

        String sql = "SELECT count(*) FROM users WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Username sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false; // Username belum ada
    }
    
    // Create
    public void createUser(String name, String username, String password, String email, String phoneNumber, String role, int remainingTime) {

        String sql = "INSERT INTO users(name, username, password, email, phone_number, role, remaining_time) VALUES(?,?,?,?,?,?,?)";

        if (checkUsername(username)) {
            System.out.println("Gagal menambahkan user: Username '" + username + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, username);
                pstmt.setString(3, password);
                pstmt.setString(4, email);
                pstmt.setString(5, phoneNumber);
                pstmt.setString(6, role);
                pstmt.setInt(7, remainingTime);
                pstmt.executeUpdate();
                System.out.println("User '" + username + "' berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    // Read
    public void readUser(String username) {
        int userId = getIdByUsername(username);
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID : " + rs.getString("user_id") + "\n"
                                 + "Name : " + rs.getString("name") + "\n"
                                 + "Username : " + rs.getString("username") + "\n"
                                 + "Password : " + rs.getString("password") + "\n"
                                 + "Email : " + rs.getString("email") + "\n"
                                 + "Phone Number : " + rs.getString("phone_number") + "\n"
                                 + "Role : " + rs.getString("role") + "\n"
                                    + "Remaining Time : " + rs.getInt("remaining_time") + " minutes\n"
                                 );
            } else {
                System.out.println("User tidak ditemukan.");
            }
            System.out.println();
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Update
    public void updateUser(String name, String username, String password, String email, String phoneNumber, String role, int remainingTime) {
        int userId = getIdByUsername(username);
        String sql = "UPDATE users SET name = ?, username = ?, password = ?, email = ?, phone_number = ?, role = ?, remaining_time = ? WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);   
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, role);
            pstmt.setInt(7, remainingTime);
            pstmt.executeUpdate();
            
            System.out.println("User '" + username + "' berhasil diperbarui di database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Delete
    public void deleteUser(String username) {
        int userId = getIdByUsername(username);
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
            
            System.out.println("User dengan ID = " + userId + ", Username = " + username + " berhasil dihapus.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public int getIdByUsername(String username) {

        String sql = "SELECT user_id FROM users WHERE username = ?";
        int userId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("user_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "\n");
        }

        return userId;
    }

    // Method checkLogin (sebelumnya cekLogin)
    public boolean checkLogin(String username, String password) {

        String sql = "SELECT password FROM users WHERE username = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            pstmt.setString(1, username);
            ResultSet rs  = pstmt.executeQuery();
            
            // Cek apakah ada hasil dan passwordnya cocok
            if (rs.next() && rs.getString("password").equals(password)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
        return false;
    }
}