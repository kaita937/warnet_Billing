package com.DeaJayaNet.model.user;
import com.DeaJayaNet.dao.user.UserDao;

public abstract class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    protected String role; 
    UserDao userDao = new UserDao();

    // --- Constructor ---
    public User() {
        this.name = null;
        this.username = null;
        this.password = null;
        this.email = null;
        this.phoneNumber = null;
        this.role = getRole();
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = null;
        this.phoneNumber = null;
        this.role = getRole();
    }

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = null;
        this.role = getRole();
    }

    public User(String name, String username, String password, String email, String phoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = getRole();
    }

    // --- Setter ---
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // --- Getter ---
    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public abstract String getRole();
}