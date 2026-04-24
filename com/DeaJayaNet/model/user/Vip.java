package com.DeaJayaNet.model.user;

public class Vip extends User {

    private String role = "VIP";

    // --- Constructor ---
    public Vip() {
        super();
    }

    public Vip(String name, String username, String password) {
        super(name, username, password);
    }

    public Vip(String name, String username, String password, String email) {
        super(name, username, password, email);
    }

    public Vip(String name, String username, String password, String email, String phoneNumber) {
        super(name, username, password, email, phoneNumber);
    }

    public Vip(String name, String username, String password, String email, String phoneNumber, int remainingTime) {
        super(name, username, password, email, phoneNumber, remainingTime);
    }

    // Override method abstract dari parent class User
    @Override
    public String getRole() {
        return this.role;
    }

    // --- Setter ---
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

}