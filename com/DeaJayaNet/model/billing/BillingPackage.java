package com.DeaJayaNet.model.billing;

import com.DeaJayaNet.dao.billing.BillingPackageDao;

public class BillingPackage {
    private String packageName;
    private int durationMinutes;
    private int price;

    BillingPackageDao billingPackageDao = new BillingPackageDao();

    // --- Constructor ---
    public BillingPackage() {
            billingPackageDao.createBillingPackage(this.packageName, this.durationMinutes, this.price);
    }

    public BillingPackage(String packageName) {
        this.packageName = packageName;
        billingPackageDao.createBillingPackage(this.packageName, this.durationMinutes, this.price);
    }

    public BillingPackage(String packageName, int durationMinutes) {
        this.packageName = packageName;
        this.durationMinutes = durationMinutes;
        billingPackageDao.createBillingPackage(this.packageName, this.durationMinutes, this.price);
    }

    public BillingPackage(String packageName, int durationMinutes, int price) {
        this.packageName = packageName;
        this.durationMinutes = durationMinutes;
        this.price = price;
        billingPackageDao.createBillingPackage(this.packageName, this.durationMinutes, this.price);
    }

    // --- Getter & Setter ---
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
        billingPackageDao.updateBillingPackage(packageName, durationMinutes, price);
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
        billingPackageDao.updateBillingPackage(packageName, durationMinutes, price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        billingPackageDao.updateBillingPackage(packageName, durationMinutes, price);
    }
}