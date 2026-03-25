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
        String sqlPengguna = "CREATE TABLE IF NOT EXISTS pengguna (\n"
                + " id integer PRIMARY KEY,\n"
                + " nama text,\n"
                + " username text NOT NULL,\n"
                + " password text NOT NULL,\n"
                + " email text,\n"
                + " noTelp text,\n"
                + " role text\n"
                + ");";

        String sqlPc = "CREATE TABLE IF NOT EXISTS pc ("
                     + "id_pc INTEGER PRIMARY KEY, "
                     + "nomor_pc TEXT, "
                     + "tipe_pc TEXT, "
                     + "status text default 'terkunci'"
                     + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlPengguna);
            stmt.execute(sqlPc);
            // System.out.println("Tabel 'pengguna' dan 'pc' berhasil dibuat atau sudah ada.");
            // System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

}
