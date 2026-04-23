package com.DeaJayaNet.model.billing;

import com.DeaJayaNet.dao.billing.ActiveSessionDao;

public class ActiveSession {

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

    ActiveSessionDao activeSessionDao = new ActiveSessionDao();

    // 🔹 Constructor kosong (WAJIB untuk DAO mapping)
    public ActiveSession() {
        activeSessionDao.createActiveSession(this.userId, this.computerId, this.startTime, this.endTime, this.sessionType);
    }

    public ActiveSession(int userId) {
        this.userId = userId;
        activeSessionDao.createActiveSession(this.userId, this.computerId, this.startTime, this.endTime, this.sessionType);
    }

    public ActiveSession(int userId, int computerId) {
        this.userId = userId;
        this.computerId = computerId;
        activeSessionDao.createActiveSession(this.userId, this.computerId, this.startTime, this.endTime, this.sessionType);
    }

    public ActiveSession(int userId, int computerId, long startTime) {
        this.userId = userId;
        this.computerId = computerId;
        this.startTime = startTime;
        activeSessionDao.createActiveSession(this.userId, this.computerId, this.startTime, this.endTime, this.sessionType);
    }

    public ActiveSession(int userId, int computerId, long startTime, long endTime) {
        this.userId = userId;
        this.computerId = computerId;
        this.startTime = startTime;
        this.endTime = endTime;
        activeSessionDao.createActiveSession(this.userId, this.computerId, this.startTime, this.endTime, this.sessionType);
    }

    // 🔹 Constructor praktis
    public ActiveSession(int userId, int computerId, long startTime, long endTime, String sessionType) {
        this.userId = userId;
        this.computerId = computerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionType = sessionType;
        activeSessionDao.createActiveSession(this.userId, this.computerId, this.startTime, this.endTime, this.sessionType);
    }

    // 🔹 Getter & Setter

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        activeSessionDao.updateActiveSession(userId, computerId, startTime, endTime, sessionType);
    }

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
        activeSessionDao.updateActiveSession(userId, computerId, startTime, endTime, sessionType);
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
        activeSessionDao.updateActiveSession(userId, computerId, startTime, endTime, sessionType);
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
        activeSessionDao.updateActiveSession(userId, computerId, startTime, endTime, sessionType);
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
        activeSessionDao.updateActiveSession(userId, computerId, startTime, endTime, sessionType);
    }

    //

    public boolean isMember() {
        return TYPE_MEMBER.equals(this.sessionType);
    }

    public boolean isNonMember() {
        return TYPE_NON_MEMBER.equals(this.sessionType);
    }
}