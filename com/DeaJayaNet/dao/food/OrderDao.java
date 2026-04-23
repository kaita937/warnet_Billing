package com.DeaJayaNet.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.food.Order;

public class OrderDao {

    //check session di database
    public boolean checkOrder(String orderCode) {

        String sql = "SELECT count(*) FROM orders WHERE order_code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, orderCode);

            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; //  orders sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false; // orders belum ada
    }

    //create
    public void createOrder(String orderCode, int userId, int computerId, String status, String created_at) {
        
        String sql = "INSERT INTO orders(order_code, user_id, computer_id, status, created_at) VALUES(?,?,?,?,?)";

        if (checkOrder(orderCode)) {
            System.out.println("Gagal menambahkan order: order code : " + orderCode + " sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, orderCode);
                pstmt.setInt(2, userId);
                pstmt.setInt(3, computerId);
                pstmt.setString(4, status);
                pstmt.setString(5, created_at);
                pstmt.executeUpdate();
                System.out.println("Order dengan order code : " + orderCode + " berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

    }

    //read
    public void readOrder(String orderCode) {
        int orderId = getOrderIdByOrderCode(orderCode);
        String sql = "SELECT * FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Order ID : " + rs.getInt("order_id") + "\n"
                                 + "Order Code : " + rs.getString("order_code") + "\n"
                                 + "User ID : " + rs.getInt("user_id") + "\n"
                                 + "Computer ID : " + rs.getInt("computer_id") + "\n"
                                 + "Status : " + rs.getString("status") + "\n"
                                 + "Created At : " + rs.getString("created_at") + "\n");
            } else {
                System.out.println("Order tidak ditemukan.");
            }
            System.out.println();
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    //update
    public void updateOrder(String orderCode, int userId, int computerId, String status, String created_at) {
        int orderId = getOrderIdByOrderCode(orderCode);
        String sql = "UPDATE orders SET user_id = ?, computer_id = ?, status = ?, created_at = ? WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, computerId);
            pstmt.setString(3, status);
            pstmt.setString(4, created_at);
            pstmt.setInt(5, orderId);
            pstmt.executeUpdate();

            System.out.println("Order dengan Order ID '" + orderId + "' berhasil diperbarui di database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }


    //delete
    public void deleteOrder(String orderCode) {
        int orderId = getOrderIdByOrderCode(orderCode);
        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();

            System.out.println("Order dengan Order ID '" + orderId + "' berhasil dihapus dari database.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public int getOrderIdByOrderCode(String orderCode) {

        String sql = "SELECT order_id FROM orders WHERE order_code = ?";
        int orderId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, orderCode);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                orderId = rs.getInt("order_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "\n");
        }

        return orderId;
    }

    //

    // // create
    // public void createOrder(Order order) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "INSERT INTO orders (user_id, computer_id, status, order_time) " + "VALUES (?, ?, ?, ?)";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, order.getUserId());
    //         pstmt.setInt(2, order.getComputerId());
    //         pstmt.setString(3, order.getStatus());
    //         pstmt.setString(4, order.getCreated_at());
    //         pstmt.executeUpdate();

    //         System.out.println("Order berhasil ditambahkan ke database.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // read
    // public void readOrder(int orderId) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "SELECT * FROM orders WHERE order_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, orderId);
    //         ResultSet rs = pstmt.executeQuery();

    //         if (rs.next()) {
    //             System.out.println("Order ID      : " + rs.getInt("order_id"));
    //             System.out.println("User ID       : " + rs.getInt("user_id"));
    //             System.out.println("Computer ID   : " + rs.getInt("computer_id"));
    //             System.out.println("Total Price   : " + rs.getInt("total_price"));
    //             System.out.println("Payment Method: " + rs.getString("payment_method"));
    //             System.out.println("Status        : " + rs.getString("status"));
    //             System.out.println("Order Time    : " + rs.getString("order_time"));
    //         } else {
    //             System.out.println("Order tidak ditemukan.");
    //         }
    //         System.out.println();

    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // update
    // public void updateOrder(int orderId, Order order) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "UPDATE orders SET user_id = ?, computer_id = ?, status = ? " +
    //                  "WHERE order_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, order.getUserId());
    //         pstmt.setInt(2, order.getComputerId());
    //         pstmt.setString(3, order.getStatus());
    //         pstmt.setInt(4, orderId);
    //         pstmt.executeUpdate();

    //         System.out.println("Order dengan ID " + orderId + " berhasil diperbarui.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // delete
    // public void deleteOrder(int orderId) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "DELETE FROM orders WHERE order_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, orderId);
    //         pstmt.executeUpdate();

    //         System.out.println("Order dengan ID " + orderId + " berhasil dihapus.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // get id
    // public int getLatestOrderId() {
    //     DatabaseConnection.createNewTable();

    //     String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql);
    //          ResultSet rs = pstmt.executeQuery()) {

    //         if (rs.next()) {
    //             return rs.getInt("order_id");
    //         }

    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }

    //     return -1;
    // }

    // public int getOrderIdByUserId(int userId) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "SELECT order_id FROM orders WHERE user_id = ? ORDER BY order_id DESC LIMIT 1";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, userId);
    //         ResultSet rs = pstmt.executeQuery();

    //         if (rs.next()) {
    //             return rs.getInt("order_id");
    //         }

    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }

    //     return -1;
    // }

    // // cek ordernya ada atau engga, dan apakah order itu milik user yang lagi login atau bukan
    // public boolean orderExists(int orderId) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "SELECT order_id FROM orders WHERE order_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, orderId);
    //         ResultSet rs = pstmt.executeQuery();
    //         return rs.next();

    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }

    //     return false;
    // }

    // public boolean orderBelongsToUser(int orderId, int userId) {
    //     DatabaseConnection.createNewTable();

    //     String sql = "SELECT order_id FROM orders WHERE order_id = ? AND user_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, orderId);
    //         pstmt.setInt(2, userId);
    //         ResultSet rs = pstmt.executeQuery();
    //         return rs.next();

    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }

