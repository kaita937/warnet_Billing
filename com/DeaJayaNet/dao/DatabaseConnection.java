package com.DeaJayaNet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    
    private static final String URL = "jdbc:sqlite:users.db"; 
    private static Connection instance = null; 

    public DatabaseConnection() {
    }

    public static Connection getConnection() {

        try {
            if (instance == null || instance.isClosed()) {
                instance = DriverManager.getConnection(URL);
                // System.out.println("Koneksi ke database berhasil.");
                // System.out.println();
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println();
        }

        return instance;

    }

    public static void createNewTable() {

        //pengguna
        String sqlPengguna = "CREATE TABLE IF NOT EXISTS pengguna (\n"
                + " id integer PRIMARY KEY,\n"
                + " nama text,\n"
                + " username text NOT NULL,\n"
                + " password text NOT NULL,\n"
                + " email text,\n"
                + " noTelp text,\n"
                + " role text\n"
                + ");";

        //pc
        String sqlPc = "CREATE TABLE IF NOT EXISTS pc ("
                     + "id_pc INTEGER PRIMARY KEY, "
                     + "nomor_pc TEXT, "
                     + "tipe_pc TEXT, "
                     + "status boolean"
                     + ");";

        //billing
        String sqlBillingSession = "CREATE TABLE IF NOT EXISTS billing_session ("
                + "id INTEGER PRIMARY KEY, "
                + "id_pc INTEGER, "
                + "username TEXT, "
                + "waktu_mulai TEXT, "
                + "waktu_selesai TEXT, "
                + "durasi INTEGER, "
                + "status TEXT, "
                + "FOREIGN KEY (id_pc) REFERENCES pc(id_pc), "
                + "FOREIGN KEY (username) REFERENCES pengguna(username)"
                + ");";

        String sqlPaketBilling = "";

        //transaksi
        String sqlTransaksi = "CREATE TABLE IF NOT EXISTS transaksi ("
                     + "id INTEGER PRIMARY KEY, "
                     + "metode_pembayaran TEXT, "
                     + "jumlah_bayar INTEGER, "
                     + "status TEXT"
                     + ");";

        String sqlPaymentlog = "";

        //pesanan makanan
        String sqlPesanan = "";

        String sqlDetailPesanan = "";

        String sqlMenuMakanan = "CREATE TABLE IF NOT EXISTS menu_makanan ("
                     + "id INTEGER PRIMARY KEY, "
                     + "nama_menu TEXT, "
                     + "harga INTEGER"
                     + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            //pengguna
            stmt.execute(sqlPengguna);

            //pc
            stmt.execute(sqlPc);

            //billing
            stmt.execute(sqlBillingSession);
            // stmt.execute(sqlPaketBilling);

            //transaksi
            stmt.execute(sqlTransaksi);
            // stmt.execute(sqlPaymentlog);

            //pesanan makanan
            // stmt.execute(sqlPesanan);
            // stmt.execute(sqlDetailPesanan);
            stmt.execute(sqlMenuMakanan);

            // System.out.println("Tabel 'pengguna' dan 'pc' berhasil dibuat atau sudah ada.");
            // System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

}
