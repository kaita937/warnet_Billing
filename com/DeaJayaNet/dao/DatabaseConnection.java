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
                          "name TEXT, " +
                          "username TEXT UNIQUE, " +
                          "password TEXT, " +
                          "email TEXT UNIQUE, " +
                          "phone_number TEXT, " +
                          "role TEXT CHECK(role IN ('ADMIN', 'MEMBER', 'VIP')), " +
                          "remaining_time INTEGER DEFAULT 0 " +
                          ");";
                
        // 2. Table Computers
        String sqlComputers = "CREATE TABLE IF NOT EXISTS computers (" +
                              "computer_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "computer_number TEXT UNIQUE, " +
                              "computer_type TEXT CHECK(computer_type IN ('Regular', 'VIP')), " +
                              "is_unlocked BOOLEAN DEFAULT 0 " + 
                              ");";

        // 3. Table Transactions
        String sqlTransactions = "CREATE TABLE IF NOT EXISTS transactions (" +
                                 "transaction_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 "user_Id TEXT, " +
                                 "package_Id TEXT, " +
                                 "order_Id TEXT UNIQUE, " +
                                 "type TEXT CHECK(type IN ('PESANAN', 'BILLING')), " +
                                 "total_Amount INTEGER, " +
                                 "status TEXT CHECK(status IN ('PENDING', 'PAID', 'CANCELLED', 'REFUNDED', 'EXPIRED')), " +
                                 "payment_method TEXT, " +
                                 "qris_String TEXT, " +
                                 "created_At TEXT," +
                                 "FOREIGN KEY (user_Id) REFERENCES users(user_id), " +
                                 "FOREIGN KEY (package_Id) REFERENCES billing_packages(package_id), " +
                                 "FOREIGN KEY (order_Id) REFERENCES orders(order_id)" +
                                 ");";

        // 4. Table PaymentLog
        String sqlPaymentLog = "CREATE TABLE IF NOT EXISTS payment_logs (" +
                               "payment_log_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               "transaction_id INTEGER, " +
                               "payment_log_name TEXT UNIQUE, " +
                               "is_successful BOOLEAN, " +
                               "created_at TEXT, " +
                               "FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id)" +
                               ");";

         // 5. Table Food Menus
        String sqlFoodMenus = "CREATE TABLE IF NOT EXISTS food_menus (" +
                              "food_menu_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "name TEXT, " +
                              "price INTEGER, " +
                              "stock INTEGER" +
                              ");";

        // 6. Table Orders (Disinkronkan dengan OrderDao)
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

        // 7. Table Order Details
        String sqlOrderDetails = "CREATE TABLE IF NOT EXISTS order_details (" +
                                 "order_detail_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 "order_id INTEGER, " +
                                 "food_menu_id INTEGER, " +
                                 "quantity INTEGER, " +
                                "subtotal INTEGER, " +
                                 "FOREIGN KEY (order_id) REFERENCES orders(order_id), " +
                                 "FOREIGN KEY (food_menu_id) REFERENCES food_menus(food_menu_id)" +
                                 ");";

        // 8. Table Billing Packages
        String sqlBillingPackages = "CREATE TABLE IF NOT EXISTS billing_packages (" +
                                    "package_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "package_name TEXT, " +
                                    "duration_minutes INTEGER, " +
                                    "price INTEGER" +
                                    ");";

        // 9. Table Billing Sessions
        String sqlActiveSessions = "CREATE TABLE IF NOT EXISTS active_sessions (" +
                                    "session_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "user_id INTEGER, " +
                                    "computer_id INTEGER, " +
                                    "start_time INTEGER, " +
                                    "end_time INTEGER, " +
                                    "session_type TEXT CHECK(session_type IN ('MEMBER', 'NON_MEMBER')), " +
                                    "FOREIGN KEY (user_id) REFERENCES users(user_id), " +
                                    "FOREIGN KEY (computer_id) REFERENCES computers(computer_id)" +
                                    ");";

        String sqlSessionHistory = "CREATE TABLE IF NOT EXISTS history_sessions ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " user_id INTEGER,"
                + " computer_id INTEGER,"
                + " start_time INTEGER,"
                + " end_time INTEGER,"
                + " session_type TEXT"
                + ");";

        // Eksekusi semua query pembuatan tabel
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(sqlUsers);
            stmt.execute(sqlComputers);
            stmt.execute(sqlTransactions);
            stmt.execute(sqlPaymentLog);
            stmt.execute(sqlFoodMenus);
            // stmt.execute(sqlOrders);
            // stmt.execute(sqlOrderDetails);
            stmt.execute(sqlBillingPackages);
            stmt.execute(sqlActiveSessions);
            stmt.execute(sqlSessionHistory);
            
            // Boleh di-uncomment kalau lu mau ada log sukses pas aplikasi jalan
            // System.out.println("Semua tabel berhasil diverifikasi/dibuat.\n");

        } catch (SQLException e) {
            System.out.println("Gagal membuat tabel: " + e.getMessage() + "\n");
        }
    }
}