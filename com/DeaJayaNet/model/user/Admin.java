package com.DeaJayaNet.model.user;
import com.DeaJayaNet.dao.user.UserDao;

public class Admin extends User {
    private String role = "Admin";

    // --- Constructor ---
    public Admin() {
        super();
        userDao.createUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    public Admin(String name, String username, String password) {
        super(name, username, password);
        userDao.createUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    public Admin(String name, String username, String password, String email) {
        super(name, username, password, email);
        userDao.createUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    public Admin(String name, String username, String password, String email, String phoneNumber) {
        super(name, username, password, email, phoneNumber);
        userDao.createUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
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
        userDao.updateUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
        userDao.updateUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        userDao.updateUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
        userDao.updateUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
        userDao.updateUser(super.getName(), super.getUsername(), super.getPassword(), super.getEmail(), super.getPhoneNumber(), this.role, super.getRemainingTime());
    }
}