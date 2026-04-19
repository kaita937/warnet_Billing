package com.DeaJayaNet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:warnet.db"; 
    private static Connection instance = null;

    public DatabaseConnection() {
    }

    public static Connection getConnection() {
        try {
            if (instance == null || instance.isClosed()) {
                instance = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage() + "\n");
        }
        return instance;
    }

    // Method ini cukup dipanggil SEKALI di Main class lu pas aplikasi pertama kali jalan
    public static void createNewTable() {
        // 1. Table Users
        String sqlUsers = "CREATE TABLE IF NOT EXISTS users (" +
                          "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          "name TEXT NOT NULL, " +
                          "username TEXT NOT NULL UNIQUE, " +
                          "password TEXT NOT NULL, " +
                          "email TEXT NOT NULL UNIQUE, " +
                          "phone_number TEXT, " +
                          "role TEXT NOT NULL CHECK(role IN ('Admin', 'Member', 'VIP')), " +
                          "remaining_time INTEGER DEFAULT 0 " +
                          ");";
                
        // 2. Table Computers
        String sqlComputers = "CREATE TABLE IF NOT EXISTS computers (" +
                              "computer_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "computer_number TEXT NOT NULL UNIQUE, " +
                              "computer_type TEXT NOT NULL CHECK(computer_type IN ('Regular', 'VIP')), " +
                              "is_unlocked BOOLEAN NOT NULL DEFAULT 0 " + 
                              ");";

        // 3. Table Billing Sessions
        String sqlBillingSessions = "CREATE TABLE IF NOT EXISTS billing_sessions (" +
                                    "session_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "user_id INTEGER, " +
                                    "computer_id INTEGER NOT NULL, " +
                                    "start_time TEXT NOT NULL, " +
                                    "end_time TEXT, " +
                                    "status TEXT NOT NULL CHECK(status IN ('ACTIVE', 'FINISHED')), " +
                                    "session_type TEXT NOT NULL CHECK(session_type IN ('MEMBER', 'GUEST')), " +
                                    "FOREIGN KEY (user_id) REFERENCES users(user_id), " +
                                    "FOREIGN KEY (computer_id) REFERENCES computers(computer_id)" +
                                    ");";

        // 4. Table Billing Packages
        String sqlBillingPackages = "CREATE TABLE IF NOT EXISTS billing_packages (" +
                                    "package_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "package_name TEXT, " +
                                    "duration_minutes INTEGER, " +
                                    "price INTEGER" +
                                    ");";

        // 5. Table Transactions
        String sqlTransactions = "CREATE TABLE IF NOT EXISTS transactions (" +
                                 "transaction_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 "payment_method TEXT, " +
                                 "amount_paid INTEGER, " +
                                 "status TEXT" +
                                 ");";

        // 6. Table Food Menus
        String sqlFoodMenus = "CREATE TABLE IF NOT EXISTS food_menus (" +
                              "food_menu_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "name TEXT, " +
                              "price INTEGER" +
                              ");";

        // 7. Table Orders (Disinkronkan dengan OrderDao)
        String sqlOrders = "CREATE TABLE IF NOT EXISTS orders (" +
                           "order_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "user_id INTEGER, " +
                           "computer_id INTEGER, " +
                           "total_price INTEGER, " +
                           "payment_method TEXT, " +
                           "status TEXT, " +
                           "order_time TEXT, " +
                           "FOREIGN KEY (user_id) REFERENCES users(user_id), " +
                           "FOREIGN KEY (computer_id) REFERENCES computers(computer_id)" +
                           ");";

        // 8. Table Order Details
        String sqlOrderDetails = "CREATE TABLE IF NOT EXISTS order_details (" +
                                 "order_detail_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 "order_id INTEGER, " +
                                 "food_menu_id INTEGER, " +
                                 "quantity INTEGER, " +
                                 "FOREIGN KEY (order_id) REFERENCES orders(order_id), " +
                                 "FOREIGN KEY (food_menu_id) REFERENCES food_menus(food_menu_id)" +
                                 ");";

        // Eksekusi semua query pembuatan tabel
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(sqlUsers);
            stmt.execute(sqlComputers);
            stmt.execute(sqlBillingSessions);
            stmt.execute(sqlBillingPackages); // Udah di-uncomment biar ke-create
            stmt.execute(sqlTransactions);
            stmt.execute(sqlFoodMenus);
            stmt.execute(sqlOrders);
            stmt.execute(sqlOrderDetails);

            // Boleh di-uncomment kalau lu mau ada log sukses pas aplikasi jalan
            // System.out.println("Semua tabel berhasil diverifikasi/dibuat.\n");

        } catch (SQLException e) {
            System.out.println("Gagal membuat tabel: " + e.getMessage() + "\n");
        }
    }
}