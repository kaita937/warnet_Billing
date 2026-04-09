package com.DeaJayaNet.model.transaksi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class transaksi {

    String user_id ;
    String paket_id ;
    String pesanan_id ;
    String jenis ;
    int total ;
    String status ; 
    String metode ;
    String qris_string ;
    String created_at ;

    //konstruktor
    public transaksi() {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = null;
        this.paket_id = null;
        this.pesanan_id = null;
        this.jenis = null;
        this.total = 0;
        this.status = null;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = null;
        this.pesanan_id = null;
        this.jenis = null;
        this.total = 0;
        this.status = null;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = null;
        this.jenis = null;
        this.total = 0;
        this.status = null;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id, String pesanan_id) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = pesanan_id;
        this.jenis = null;
        this.total = 0;
        this.status = null;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id, String pesanan_id, String jenis) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = pesanan_id;
        this.jenis = jenis;
        this.total = 0;
        this.status = null;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id, String pesanan_id, String jenis, int total) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = pesanan_id;
        this.jenis = jenis;
        this.total = total;
        this.status = null;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id, String pesanan_id, String jenis, int total, String status) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = pesanan_id;
        this.jenis = jenis;
        this.total = total;
        this.status = status;
        this.metode = null;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id, String pesanan_id, String jenis, int total, String status, String metode) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = pesanan_id;
        this.jenis = jenis;
        this.total = total;
        this.status = status;
        this.metode = metode;
        this.qris_string = null;
        this.created_at = waktuFormatted;
    }

    public transaksi(String user_id, String paket_id, String pesanan_id, String jenis, int total, String status, String metode, String qris_string) {

        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktuFormatted = waktuSekarang.format(formatter);

        this.user_id = user_id;
        this.paket_id = paket_id;
        this.pesanan_id = pesanan_id;
        this.jenis = jenis;
        this.total = total;
        this.status = status;
        this.metode = metode;
        this.qris_string = qris_string;
        this.created_at = waktuFormatted;
    }

    //setter
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPaket_id(String paket_id) {
        this.paket_id = paket_id;
    }

    public void setPesanan_id(String pesanan_id) {
        this.pesanan_id = pesanan_id;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setQris_string(String qris_string) {
        this.qris_string = qris_string;
    }

    //getter
    public String getUser_id() {
        return this.user_id;
    }

    public String getPaket_id() {
        return this.paket_id;
    }

    public String getPesanan_id() {
        return this.pesanan_id;
    }

    public String getJenis() {
        return this.jenis;
    }

    public int getTotal() {
        return this.total;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMetode() {
        return this.metode;
    }

    public String getQris_string() {
        return this.qris_string;
    }

    public String getCreated_at() {
        return this.created_at;
    }
    
}
