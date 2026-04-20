package com.DeaJayaNet.model.computer;

public class VipComputer extends Computer {

    private String computerType = "VIP"; 
    
    // --- Constructor ---
    public VipComputer() {
        super();
        computerDao.createComputer(super.getComputerNumber(), super.isUnlocked(), this.getComputerType());
    }

    public VipComputer(String computerNumber) {
        super(computerNumber);
        computerDao.createComputer(super.getComputerNumber(), super.isUnlocked(), this.getComputerType());
    }

    public VipComputer(String computerNumber, boolean isUnlocked) {
        super(computerNumber, isUnlocked);
        computerDao.createComputer(super.getComputerNumber(), super.isUnlocked(), this.getComputerType());
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