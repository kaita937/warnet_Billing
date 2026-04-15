package com.DeaJayaNet.dao.makanan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.makanan.pesanan;

public class pesananDao {
    //create
    public void createPesanan() {
        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO pesanan() VALUES()";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

            System.out.println("Pesanan berhasil ditambahkan ke database.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        
    }

    //read

    public void ReadPesanan(int id_pesanan) {
        DatabaseConnection.createNewTable();
        String sql = "SELECT * FROM pesanan WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, id_pesanan);
            ResultSet rs = psmt.executeQuery();

            System.out.println("Pesanan ID :" + id_pesanan);
            System.out.println("Total Harga: " + rs.getInt("total_harga"));   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

    }

    //update
    public void updatePesanan(int id_pesanan, int total_harga) {
        DatabaseConnection.createNewTable();
        String sql = "UPDATE pesanan SET total_harga = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, total_harga);
            psmt.setInt(2, id_pesanan);
            psmt.executeUpdate();

            System.out.println("Pesanan dengan ID " + id_pesanan + " berhasil diperbarui.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    //delete

    public void deletePesanan(int id_pesanan) {
        DatabaseConnection.createNewTable();
        String sql = "DELETE FROM pesanan WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, id_pesanan);
            psmt.executeUpdate();

            System.out.println("Pesanan dengan ID " + id_pesanan + " berhasil dihapus.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    public int getIDPesanan() {
        DatabaseConnection.createNewTable();
        String sql = "SELECT id FROM pesanan ORDER BY id DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return -1; // Return -1 if no pesanan is found
    }
}