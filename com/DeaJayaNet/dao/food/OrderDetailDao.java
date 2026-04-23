package com.DeaJayaNet.dao.food;
import com.DeaJayaNet.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDao {

    //check session di database
    public boolean checkOrderDetail(int orderId, int foodMenuId) {

        String sql = "SELECT count(*) FROM order_details WHERE order_id = ? AND food_menu_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, foodMenuId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next() && rs.getInt(1) > 0) {
                    return true; //  orderDetail sudah ada
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

        return false; // orderDetail belum ada
    }

    //create
    public void createOrderDetail(int orderId, int foodMenuId, int quantity, int subtotal) {
        
        String sql = "INSERT INTO order_details(order_id, food_menu_id, quantity, subtotal) VALUES(?,?,?,?)";

        if (checkOrderDetail(orderId, foodMenuId)) {
            System.out.println("Gagal menambahkan order detail: order ID : " + orderId + ", food menu ID : " + foodMenuId + "' sudah ada.\n");
        } else {
            try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, orderId);
                pstmt.setInt(2, foodMenuId);
                pstmt.setInt(3, quantity);
                pstmt.setInt(4, subtotal);
                pstmt.executeUpdate();
                System.out.println("Order detail dengan order ID : " + orderId + ", food menu ID : " + foodMenuId + " berhasil ditambahkan ke database.\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

    }

    //read
    public void readOrderDetail(int orderId, int foodMenuId) {
        int orderDetailId = getOrderDetailIdByOrderId(orderId, foodMenuId);
        String sql = "SELECT * FROM order_details WHERE order_detail_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, orderDetailId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Order Detail ID : " + rs.getInt("order_detail_id") + "\n"
                                 + "Order ID : " + rs.getInt("order_id") + "\n"
                                 + "Food Menu ID : " + rs.getInt("food_menu_id") + "\n"
                                 + "Quantity : " + rs.getInt("quantity") + "\n"
                                 + "Subtotal : " + rs.getInt("subtotal") + "\n");
            } else {
                System.out.println("Order detail tidak ditemukan.");
            }
            System.out.println();
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    //update
    public void updateOrderDetail(int orderId, int foodMenuId, int quantity, int subtotal) {
        int orderDetailId = getOrderDetailIdByOrderId(orderId, foodMenuId);
        String sql = "UPDATE order_details SET quantity = ?, subtotal = ? WHERE order_detail_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, subtotal);
            pstmt.setInt(3, orderDetailId);
            pstmt.executeUpdate();

            System.out.println("Order detail dengan Order ID '" + orderId + "' dan Food Menu ID '" + foodMenuId + "' berhasil diperbarui di database.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }


    //delete
    public void deleteOrderDetail(int orderId, int foodMenuId) {
        int orderDetailId = getOrderDetailIdByOrderId(orderId, foodMenuId);
        String sql = "DELETE FROM order_details WHERE order_detail_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderDetailId);
            pstmt.executeUpdate();

            System.out.println("Order detail dengan Order ID '" + orderId + "' dan Food Menu ID '" + foodMenuId + "' berhasil dihapus dari database.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public int getOrderDetailIdByOrderId(int orderId, int foodMenuId) {

        String sql = "SELECT order_detail_id FROM order_details WHERE order_id = ? AND food_menu_id = ?";
        int orderDetailId = -1;

        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, foodMenuId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                orderDetailId = rs.getInt("order_detail_id");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "\n");
        }

        return orderDetailId;
    }

    // revisi
    // buat method autentikasi orderDetailed di tabel
    // buat method get id
    // ubah method CRUD karena atribut dan kolomnya diganti
    // buat kolom dari artribut model kedalam database connection

    // Create
    // public void createOrderDetail(int orderId, int foodMenuId, int quantity) {
    //     // Ingat saran sebelumnya: idealnya createNewTable() ini dihapus kalau udah dipanggil di Main
    //     DatabaseConnection.createNewTable();

    //     String sql = "INSERT INTO order_details(order_id, food_menu_id, quantity, subtotal) VALUES(?,?,?,?)";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(sql)) {
    //         pstmt.setInt(1, orderId);
    //         pstmt.setInt(2, foodMenuId);
    //         pstmt.setInt(3, quantity);
    //         pstmt.setInt(4, quantity  * GetPriceByFoodMenuId(foodMenuId)); // Menghitung subtotal berdasarkan harga makanan
    //         pstmt.executeUpdate();

    //         System.out.println("Order detail berhasil ditambahkan ke database.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // Read
    // public void readOrderDetail(int orderDetailId) {
    //     DatabaseConnection.createNewTable();
    //     String sql = "SELECT * FROM order_details WHERE order_detail_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement psmt = conn.prepareStatement(sql)){

    //         psmt.setInt(1, orderDetailId);
    //         ResultSet rs = psmt.executeQuery();

    //         if (rs.next()) {
    //             System.out.println("Order Detail ID: " + orderDetailId);
    //             System.out.println("Food Menu ID: " + rs.getInt("food_menu_id") 
    //                              + ", Quantity: " + rs.getInt("quantity")
    //                             + ", Subtotal: " + rs.getInt("subtotal"));   
    //         } else {
    //             System.out.println("Order detail tidak ditemukan.");
    //         }
    //         System.out.println();
            
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // Update 
    // public void updateOrderDetail(int orderDetailId, int foodMenuId, int quantity) {
    //     DatabaseConnection.createNewTable();
    //     String sql = "UPDATE order_details SET food_menu_id = ?, quantity = ?, subtotal = ? WHERE order_detail_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement psmt = conn.prepareStatement(sql)){

    //         psmt.setInt(1, foodMenuId);
    //         psmt.setInt(2, quantity);
    //         psmt.setInt(3, quantity * GetPriceByFoodMenuId(foodMenuId));
    //         psmt.setInt(4, orderDetailId);
    //         psmt.executeUpdate();

    //         System.out.println("Order detail berhasil diperbarui.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // // Delete
    // public void deleteOrderDetail(int orderDetailId) {
    //     DatabaseConnection.createNewTable();
        
    //     String sql = "DELETE FROM order_details WHERE order_detail_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement psmt = conn.prepareStatement(sql)){

    //         psmt.setInt(1, orderDetailId);
    //         psmt.executeUpdate();

    //         System.out.println("Order detail dengan ID " + orderDetailId + " berhasil dihapus.\n");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //     }
    // }

    // //autentikasi
    // public boolean authenticateOrderDetail(int orderId, int foodMenuId) {
    //     DatabaseConnection.createNewTable();
    //     String sql = """
    //             SELECT 1 FROM order_details 
    //             WHERE order_id = ? AND food_menu_id = ?
    //             """;

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement psmt = conn.prepareStatement(sql)){

    //         psmt.setInt(1, orderId);
    //         psmt.setInt(2, foodMenuId);
    //         ResultSet rs = psmt.executeQuery();

    //         return rs.next(); // Mengembalikan true jika order detail ditemukan, false jika tidak
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //         return false; // Indikator error
    //     }
    // }

    // public int GetOrderDetailId(int orderId, int foodMenuId) {
    //     DatabaseConnection.createNewTable();
    //     String sql = "SELECT order_detail_id FROM order_details WHERE order_id = ? AND food_menu_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement psmt = conn.prepareStatement(sql)){

    //         psmt.setInt(1, orderId);
    //         psmt.setInt(2, foodMenuId);
    //         ResultSet rs = psmt.executeQuery();

    //         if (rs.next()) {
    //             return rs.getInt("order_detail_id");
    //         } else {
    //             System.out.println("Order detail tidak ditemukan untuk order ID " + orderId + " dan food menu ID " + foodMenuId);
    //             return -1; // Indikator tidak ditemukan
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //         return -1; // Indikator error
    //     }
    // }

    // public int GetPriceByFoodMenuId(int foodMenuId) {
    //     DatabaseConnection.createNewTable();
    //     String sql = "SELECT price FROM food_menus WHERE food_menu_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement psmt = conn.prepareStatement(sql)){

    //         psmt.setInt(1, foodMenuId);
    //         ResultSet rs = psmt.executeQuery();

    //         if (rs.next()) {
    //             return rs.getInt("price");
    //         } else {
    //             System.out.println("Food menu tidak ditemukan untuk ID " + foodMenuId);
    //             return 0; // Indikator tidak ditemukan
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage() + "\n");
    //         return 0; // Indikator error
    //     }
    // }


}