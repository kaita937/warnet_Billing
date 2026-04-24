package com.DeaJayaNet.dao.billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;

public class BillingPackageDao {
    
    // Autentikasi / Pengecekan
    public boolean checkPackageName(String packageName) {

        String sql = "SELECT count(*) FROM billing_packages WHERE package_name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, packageName);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false;
    }

    // Create
    public void createBillingPackage(String packageName, int durationMinutes, int price) {

        String sql = "INSERT INTO billing_packages(package_name, duration_minutes, price) VALUES(?,?,?)";

        if (checkPackageName(packageName)) {
            System.out.println("Gagal menambahkan paket billing: nama paket '" + packageName + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, packageName);
                pstmt.setInt(2, durationMinutes);
                pstmt.setInt(3, price);
                pstmt.executeUpdate();
                
                System.out.println("Paket billing '" + packageName + "' berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    // Read
    public void readBillingPackage(String packageName) {
        int id = getIdByPackageName(packageName);
        String sql = "SELECT * FROM billing_packages WHERE package_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID : " + rs.getString("package_id") + "\n"
                                 + "Package Name : " + rs.getString("package_name") + "\n"
                                 + "Duration (Minutes) : " + rs.getInt("duration_minutes") + "\n"
                                 + "Price : " + rs.getInt("price") + "\n"
                                 );
            } else {
                System.out.println("Paket billing '" + packageName + "' tidak ditemukan.");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Update
    public void updateBillingPackage(String packageName, int durationMinutes, int price) {
        int id = getIdByPackageName(packageName);
        String sql = "UPDATE billing_packages SET package_name = ?, duration_minutes = ?, price = ? WHERE package_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, packageName);
            pstmt.setInt(2, durationMinutes);
            pstmt.setInt(3, price);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

            System.out.println("Paket billing '" + packageName + "' berhasil diperbarui di database.\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Delete
    public void deleteBillingPackage(String packageName) {
        int id = getIdByPackageName(packageName);
        String sql = "DELETE FROM billing_packages WHERE package_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            System.out.println("Paket billing dengan ID = " + id + ", nama paket = " + packageName + " berhasil dihapus.\n");

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    // Get ID 
    public int getIdByPackageName(String packageName) {

        String sql = "SELECT package_id FROM billing_packages WHERE package_name = ?";
        int packageId = -1;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, packageName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                packageId = rs.getInt("package_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "\n");
        }

        return packageId;
    }
}