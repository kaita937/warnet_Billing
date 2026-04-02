package com.DeaJayaNet.model;

public class menuMakanan {
    int id;
    String nama_menu;
    int harga;

    public menuMakanan() {
    }

    public menuMakanan(int id, String nama_menu, int harga) {
        this.id = id;
        this.nama_menu = nama_menu;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    
}
