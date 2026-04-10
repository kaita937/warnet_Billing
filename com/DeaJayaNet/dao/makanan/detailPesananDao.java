package com.DeaJayaNet.dao.makanan;
import com.DeaJayaNet.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class detailPesananDao {
    // create
    public void createDetailPesanan(int id_pesanan, int id_menu_makanan, int jumlah) {

        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO detail_pesanan(id_pesanan, id_menu_makanan, jumlah) VALUES(?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_pesanan);
            pstmt.setInt(2, id_menu_makanan);
            pstmt.setInt(3, jumlah);
            pstmt.executeUpdate();

            System.out.println("Detail pesanan berhasil ditambahkan ke database.");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    //read
    public void ReadDetailPesanan(int id_detail_pesanan) {
        DatabaseConnection.createNewTable();
        String sql = "SELECT * FROM detailPesanan WHERE id_detail_pesanan = ?";

        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, id_detail_pesanan);
            ResultSet rs = psmt.executeQuery();

            System.out.println("Detail pesanan :" + id_detail_pesanan);
            System.out.println("ID Menu Makanan: " + rs.getInt("id_menu_makanan") 
            + ", Jumlah: " + rs.getInt("jumlah"));   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

    }

    //update 
    
    //delete
}
