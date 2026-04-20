package com.DeaJayaNet.dao.computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.billing.BillingSession;

public class ComputerDao {
    // Autentikasi / Pengecekan
    public boolean checkComputerNumber(String computerNumber) {

        String sql = "SELECT count(*) FROM computers WHERE computer_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, computerNumber);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Nomor PC sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        return false; // Nomor PC belum ada
    }
    
    // Create
    public void createComputer(String computerNumber, boolean isUnlocked, String computerType){

        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO computers(computer_number, computer_type, is_unlocked) VALUES(?,?,?)";

        if (checkComputerNumber(computerNumber)) {
            System.out.println("Gagal menambahkan PC: Nomor PC '" + computerNumber + "' sudah ada.");
            System.out.println();
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, computerNumber);
                pstmt.setString(2, computerType);
                pstmt.setBoolean(3, isUnlocked);
                pstmt.executeUpdate();
                System.out.println("PC '" + computerNumber + "' berhasil ditambahkan ke database.");
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Read
    public void readComputer(String computerNumber) {

        int id = getIdByComputerNumber(computerNumber);

        DatabaseConnection.createNewTable();

        String sql = "SELECT * FROM computers WHERE computer_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID : " + rs.getString("computer_id") + "\n"
                                 + "Computer Number : " + rs.getString("computer_number") + "\n"
                                 + "Computer Type : " + rs.getString("computer_type") + "\n"
                                 + "Is Unlocked : " + rs.getBoolean("is_unlocked") + "\n"                    
                                );
                System.out.println();
            } else {
                System.out.println("PC tidak ditemukan.");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Update
    public void updateComputer(String computerNumber, boolean isUnlocked){
        
        DatabaseConnection.createNewTable();
        int id = getIdByComputerNumber(computerNumber);

        String sql = "UPDATE computers SET computer_number = ?, is_unlocked = ? WHERE computer_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, computerNumber);
            pstmt.setBoolean(2, isUnlocked);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("PC " + computerNumber + " berhasil diperbarui di database");
            System.out.println();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete
    public void deleteComputer (String computerNumber){

        DatabaseConnection.createNewTable();
        int id = getIdByComputerNumber(computerNumber);

        String sql = "DELETE FROM computers WHERE computer_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);     
            pstmt.executeUpdate();

            System.out.println("PC dengan ID = " + id + ", Nomor PC = " + computerNumber + " berhasil dihapus.");
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

// Get ID by PC Number
    public int getIdByComputerNumber(String computerNumber) {
        // Idealnya createNewTable() dihapus dari sini kalau udah dipanggil di main class
        DatabaseConnection.createNewTable(); 

        String sql = "SELECT computer_id FROM computers WHERE computer_number = ?";
        int computerId = -1; 

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, computerNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                computerId = rs.getInt("computer_id"); 
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println();
        }

        return computerId; 
    }
}