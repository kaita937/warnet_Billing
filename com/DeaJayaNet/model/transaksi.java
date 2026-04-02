package com.DeaJayaNet.model;

public class transaksi {
    int id;
    String metode_pembayaran; // dalam diagram activity ada cash dan qris
    int jumlah_bayar;
    String status; 

    public transaksi() {
    }

    public transaksi(int id, String metode_pembayaran, int jumlah_bayar, String status) {
        this.id = id;
        this.metode_pembayaran = metode_pembayaran;
        this.jumlah_bayar = jumlah_bayar;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public int getJumlah_bayar() {
        return jumlah_bayar;
    }

    public void setJumlah_bayar(int jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Metode Pembayaran: " + metode_pembayaran);
        System.out.println("Jumlah Bayar: " + jumlah_bayar);
        System.out.println("Status: " + status);
    }

    void generateStruk() {
        // bikin struk pembayaran
    }

    void generateQr() {
        // kalau qris
    }

    void prosesPembayaran() {
        // proses pembayaran
    }

    
}
