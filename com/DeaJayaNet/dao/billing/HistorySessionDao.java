package com.DeaJayaNet.dao.billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.DeaJayaNet.model.billing.ActiveSession;

public class HistorySessionDao {

    public boolean insertToHistory(Connection conn, ActiveSession session) {

        if (session == null) {
            return false;
        }

        String sql = """
            INSERT INTO history_sessions
            (user_id, computer_id, start_time, end_time, session_type)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, session.getUserId());
            pstmt.setInt(2, session.getComputerId());
            pstmt.setLong(3, session.getStartTime());

            if (session.getEndTime() == 0) {
                pstmt.setNull(4, Types.BIGINT);
            } else {
                pstmt.setLong(4, session.getEndTime());
            }

            pstmt.setString(5, session.getSessionType());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}