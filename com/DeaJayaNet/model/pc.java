package com.DeaJayaNet.model;
import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.dao.penggunaDao;

public class pc {
    
    penggunaDao db = new penggunaDao();
    private Boolean isLogin = false ;

    public pc() {
        DatabaseConnection.createNewTable();
    }

    public void login (String username, String password) {
        if (!this.isLogin) {
            if (db.cekLogin(username, password)) {
                isLogin = true;
                System.out.println("Login Berhasil untuk user: " + username);
                System.out.println();
            } else {
                isLogin = false;
                System.out.println("Login Gagal: username atau password salah.");
                System.out.println();
            }
        } else {
            System.out.println("pc sedang digunakan.");
            System.out.println();
        }
    }

    public void logout () {
        isLogin = false;
        System.out.println("Logout Berhasil");
        System.out.println();
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

}
