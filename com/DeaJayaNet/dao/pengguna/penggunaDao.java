package com.DeaJayaNet.dao.pengguna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;

public class penggunaDao {

    // Autentikasi
    public boolean checkUsername(String username) {

        String sql = "SELECT count(*) FROM pengguna WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Username sudah ada
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println();
        }

        return false; // Username belum ada
    }
    
    // Create
    public void createPengguna(String nama, String username, String password, String email, String noTelp, String role) {

        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO pengguna(nama, username, password, email, noTelp, role) VALUES(?,?,?,?,?,?)";

        if (checkUsername(username)) {
            System.out.println("Gagal menambahkan pengguna: Username '" + username + "' sudah ada.");
            System.out.println();
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nama);
                pstmt.setString(2, username);
                pstmt.setString(3, password);
                pstmt.setString(4, email);
                pstmt.setString(5, noTelp);
                pstmt.setString(6, role); 
                pstmt.executeUpdate();
                System.out.println("Pengguna '" + username + "' berhasil ditambahkan ke database.");
                System.out.println();
            } catch (SQLException e) {
                // TODO: handle exception
                System.out.println(e.getMessage()); 
            }
        }
    }

    // Read
    public void readPengguna(String username) {

        int id = getIdByUsername(username);

        DatabaseConnection.createNewTable();

        String sql = "SELECT * FROM pengguna WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("id : " + rs.getString("id") + "\n"
                             + "nama : " + rs.getString("nama") + "\n"
                             + "username : " + rs.getString("username") + "\n"
                             + "password : " + rs.getString("password") + "\n"
                             + "email : " + rs.getString("email") + "\n"
                             + "no telp : " + rs.getString("noTelp") + "\n"
                             + "role : " + rs.getString("role") + "\n"
                             );
            System.out.println();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // Update
    public void updatePengguna(String nama, String username, String password, String email, String noTelp, String role) {

        DatabaseConnection.createNewTable();
        int userId = getIdByUsername(username);

        String sql = "UPDATE pengguna SET nama = ?, username = ?, password = ?, email = ?, noTelp = ?, role = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama);   
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, email);
            pstmt.setString(5, noTelp);
            pstmt.setString(6, role);
            pstmt.setInt(7, userId);
            pstmt.executeUpdate();
            System.out.println("Pengguna '" + username + "' berhasil diperbarui di database.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // Delete
    public void deletePengguna(String username) {

        int id = getIdByUsername(username);

        DatabaseConnection.createNewTable();

        String sql = "DELETE FROM pengguna WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("pengguna dengan id = " + id + ", username = " + username + " berhasil dihapus.");
            System.out.println();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println();
        }

    }

    public int getIdByUsername(String username) {

        DatabaseConnection.createNewTable();

        String sql = "SELECT id FROM pengguna WHERE username = ?";
        int userId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println();
        }

        return userId;

    }

    public boolean cekLogin(String username, String password) {

        DatabaseConnection.createNewTable();

        String sql = "SELECT password FROM pengguna WHERE username = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            pstmt.setString(1, username);
            ResultSet rs  = pstmt.executeQuery();
            
            // Cek apakah ada hasil dan passwordnya cocok
            if (rs.next() && rs.getString("password").equals(password)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return false;
    }

}
