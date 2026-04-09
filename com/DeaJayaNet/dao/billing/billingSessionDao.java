package com.DeaJayaNet.dao.billing;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.billing.billingSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class billingSessionDao {

    // 🔹 CREATE SESSION (return ID)
    public int createSession(billingSession session) {
        String sql = "INSERT INTO billing_session " +
                "(user_id, pc_id, start_time, end_time, status, session_type) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, session.getUserId());
            pstmt.setInt(2, session.getPcId());
            pstmt.setLong(3, session.getStartTime());

            // HANDLE NULL end_time (untuk MEMBER)
            if (session.getEndTime() == 0) {
                pstmt.setNull(4, Types.INTEGER);
            } else {
                pstmt.setLong(4, session.getEndTime());
            }

            pstmt.setString(5, session.getStatus());
            pstmt.setString(6, session.getSessionType());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error createSession:");
            e.printStackTrace();
        }

        return -1;
    }

    // 🔹 FIND ACTIVE SESSION BY USER
    public billingSession findActiveByUser(int userId) {
        String sql = "SELECT id, user_id, pc_id, start_time, end_time, status, session_type " +
                     "FROM billing_session WHERE user_id = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToSession(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error findActiveByUser:");
            e.printStackTrace();
        }

        return null;
    }

    // 🔹 FIND ACTIVE SESSION BY PC
    public billingSession findActiveByPc(int pcId) {
        String sql = "SELECT id, user_id, pc_id, start_time, end_time, status, session_type " +
                     "FROM billing_session WHERE pc_id = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pcId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToSession(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error findActiveByPc:");
            e.printStackTrace();
        }

        return null;
    }

    // 🔹 END SESSION
    public void endSession(int sessionId, long endTime) {
        String sql = "UPDATE billing_session SET end_time = ?, status = 'FINISHED' WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, endTime);
            pstmt.setInt(2, sessionId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error endSession:");
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE END TIME (NON-MEMBER EXTEND)
    public void updateEndTime(int sessionId, long newEndTime) {
        String sql = "UPDATE billing_session SET end_time = ? WHERE id = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, newEndTime);
            pstmt.setInt(2, sessionId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updateEndTime:");
            e.printStackTrace();
        }
    }

    // 🔹 GET ALL ACTIVE SESSION (RECOVERY)
    public List<billingSession> findAllActive() {
        List<billingSession> list = new ArrayList<>();

        String sql = "SELECT id, user_id, pc_id, start_time, end_time, status, session_type " +
                     "FROM billing_session WHERE status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToSession(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error findAllActive:");
            e.printStackTrace();
        }

        return list;
    }

    // 🔧 MAPPING RESULTSET → OBJECT
    private billingSession mapResultSetToSession(ResultSet rs) throws SQLException {
        billingSession session = new billingSession();

        session.setId(rs.getInt("id"));
        session.setUserId(rs.getInt("user_id"));
        session.setPcId(rs.getInt("pc_id"));
        session.setStartTime(rs.getLong("start_time"));

        long endTime = rs.getLong("end_time");
        if (rs.wasNull()) {
            session.setEndTime(0);
        } else {
            session.setEndTime(endTime);
        }

        session.setStatus(rs.getString("status"));
        session.setSessionType(rs.getString("session_type"));

        return session;
    }
}