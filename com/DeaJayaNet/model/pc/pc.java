package com.DeaJayaNet.model.pc;

import com.DeaJayaNet.dao.pc.pcDao;

public abstract class pc {

    private String nomor_pc;
    private boolean status = false; //false = terkunci, true = terbuka
    private String tipe_pc;

    pcDao pcDao = new pcDao();
    
    // billingSession billing_session;

    //konstruktor
    public pc(){

    }

    public pc(String nomor_pc) {
        this.nomor_pc = nomor_pc;
        this.tipe_pc = null;
        this.status = false;
    }

    public pc(String nomor_pc, boolean status) {
        this.nomor_pc = nomor_pc;
        this.status = status;
    }

    public pc(String nomor_pc, boolean status, String tipe_pc) {
        this.nomor_pc = nomor_pc;
        this.status = status;
        this.tipe_pc = tipe_pc;
    }

    //getter & setter
    public String getNomor_pc() {
        return this.nomor_pc;
    }

    public void setNomor_pc(String nomor_pc) {
        this.nomor_pc = nomor_pc;
    }

    public abstract String getTipe_pc();

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //service
    // void displayInfo() {
    //     System.out.println("ID: " + id);
    //     System.out.println("Nomor PC: " + nomor_pc);
    //     System.out.println("Tipe PC: " + tipe_pc);
    //     System.out.println("Status: " + status);
    // }

    // void setPcHidup() {
    //     if (status.equalsIgnoreCase("terkunci")) {
    //         status = "terbuka";
    //         // billing_session.mulaiSession(); //mulai session?
    //         System.out.println("PC " + nomor_pc + "pc dinyalakan.");
    //     } else {
    //         System.out.println("PC " + nomor_pc + "pc menyala.");
    //     }
    // }

    // void setPcMati(){
    //     if (status.equalsIgnoreCase("terbuka")) {
    //         status = "terkunci";
    //         //billing_session.selesaiSession(); //selesai session? 
    //         // gimana bisa 0 untuk yang reguler?
    //         System.out.println("PC " + nomor_pc + "pc dimatikan.");
    //     } else {
    //         System.out.println("PC " + nomor_pc + "pc mati.");
    //     }
    // }


    //kode lama
    // penggunaDao db = new penggunaDao();
    // private Boolean isLogin = false ;

    // public pc() {
    //     DatabaseConnection.createNewTable();
    // }

    // public void login (String username, String password) {
    //     if (!this.isLogin) {
    //         if (db.cekLogin(username, password)) {
    //             isLogin = true;
    //             System.out.println("Login Berhasil untuk user: " + username);
    //             System.out.println();
    //         } else {
    //             isLogin = false;
    //             System.out.println("Login Gagal: username atau password salah.");
    //             System.out.println();
    //         }
    //     } else {
    //         System.out.println("pc sedang digunakan.");
    //         System.out.println();
    //     }
    // }

    // public void logout () {
    //     isLogin = false;
    //     System.out.println("Logout Berhasil");
    //     System.out.println();
    // }

    // public Boolean getIsLogin() {
    //     return isLogin;
    // }


}
