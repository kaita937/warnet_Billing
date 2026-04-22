package com.DeaJayaNet.dao.billing;

import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.model.billing.ActiveSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActiveSessionDao {

    // 🔹 CREATE SESSION
    public int createSession(ActiveSession session) {
        String sql = "INSERT INTO active_sessions " +
                "(user_id, computer_id, start_time, end_time, session_type) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, session.getUserId());
            pstmt.setInt(2, session.getComputerId());
            pstmt.setLong(3, session.getStartTime());

            // HANDLE NULL end_time (untuk MEMBER)
            if (session.getEndTime() == 0) {
                pstmt.setNull(4, Types.BIGINT);
            } else {
                pstmt.setLong(4, session.getEndTime());
            }

            pstmt.setString(5, session.getSessionType());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    // 🔹 READ SESSION
    // AMBIL SESSION ACTIVE BERDASARKAN ID SESSION
    public ActiveSession findById (int sessionId) {
        String sql = "SELECT * " +
                     "FROM active_sessions WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, sessionId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToSession(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // AMBIL SESSION ACTIVE BERDASARKAN USER ID
    public ActiveSession findSessionByUser(int userId) {
        String sql = "SELECT * " +
                     "FROM active_sessions WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToSession(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // AMBIL SESSION AKTIF BERDASARKAN COMPUTER ID
    public ActiveSession findActiveByComputer(int computerId) {
        String sql = "SELECT * " +
                     "FROM active_sessions WHERE computer_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, computerId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToSession(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    // 🔹 AMBIL SEMUA SESSION YANG LAGI AKTIF
    public List<ActiveSession> getAllActive() {
        List<ActiveSession> list = new ArrayList<>();
        String sql = "SELECT * FROM active_sessions";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSetToSession(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // CEK APAKAH COMPUTER ADA SESSION ACTIVENYA
    public boolean isComputerInUse(int computerId) {
        String sql = """
                SELECT 1
                FROM active_sessions
                WHERE computer_id = ?
                LIMIT 1
                """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, computerId);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // true jika ada session
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // CEK APAKAH USER SEDANG ADA SESSION ACTIVE
    public boolean isUserLoggedIn(int userId) {
        String sql = """
                SELECT 1
                FROM active_sessions
                WHERE user_id = ?
                LIMIT 1
                """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // UPDATE SESSION END TIME (FINISH)
    public boolean updateEndTime(int sessionId, long newEndTime) {
        String sql = "UPDATE active_sessions SET end_time = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, newEndTime);
            pstmt.setInt(2, sessionId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔹 DELETE SESSION 
    public boolean deleteSession(int sessionId) {
    String sql = "DELETE FROM active_sessions WHERE id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, sessionId);

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            return true;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}

    // 🔧 MAPPING RESULTSET → OBJECT
    private ActiveSession mapResultSetToSession(ResultSet rs) throws SQLException {
        ActiveSession session = new ActiveSession();

        session.setSessionId(rs.getInt("id"));
        session.setUserId(rs.getInt("user_id"));
        session.setComputerId(rs.getInt("computer_id"));
        session.setStartTime(rs.getLong("start_time"));

        long endTime = rs.getLong("end_time");
        if (rs.wasNull()) {
            session.setEndTime(0);
        } else {
            session.setEndTime(endTime);
        }

        session.setSessionType(rs.getString("session_type"));

        return session;
    }
}