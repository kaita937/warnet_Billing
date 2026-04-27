package com.DeaJayaNet.model.user;

public class Admin extends User {

    private String role = "ADMIN";

    // --- Constructor ---
    public Admin() {
        super();
    }

    public Admin(String name, String username, String password) {
        super(name, username, password);
    }

    public Admin(String name, String username, String password, String email) {
        super(name, username, password, email);
    }

    public Admin(String name, String username, String password, String email, String phoneNumber) {
        super(name, username, password, email, phoneNumber);
    }

    public Admin(String name, String username, String password, String email, String phoneNumber, int remainingTime) {
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