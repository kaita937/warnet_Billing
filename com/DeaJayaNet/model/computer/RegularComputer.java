package com.DeaJayaNet.model.computer;

public class RegularComputer extends Computer {

    private String computerType = "Regular"; 
    
    // --- Constructor ---
    public RegularComputer() {
        super();
    }

    public RegularComputer(String computerNumber) {
        super(computerNumber);
    }

    public RegularComputer(String computerNumber, boolean isUnlocked) {
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