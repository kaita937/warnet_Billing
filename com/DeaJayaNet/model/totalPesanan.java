package com.DeaJayaNet.model;

import java.util.List;

public class totalPesanan {
    List<detailMakanan> daftarPesanan;
    int totalHarga;

    public totalPesanan() {
    }

    public totalPesanan(List<detailMakanan> daftarPesanan) {
        this.daftarPesanan = daftarPesanan;
        this.totalHarga = hitungTotalHarga();
    }

    public List<detailMakanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public int hitungTotalHarga() {
        int total = 0;
        for (detailMakanan detail : daftarPesanan) {
            total += detail.getSubtotal();
        }
        return total;
    }

}
