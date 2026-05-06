package com.DeaJayaNet.model.billing;

public class BillingPackage {
    private String packageName;
    private String category; // REGULER atau VIP
    private int durationMinutes;
    private int price;

    // --- Constructor ---
    public BillingPackage() {
    }

    public BillingPackage(String packageName) {
        this.packageName = packageName;
    }

    public BillingPackage(String packageName, String category) {
        this.packageName = packageName;
        this.category = category;
    }

    public BillingPackage(String packageName, String category, int durationMinutes) {
        this.packageName = packageName;
        this.category = category;
        this.durationMinutes = durationMinutes;
    }

    public BillingPackage(String packageName, String category, int durationMinutes, int price) {
        this.packageName = packageName;
        this.category = category;
        this.durationMinutes = durationMinutes;
        this.price = price;
    }

    // --- Getter & Setter ---
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}