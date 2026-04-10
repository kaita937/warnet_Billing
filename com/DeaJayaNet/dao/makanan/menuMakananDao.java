package com.DeaJayaNet.dao.makanan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.makanan.menuMakanan;

public class menuMakananDao {

    // create
    public void createMenuMakanan(menuMakanan menu) {

        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO menu_makanan(nama_makanan, harga) VALUES(?,?)";

        if (checkmenu(menu.getNama_menu())) {
            System.out.println("Gagal menambahkan menu makanan: Menu '" + menu.getNama_menu() + "' sudah ada.");
            System.out.println();
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, menu.getNama_menu());
                pstmt.setInt(2, menu.getHarga());
                pstmt.executeUpdate();

                System.out.println("Menu makanan '" + menu.getNama_menu() + "' berhasil ditambahkan ke database.");
                System.out.println();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }

        }
    }

    // read
    public void ReadMenuMakanan(String nama_menu) {

        DatabaseConnection.createNewTable();

        int id = getIDMenuMakanan(nama_menu);
        String sql = "SELECT * FROM menu_makanan WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Menu makanan :" + rs.getString("nama_makanan")
                            + " dengan harga " + rs.getInt("harga"));
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // update
    public void updateMenuMakanan(menuMakanan menu) {

        DatabaseConnection.createNewTable();

        int id = getIDMenuMakanan(menu.getNama_menu());
        String sql = "UPDATE menu_makanan SET harga = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, menu.getHarga());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            System.out.println("Menu makanan '" + menu.getNama_menu() + "' berhasil diperbarui.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // delete
    public void deleteMenuMakanan(String nama_menu) {
        DatabaseConnection.createNewTable();
        int id = getIDMenuMakanan(nama_menu);
        String sql = "DELETE FROM menu_makanan WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Menu makanan '" + nama_menu + "' berhasil dihapus.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    public int getIDMenuMakanan(String nama_menu) {
        String sql = "SELECT id FROM menu_makanan WHERE nama_makanan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama_menu);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return -1; // Menu makanan tidak ditemukan
    }

    public boolean checkmenu(String nama_menu) {
        String sql = "SELECT id FROM menu_makanan WHERE nama_makanan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama_menu);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return false;
    }

}
