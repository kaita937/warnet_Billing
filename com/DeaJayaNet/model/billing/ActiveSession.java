package com.DeaJayaNet.model.billing;

public class ActiveSession {

    private int sessionId;
    private int userId;
    private int computerId;

    private Long startTime;
    private Long endTime; // 0 = NULL (untuk MEMBER saat ACTIVE)

    private String sessionType;  // MEMBER / NON_MEMBER

    // 🔹 CONSTANT biar gak typo di seluruh project
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_FINISHED = "FINISHED";

    public static final String TYPE_MEMBER = "MEMBER";
    public static final String TYPE_NON_MEMBER = "NON_MEMBER";

    // 🔹 Constructor kosong (WAJIB untuk DAO mapping)
    public ActiveSession() {}

    // 🔹 Constructor praktis
    public ActiveSession(int userId, int computerId, long startTime, long endTime, String sessionType) {
        this.userId = userId;
        this.computerId = computerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionType = sessionType;
    }

    // 🔹 Getter & Setter

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public boolean isMember() {
        return TYPE_MEMBER.equals(this.sessionType);
    }

    public boolean isNonMember() {
        return TYPE_NON_MEMBER.equals(this.sessionType);
    }
}