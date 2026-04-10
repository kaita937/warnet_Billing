package com.DeaJayaNet.model.makanan;

public class detailPesanan {
    private menuMakanan menu_makanan;
    private int jumlah;
    private int subtotal;

    public detailPesanan() {
    }

    public detailPesanan(menuMakanan menu_makanan, int jumlah) {
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
