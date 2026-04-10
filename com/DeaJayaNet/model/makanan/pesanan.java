package com.DeaJayaNet.model.makanan;

import java.time.LocalDateTime;
import java.util.List;

import com.DeaJayaNet.model.pc.pc;
import com.DeaJayaNet.model.pengguna.pengguna;

public class pesanan {
    private pengguna pengguna;
    private pc pc;
    private List<detailPesanan> detail_pesanan ;
    private int total_harga;
    private String metode_pembayaran;
    private String status;
    private LocalDateTime waktu_pemesanan;

    public pesanan() {
    }

    public pesanan(pengguna pengguna, pc pc, List<detailPesanan> detail_pesanan,   String metode_pembayaran, String status, LocalDateTime waktu_pemesanan) {
        this.pengguna = pengguna;
        this.pc = pc;
        this.detail_pesanan = detail_pesanan;
        this.total_harga = hitungTotalHarga();
        this.metode_pembayaran = metode_pembayaran;
        this.status = status;
        this.waktu_pemesanan = waktu_pemesanan;
    }


    public pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public pc getPc() {
        return pc;
    }

    public void setPc(pc pc) {
        this.pc = pc;
    }

    public List<detailPesanan> getDetail_pesanan() {
        return detail_pesanan;
    }

    public void setDetail_pesanan(List<detailPesanan> detail_pesanan) {
        this.detail_pesanan = detail_pesanan;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getWaktu_pemesanan() {
        return waktu_pemesanan;
    }

    public void setWaktu_pemesanan(LocalDateTime waktu_pemesanan) {
        this.waktu_pemesanan = waktu_pemesanan;
    }

    public int hitungTotalHarga() {
        int total = 0;
        for (detailPesanan detail : detail_pesanan) {
            total += detail.getSubtotal();
        }
        return total;
    }
    
}
