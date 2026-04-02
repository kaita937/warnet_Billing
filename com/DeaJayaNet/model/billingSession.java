package com.DeaJayaNet.model;

import java.time.LocalDateTime;

public class billingSession {
    int id;
    pc pc;
    pengguna pengguna;
    LocalDateTime waktu_mulai;
    LocalDateTime waktu_selesai;
    int durasi; // menit
    String status;

    public billingSession() {
    }

    public billingSession(int id, pc pc, pengguna pengguna, LocalDateTime waktu_mulai, LocalDateTime waktu_selesai,
            int durasi, String status) {
        this.id = id;
        this.pc = pc;
        this.pengguna = pengguna;
        this.waktu_mulai = waktu_mulai;
        this.waktu_selesai = waktu_selesai  ;
        this.durasi = durasi;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public pc getPc() {
        return pc;
    }

    public void setPc(pc pc) {
        this.pc = pc;
    }

    public pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public LocalDateTime getWaktuMulai() {
        return waktu_mulai;
    }

    public void setWaktuMulai(LocalDateTime waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public LocalDateTime getWaktuSelesai() {
        return waktu_selesai;
    }

    public void setWaktuSelesai(LocalDateTime waktu_selesai) {
        this.waktu_selesai = waktu_selesai;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("PC: " + pc.getNomor_pc());
        System.out.println("Pengguna: " + pengguna.getUsername());
        System.out.println("Waktu Mulai: " + waktu_mulai);
        System.out.println("Waktu Selesai: " + waktu_selesai);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Status: " + status);
    }

    void mulaiSession() {
        this.waktu_mulai = LocalDateTime.now();
        this.status = "aktif";
        System.out.println("Session dimulai ");
    }

    void selesaiSession() {
        this.waktu_selesai = LocalDateTime.now();
        this.status = "nonaktif";
        System.out.println("Session selesai ");
    }

    // logika durasi berkurang



}
