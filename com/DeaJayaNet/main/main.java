package com.DeaJayaNet.main;

import com.DeaJayaNet.dao.penggunaDao;
import com.DeaJayaNet.model.member;
import com.DeaJayaNet.model.pc;
import com.DeaJayaNet.model.vip;
import com.DeaJayaNet.model.admin;

public class main {
    public static void main(String[] args) {

        // note : 
        // kalau mau akses database 'users.db' download dulu DB Browser(SQLite). 
        // terus buka file users.db yang ada di folder project ini pakai DB Browser(SQLite).

        penggunaDao pdao = new penggunaDao();  
        
        // Create
        admin a1 = new admin(null, "jull", "qwerty");
        vip v1 = new vip(null,"jamal", "qwerty");
        member m1 = new member(null, "zaki", "qwerty");

        // Read
        pdao.readPengguna(a1.getUsername());
        pdao.readPengguna(v1.getUsername());
        pdao.readPengguna(m1.getUsername());

        // Update
        a1.setEmail("jull@gmail.com");
        v1.setEmail("jamal@gmail.com");
        m1.setEmail("zaki@gmail.com");
        pdao.readPengguna(a1.getUsername());
        pdao.readPengguna(v1.getUsername());
        pdao.readPengguna(m1.getUsername());

        // Delete
        pdao.deletePengguna(a1.getUsername());
        pdao.deletePengguna(v1.getUsername());
        pdao.deletePengguna(m1.getUsername());
        pdao.readPengguna(v1.getUsername());
        pdao.readPengguna(m1.getUsername());

    }
}