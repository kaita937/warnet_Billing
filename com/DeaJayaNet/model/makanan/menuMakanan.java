package com.DeaJayaNet.model.makanan;

public class menuMakanan {
    
    String nama_menu;
    int harga;

    //konstruktor
    public menuMakanan() {
    }

    public menuMakanan(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public menuMakanan(String nama_menu, int harga) {
        this.nama_menu = nama_menu;
        this.harga = harga;
    }

    //getter & setter
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
