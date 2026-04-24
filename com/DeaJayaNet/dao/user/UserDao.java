package com.DeaJayaNet.dao.user; // Package diubah menyesuaikan
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.user.Member;
import com.DeaJayaNet.model.user.Admin;
import com.DeaJayaNet.model.user.Vip;

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
    
    // Create Member
    public Boolean createUserMember(Member member) {

        String sql = "INSERT INTO users(name, username, password, email, phone_number, role, remaining_time) VALUES(?,?,?,?,?,?,?)";

        if (checkUsername(member.getUsername())) {
            System.out.println("Gagal menambahkan user: Username '" + member.getUsername() + "' sudah ada.\n");
            return false;
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, member.getName());
                pstmt.setString(2, member.getUsername());
                pstmt.setString(3, member.getPassword());
                pstmt.setString(4, member.getEmail());
                pstmt.setString(5, member.getPhoneNumber());
                pstmt.setString(6, member.getRole());
                pstmt.setInt(7, member.getRemainingTime());
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
                return false;
            }
        }
    }

    // Create VIP
    public Boolean createUserVIP(Vip vip) {

        String sql = "INSERT INTO users(name, username, password, email, phone_number, role, remaining_time) VALUES(?,?,?,?,?,?,?)";

        if (checkUsername(vip.getUsername())) {
            System.out.println("Gagal menambahkan user: Username '" + vip.getUsername() + "' sudah ada.\n");
            return false;
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, vip.getName());
                pstmt.setString(2, vip.getUsername());
                pstmt.setString(3, vip.getPassword());
                pstmt.setString(4, vip.getEmail());
                pstmt.setString(5, vip.getPhoneNumber());
                pstmt.setString(6, vip.getRole());
                pstmt.setInt(7, vip.getRemainingTime());
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
                return false;
            }
        }
    }

    // Create Admin
    public Boolean createUserAdmin(Admin admin) {

        String sql = "INSERT INTO users(name, username, password, email, phone_number, role, remaining_time) VALUES(?,?,?,?,?,?,?)";

        if (checkUsername(admin.getUsername())) {
            System.out.println("Gagal menambahkan user: Username '" + admin.getUsername() + "' sudah ada.\n");
            return false;
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, admin.getName());
                pstmt.setString(2, admin.getUsername());
                pstmt.setString(3, admin.getPassword());
                pstmt.setString(4, admin.getEmail());
                pstmt.setString(5, admin.getPhoneNumber());
                pstmt.setString(6, admin.getRole());
                pstmt.setInt(7, admin.getRemainingTime());
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
                return false;
            }
        }
    }

    // // Read
    // public void readUser(String username) {
    //     int userId = getIdByUsername(username);
    //     String sql = "SELECT * FROM users WHERE user_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
    //         pstmt.setInt(1, userId);
    //         ResultSet rs = pstmt.executeQuery();

    //         if (rs.next()) {
    //             System.out.println("ID : " + rs.getString("user_id") + "\n"
    //                              + "Name : " + rs.getString("name") + "\n"
    //                              + "Username : " + rs.getString("username") + "\n"
    //                              + "Password : " + rs.getString("password") + "\n"
    //                              + "Email : " + rs.getString("email") + "\n"
    //                              + "Phone Number : " + rs.getString("phone_number") + "\n"
    //                              + "Role : " + rs.getString("role") + "\n"
    //                                 + "Remaining Time : " + rs.getInt("remaining_time") + " minutes\n"
    //                              );
    //         } else {
    //             System.out.println("User tidak ditemukan.");
    //         }
    //         System.out.println();
            
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // Update
    // public void updateUser(String name, String username, String password, String email, String phoneNumber, String role, int remainingTime) {
    //     int userId = getIdByUsername(username);
    //     String sql = "UPDATE users SET name = ?, username = ?, password = ?, email = ?, phone_number = ?, role = ?, remaining_time = ? WHERE user_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
    //         pstmt.setString(1, name);   
    //         pstmt.setString(2, username);
    //         pstmt.setString(3, password);
    //         pstmt.setString(4, email);
    //         pstmt.setString(5, phoneNumber);
    //         pstmt.setString(6, role);
    //         pstmt.setInt(7, remainingTime);
    //         pstmt.executeUpdate();
            
    //         System.out.println("User '" + username + "' berhasil diperbarui di database.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // Delete
    // public void deleteUser(String username) {
    //     int userId = getIdByUsername(username);
    //     String sql = "DELETE FROM users WHERE user_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, userId);
    //         pstmt.executeUpdate();
            
    //         System.out.println("User dengan ID = " + userId + ", Username = " + username + " berhasil dihapus.\n");
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // public int getIdByUsername(String username) {

    //     String sql = "SELECT user_id FROM users WHERE username = ?";
    //     int userId = -1;

    //     try(Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
    //         pstmt.setString(1, username);
    //         ResultSet rs = pstmt.executeQuery();

    //         if (rs.next()) {
    //             userId = rs.getInt("user_id");
    //         }

    //     } catch (SQLException e) {
    //         System.out.println(e.getErrorCode() + "\n");
    //     }

    //     return userId;
    // }

    // // Method checkLogin (sebelumnya cekLogin)
    // public boolean checkLogin(String username, String password) {

    //     String sql = "SELECT password FROM users WHERE username = ?";
        
    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
    //         pstmt.setString(1, username);
    //         ResultSet rs  = pstmt.executeQuery();
            
    //         // Cek apakah ada hasil dan passwordnya cocok
    //         if (rs.next() && rs.getString("password").equals(password)) {
    //             return true;
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    //     return false;
    // }
}