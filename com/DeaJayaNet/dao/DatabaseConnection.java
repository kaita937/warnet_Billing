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
        String sqlPengguna = "CREATE TABLE IF NOT EXISTS pengguna (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                             "nama TEXT NOT NULL, " +
                             "username TEXT NOT NULL UNIQUE, " +
                             "password TEXT NOT NULL, " +
                             "email TEXT NOT NULL UNIQUE, " +
                             "noTelp TEXT, " +
                             "role TEXT NOT NULL CHECK(role IN ('ADMIN', 'MEMBER')), " +
                             "remaining_time INTEGER DEFAULT 0 " +
                             ");";
                

        //pc
        String sqlPc = "CREATE TABLE IF NOT EXISTS pc (" +
                       "id_pc INTEGER PRIMARY KEY AUTOINCREMENT, " +
                       "nomor_pc TEXT NOT NULL UNIQUE, " +
                       "tipe_pc TEXT NOT NULL CHECK(tipe_pc IN ('REGULER', 'VIP')), " +
                       "status TEXT NOT NULL CHECK(status IN ('IDLE', 'IN_USE', 'OFFLINE', 'RUSAK')) " +
                       ");";

        //billing
        String sqlBillingSession = "CREATE TABLE IF NOT EXISTS billing_session (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "user_id INTEGER," +
                                    "pc_id INTEGER NOT NULL," +
                                    "start_time INTEGER NOT NULL," +
                                    "end_time INTEGER," +
                                    "status TEXT NOT NULL CHECK(status IN ('ACTIVE', 'FINISHED'))," +
                                    "session_type TEXT NOT NULL CHECK(session_type IN ('MEMBER', 'NON_MEMBER'))," +
                                    "FOREIGN KEY (user_id) REFERENCES pengguna(id)," +
                                    "FOREIGN KEY (pc_id) REFERENCES pc(id_pc)" +
                                    ");";

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
        String sqlPesanan = "CREATE TABLE IF NOT EXISTS pesanan ("
                     + "id INTEGER PRIMARY KEY, "
                     + "username TEXT, "
                     + "id_pc INTEGER, "
                     + "waktu_pesan TEXT, "
                     + "status TEXT, "
                     + "FOREIGN KEY (username) REFERENCES pengguna(username), "
                     + "FOREIGN KEY (id_pc) REFERENCES pc(id_pc)"
                     + ");";

        String sqlDetailPesanan = "CREATE TABLE IF NOT EXISTS detail_pesanan ("
                     + "id INTEGER PRIMARY KEY, "
                     + "id_pesanan INTEGER, "
                     + "id_menu INTEGER, "
                     + "jumlah INTEGER, "
                     + "FOREIGN KEY (id_pesanan) REFERENCES pesanan(id), "
                     + "FOREIGN KEY (id_menu) REFERENCES menu_makanan(id)"
                     + ");";

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
            stmt.execute(sqlPesanan);
            stmt.execute(sqlDetailPesanan);
            stmt.execute(sqlMenuMakanan);

            // System.out.println("Tabel 'pengguna' dan 'pc' berhasil dibuat atau sudah ada.");
            // System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

}
