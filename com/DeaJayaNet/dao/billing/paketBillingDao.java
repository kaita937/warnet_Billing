package com.DeaJayaNet.dao.billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;

public class paketBillingDao {

	// Autentikasi
	public boolean checkNamaPaket(String nama_paket) {

		String sql = "SELECT count(*) FROM paket_billing WHERE nama_paket = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nama_paket);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) {
					return true; // Nama paket sudah ada
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println();
		}

		return false; // Nama paket belum ada
	}

	// Create
	public void createPaketBilling(String nama_paket, int durasi_menit, int harga) {

		DatabaseConnection.createNewTable();

		String sql = "INSERT INTO paket_billing(nama_paket, durasi_menit, harga) VALUES(?,?,?)";

		if (checkNamaPaket(nama_paket)) {
			System.out.println("Gagal menambahkan paket billing: nama paket '" + nama_paket + "' sudah ada.");
			System.out.println();
		} else {
			try (Connection conn = DatabaseConnection.getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, nama_paket);
				pstmt.setInt(2, durasi_menit);
				pstmt.setInt(3, harga);
				pstmt.executeUpdate();
				System.out.println("Paket billing '" + nama_paket + "' berhasil ditambahkan ke database.");
				System.out.println();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
	}

	// Read
	public void readPaketBilling(String nama_paket) {

		int id = getIdByNamaPaket(nama_paket);

		DatabaseConnection.createNewTable();

		String sql = "SELECT * FROM paket_billing WHERE id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("id : " + rs.getString("id") + "\n"
								 + "nama paket : " + rs.getString("nama_paket") + "\n"
								 + "durasi menit : " + rs.getInt("durasi_menit") + "\n"
								 + "harga : " + rs.getInt("harga") + "\n"
								 );
				System.out.println();
			} else {
				System.out.println("Paket billing '" + nama_paket + "' tidak ditemukan.");
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	// Update
	public void updatePaketBilling(String nama_paket, int durasi_menit, int harga) {

		DatabaseConnection.createNewTable();
		int id = getIdByNamaPaket(nama_paket);

		String sql = "UPDATE paket_billing SET nama_paket = ?, durasi_menit = ?, harga = ? WHERE id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nama_paket);
			pstmt.setInt(2, durasi_menit);
			pstmt.setInt(3, harga);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

			System.out.println("Paket billing '" + nama_paket + "' berhasil diperbarui di database.");
			System.out.println();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	// Delete
	public void deletePaketBilling(String nama_paket) {

		int id = getIdByNamaPaket(nama_paket);

		DatabaseConnection.createNewTable();

		String sql = "DELETE FROM paket_billing WHERE id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Paket billing dengan id = " + id + ", nama paket = " + nama_paket + " berhasil dihapus.");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	public int getIdByNamaPaket(String nama_paket) {

		DatabaseConnection.createNewTable();

		String sql = "SELECT id FROM paket_billing WHERE nama_paket = ?";
		int paketId = -1;

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nama_paket);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				paketId = rs.getInt("id");
			}

		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println();
		}

		return paketId;
	}
}
