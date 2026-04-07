package com.DeaJayaNet.dao.pc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.billing.billingSession;

public class pcDao {

    // Autentikasi
    public boolean checkNoPc(String nomor_pc) {

        String sql = "SELECT count(*) FROM pc WHERE nomor_pc = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nomor_pc);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; // Nomor PC sudah ada
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println();
        }

        return false; // Nomor PC belum ada
    }
    
    //create
    public void createPc(String nomor_pc, boolean status, String tipe_pc){

        DatabaseConnection.createNewTable();

        String sql = "INSERT INTO pc(nomor_pc, tipe_pc, status) VALUES(?,?,?)";

        if (checkNoPc(nomor_pc)) {
            System.out.println("Gagal menambahkan pc: No_Pc '" + nomor_pc + "' sudah ada.");
            System.out.println();
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nomor_pc);
                pstmt.setString(2, tipe_pc);
                pstmt.setBoolean(3, status);
                pstmt.executeUpdate();
                System.out.println("PC '" + nomor_pc + "' berhasil ditambahkan ke database.");
                System.out.println();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }

    //read
    public void readPc(String nomor_pc) {

        int id = getIdByNoPc(nomor_pc);

        DatabaseConnection.createNewTable();

        String sql = "SELECT * FROM pc WHERE id_pc = ?";

        try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("id : " + rs.getString("id_pc") + "\n"
                            + "nomor_pc : " + rs.getString("nomor_pc") + "\n"
                            + "tipe_pc : " + rs.getString("tipe_pc") + "\n"
                            + "status : " + rs.getBoolean("status") + "\n"                    
                            );
            System.out.println();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }

    //update
    public void updatePc(String nomor_pc, boolean status){
        
        DatabaseConnection.createNewTable();
        int id = getIdByNoPc(nomor_pc);

        String sql = "UPDATE pc SET nomor_pc = ?, status = ? WHERE id_pc = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nomor_pc);
            pstmt.setBoolean(2, status);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("PC " + nomor_pc + " berhasil diperbarui di database");
            System.out.println();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    //delete
    public void deletePc (String nomor_pc){

        DatabaseConnection.createNewTable();
        int id = getIdByNoPc(nomor_pc);

        String sql = "DELETE FROM pc WHERE id_pc = ?";

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);     
            pstmt.executeUpdate();

            System.out.println("PC dengan id = " + id + ", nomor_pc = " + nomor_pc + " berhasil dihapus.");
            System.out.println();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public int getIdByNoPc(String nomor_pc) {

        DatabaseConnection.createNewTable();

        String sql = "SELECT id_pc FROM pc WHERE nomor_pc = ?";
        int userId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nomor_pc);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("id_pc");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println();
        }

        return userId;

    }

}
