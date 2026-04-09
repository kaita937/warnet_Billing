package com.DeaJayaNet.model.transaksi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class paymentlog {
    
    String transaksi_id ;
    int total ;
    Boolean status_pembayaran = false; // true = berhasil, false = gagal
    String created_at ;

    //konstruktor
    public paymentlog() {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.transaksi_id = null;
        this.total = 0;
        this.created_at = waktuFormatted;
    }

    public paymentlog(String transaksi_id) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.transaksi_id = transaksi_id;
        this.total = 0;
        this.created_at = waktuFormatted;
    }

    public paymentlog(String transaksi_id, int total) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.transaksi_id = transaksi_id;
        this.total = total;
        this.created_at = waktuFormatted;
    }

    //setter
    public void setTransaksi_id(String transaksi_id) {
        this.transaksi_id = transaksi_id;
    }

    public void setTotal(int total) {
        this.total = total;
    }  

    public void setStatus_pembayaran(Boolean status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

    //getter
    public String getTransaksi_id() {
        return this.transaksi_id;
    }

    public int getTotal() {
        return this.total;
    }

    public Boolean getStatus_pembayaran() {
        return this.status_pembayaran;
    }

    public String getCreated_at() {
        return this.created_at;
    }

}