    //     return false;
    // }

    // //

    // //check order di database
    // public boolean checkOrder(int userId, int computerId) {

    //     String sql = "SELECT count(*) FROM active_sessions WHERE user_Id = ? AND computer_Id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
    //         pstmt.setInt(1, userId);
    //         pstmt.setInt(2, computerId);

    //         try (ResultSet rs = pstmt.executeQuery()) {
    //             if(rs.next() && rs.getInt(1) > 0) {
    //                 return true; // Session ID sudah ada
    //             }
    //         }

    //     } catch (Exception e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }

    //     return false; // Session ID belum ada
    // }

    // //create
    // public void createActiveSession(int userId, int computerId, long startTime, long endTime, String sessionType) {
        
    //     String sql = "INSERT INTO active_sessions(user_Id, computer_Id, start_Time, end_Time, session_Type) VALUES(?,?,?,?,?)";

    //     if (checkActiveSession(userId, computerId)) {
    //         System.out.println("Gagal menambahkan session: userId : " + userId + ", computerId : " + computerId + "' sudah ada.\n");
    //     } else {
    //         try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
    //             pstmt.setInt(1, userId);
    //             pstmt.setInt(2, computerId);
    //             pstmt.setLong(3, startTime);
    //             pstmt.setLong(4, endTime);
    //             pstmt.setString(5, sessionType);
    //             pstmt.executeUpdate();
    //             System.out.println("Session dengan userId : " + userId + ", computerId : " + computerId + " berhasil ditambahkan ke database.\n");
    //         } catch (SQLException e) {
    //             System.out.println(e.getMessage() + "\n");
    //         }
    //     }

    // }

    // //read
    // public void readActiveSession(int userId, int computerId) {
    //     int sessionId = getActiveSessionIdByOrderId(userId, computerId);
    //     String sql = "SELECT * FROM active_sessions WHERE session_Id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
    //         pstmt.setInt(1, sessionId);
    //         ResultSet rs = pstmt.executeQuery();

    //         if (rs.next()) {
    //             System.out.println("Session ID : " + rs.getString("session_Id") + "\n"
    //                              + "User ID : " + rs.getString("user_Id") + "\n"
    //                              + "Computer ID : " + rs.getString("computer_Id") + "\n"
    //                              + "Start Time : " + rs.getLong("start_Time") + "\n"
    //                              + "End Time : " + rs.getLong("end_Time") + "\n"
    //                              + "Session Type : " + rs.getString("session_Type") + "\n");
    //         } else {
    //             System.out.println("Session tidak ditemukan.");
    //         }
    //         System.out.println();
            
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // //update
    // public void updateActiveSession(int userId, int computerId, long startTime, long endTime, String sessionType) {
    //     int sessionId = getActiveSessionIdByOrderId(userId, computerId);
    //     String sql = "UPDATE active_sessions SET start_Time = ?, end_Time = ?, session_Type = ? WHERE session_Id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
    //         pstmt.setLong(1, startTime);
    //         pstmt.setLong(2, endTime);
    //         pstmt.setString(3, sessionType);
    //         pstmt.setInt(4, sessionId);
    //         pstmt.executeUpdate();

    //         System.out.println("Session dengan User_ID '" + userId + "' dan Computer_ID '" + computerId + "' berhasil diperbarui di database.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }


    // //delete
    // public void deleteActiveSession(int userId, int computerId) {
    //     int sessionId = getActiveSessionIdByOrderId(userId, computerId);
    //     String sql = "DELETE FROM active_sessions WHERE session_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {

    //         pstmt.setInt(1, sessionId);
    //         pstmt.executeUpdate();
            
    //         System.out.println("Session dengan ID = " + sessionId + " berhasil dihapus.\n");
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // public int getActiveSessionIdByOrderId(int userId, int computerId) {

    //     String sql = "SELECT session_id FROM active_sessions WHERE user_id = ? AND computer_id = ?";
    //     int sessionId = -1;

    //     try(Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
    //         pstmt.setInt(1, userId);
    //         pstmt.setInt(2, computerId);
    //         ResultSet rs = pstmt.executeQuery();

    //         if (rs.next()) {
    //             sessionId = rs.getInt("session_id");
    //         }

    //     } catch (SQLException e) {
    //         System.out.println(e.getErrorCode() + "\n");
    //     }

    //     return sessionId;
    // }

}