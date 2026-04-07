package com.DeaJayaNet.model.transaksi;

public class transaksi {
    String metode_pembayaran; // dalam diagram activity ada cash dan qris
    int jumlah_bayar;
    String status; 

    // konstruktor
    public transaksi() {
    }

    public transaksi(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public transaksi(String metode_pembayaran, int jumlah_bayar) {
        this.metode_pembayaran = metode_pembayaran;
        this.jumlah_bayar = jumlah_bayar;
    }

    public transaksi(String metode_pembayaran, int jumlah_bayar, String status) {
        this.metode_pembayaran = metode_pembayaran;
        this.jumlah_bayar = jumlah_bayar;
        this.status = status;
    }

    //setter & getter
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

    //service
    // void displayInfo() {
    //     System.out.println("ID: " + id);
    //     System.out.println("Metode Pembayaran: " + metode_pembayaran);
    //     System.out.println("Jumlah Bayar: " + jumlah_bayar);
    //     System.out.println("Status: " + status);
    // }

    // void generateStruk() {
    //     // bikin struk pembayaran
    // }

    // void generateQr() {
    //     // kalau qris
    // }

    // void prosesPembayaran() {
    //     // proses pembayaran
    // }

    
}
