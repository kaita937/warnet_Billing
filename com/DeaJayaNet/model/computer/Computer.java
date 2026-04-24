package com.DeaJayaNet.model.computer;

public abstract class Computer {

    private String computerNumber;
    private boolean isUnlocked = false;
    protected String computerType;
    
    // --- Constructor ---
    public Computer() {
    }

    public Computer(String computerNumber) {
        this.computerNumber = computerNumber;
        this.computerType = null;
        this.isUnlocked = false;
    }

    public Computer(String computerNumber, boolean isUnlocked) {
        this.computerNumber = computerNumber;
        this.isUnlocked = isUnlocked;
    }

    public Computer(String computerNumber, boolean isUnlocked, String computerType) {
        this.computerNumber = computerNumber;
        this.isUnlocked = isUnlocked;
        this.computerType = computerType;
    }

    // --- Getter & Setter ---
    public String getComputerNumber() {
        return this.computerNumber;
    }

    public void setComputerNumber(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    // Method abstract untuk di-implementasikan di class turunan (Reguler/VIP)
    public abstract String getComputerType();

    public boolean isUnlocked() {
        return this.isUnlocked;
    }

    public void setUnlocked(boolean isUnlocked) {
        this.isUnlocked = isUnlocked;
    }
    
    // --- Service Methods (Commented - Translated) ---
    
    // void displayInfo() {
    //     System.out.println("ID: " + id);
    //     System.out.println("Computer Number: " + computerNumber);
    //     System.out.println("Computer Type: " + computerType);
    //     System.out.println("Is Unlocked: " + isUnlocked);
    // }

    // void turnOnComputer() {
    //     if (!isUnlocked) { // Jika terkunci (false)
    //         isUnlocked = true; // Buka kunci (true)
    //         // billingSession.startSession();
    //         System.out.println("Computer " + computerNumber + " is now turned on/unlocked.");
    //     } else {
    //         System.out.println("Computer " + computerNumber + " is already running.");
    //     }
    // }

    // void turnOffComputer() {
    //     if (isUnlocked) { // Jika terbuka (true)
    //         isUnlocked = false; // Kunci kembali (false)
    //         // billingSession.endSession(); 
    //         System.out.println("Computer " + computerNumber + " is now turned off/locked.");
    //     } else {
    //         System.out.println("Computer " + computerNumber + " is already off.");
    //     }
    // }


    // --- Old Code (Commented - Translated) ---
    
    // UserDao db = new UserDao();
    // private Boolean isLoggedIn = false;

    // public Computer() {
    //     DatabaseConnection.createNewTable();
    // }

    // public void login(String username, String password) {
    //     if (!this.isLoggedIn) {
    //         if (db.checkLogin(username, password)) {
    //             isLoggedIn = true;
    //             System.out.println("Login successful for user: " + username + "\n");
    //         } else {
    //             isLoggedIn = false;
    //             System.out.println("Login failed: incorrect username or password.\n");
    //         }
    //     } else {
    //         System.out.println("Computer is currently in use.\n");
    //     }
    // }

    // public void logout() {
    //     isLoggedIn = false;
    //     System.out.println("Logout successful\n");
    // }

    // public Boolean getIsLoggedIn() {
    //     return isLoggedIn;
    // }
}