package com.DeaJayaNet.model.billing;

public class paketBilling {
    private String nama_paket;
    private int durasi_menit; 
    private int harga;

    // konstruktor
    public paketBilling() {
    }

    public paketBilling(String nama_paket) {
        this.nama_paket = nama_paket;
    }

    public paketBilling(String nama_paket, int durasi_menit) {
        this.nama_paket = nama_paket;
        this.durasi_menit = durasi_menit;
    }

    public paketBilling(String nama_paket, int durasi_menit, int harga) {
        this.nama_paket = nama_paket;
        this.durasi_menit = durasi_menit;
        this.harga = harga;
    }

    // getter & setter
    public String getNama_paket() {
        return nama_paket;
    }

    public void setNama_paket(String nama_paket) {
        this.nama_paket = nama_paket;
    }

    public int getDurasi_waktu() {
        return durasi_menit;
    }

    public void setDurasi_waktu(int durasi_menit) {
        this.durasi_menit = durasi_menit;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

}
