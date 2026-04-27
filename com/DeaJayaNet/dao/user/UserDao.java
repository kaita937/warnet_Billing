package com.DeaJayaNet.dao.user; // Package diubah menyesuaikan
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.user.Member;
import com.DeaJayaNet.model.user.User;
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

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    switch (role) {
                        case "ADMIN":
                            return new Admin(rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("phone_number"), rs.getInt("remaining_time"));
                        case "MEMBER":
                            return new Member(rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("phone_number"), rs.getInt("remaining_time"));
                        case "VIP":
                            return new Vip(rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("phone_number"), rs.getInt("remaining_time"));
                        default:
                            return null;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}