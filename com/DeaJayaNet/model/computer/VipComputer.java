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

    public VipComputer(String computerNumber, boolean isUnlocked) {
        super(computerNumber, isUnlocked);
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