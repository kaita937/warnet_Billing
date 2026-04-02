package com.DeaJayaNet.model;

public class detailMakanan {
    menuMakanan menu_makanan;
    int jumlah;
    int subtotal;

    public detailMakanan() {
    }

    public detailMakanan(menuMakanan menu_makanan, int jumlah) {
        this.menu_makanan = menu_makanan;
        this.jumlah = jumlah;
        this.subtotal = menu_makanan.getHarga() * jumlah;
    }

    public menuMakanan getMenu_makanan() {
        return menu_makanan;
    }

    public void setMenu_makanan(menuMakanan menu_makanan) {
        this.menu_makanan = menu_makanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    
}
