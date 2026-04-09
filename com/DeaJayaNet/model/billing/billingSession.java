package com.DeaJayaNet.model.billing;

public class billingSession {

    private int id;
    private int userId;
    private int pcId;

    private long startTime;
    private long endTime; // 0 = NULL (untuk MEMBER saat ACTIVE)

    private String status;       // ACTIVE / FINISHED
    private String sessionType;  // MEMBER / NON_MEMBER

    // 🔹 CONSTANT biar gak typo di seluruh project
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_FINISHED = "FINISHED";

    public static final String TYPE_MEMBER = "MEMBER";
    public static final String TYPE_NON_MEMBER = "NON_MEMBER";

    // 🔹 Constructor kosong (WAJIB untuk DAO mapping)
    public billingSession() {}

    // 🔹 Constructor praktis
    public billingSession(int userId, int pcId, long startTime, long endTime, String status, String sessionType) {
        this.userId = userId;
        this.pcId = pcId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.sessionType = sessionType;
    }

    // 🔹 Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public boolean isActive() {
        return STATUS_ACTIVE.equals(this.status);
    }

    public boolean isMember() {
        return TYPE_MEMBER.equals(this.sessionType);
    }

    public boolean isNonMember() {
        return TYPE_NON_MEMBER.equals(this.sessionType);
    }
}