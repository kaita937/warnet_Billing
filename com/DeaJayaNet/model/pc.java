package com.DeaJayaNet.model;
import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.dao.penggunaDao;

public class pc {

    int id ;
    String nomor_pc;
    String tipe_pc;
    String status;  //ganti boolean?
    billingSession billing_session;

    public pc(){

    }

    public pc(int id, String nomor_pc, String tipe_pc, String status) {
        this.id = id;
        this.nomor_pc = nomor_pc;
        this.tipe_pc = tipe_pc;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomor_pc() {
        return nomor_pc;
    }

    public void setNomor_pc(String nomor_pc) {
        this.nomor_pc = nomor_pc;
    }

    public String getTipe_pc() {
        return tipe_pc;
    }

    public void setTipe_pc(String tipe_pc) {
        this.tipe_pc = tipe_pc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nomor PC: " + nomor_pc);
        System.out.println("Tipe PC: " + tipe_pc);
        System.out.println("Status: " + status);
    }

    void setPcHidup() {
        if (status.equalsIgnoreCase("terkunci")) {
            status = "terbuka";
            // billing_session.mulaiSession(); //mulai session?
            System.out.println("PC " + nomor_pc + "pc dinyalakan.");
        } else {
            System.out.println("PC " + nomor_pc + "pc menyala.");
        }
    }

    void setPcMati(){
        if (status.equalsIgnoreCase("terbuka")) {
            status = "terkunci";
            //billing_session.selesaiSession(); //selesai session? 
            // gimana bisa 0 untuk yang reguler?
            System.out.println("PC " + nomor_pc + "pc dimatikan.");
        } else {
            System.out.println("PC " + nomor_pc + "pc mati.");
        }
    }



    
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
