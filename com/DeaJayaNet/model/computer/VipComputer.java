package com.DeaJayaNet.model.computer;

public class VipComputer extends Computer {

    private String computerType = "VIP"; 
    
    // --- Constructor ---
    public VipComputer() {
        super();
    }

    public VipComputer(String computerNumber) {
        super(computerNumber);
    }

    public VipComputer(String computerNumber, String Description) {
        super(computerNumber, Description);
    }

    public VipComputer(String computerNumber, String Description, boolean isUnlocked) {
        super(computerNumber, Description, isUnlocked);
    }
    // Override method abstract dari parent class Computer
    @Override
    public String getComputerType() {
        return this.computerType;
    }

    public void setComputerNumber(String computerNumber) {
        super.setComputerNumber(computerNumber);
    }

    @Override
    public void setUnlocked(boolean isUnlocked) {
        super.setUnlocked(isUnlocked);
    }

}