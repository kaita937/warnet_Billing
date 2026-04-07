package com.DeaJayaNet.main;

import com.DeaJayaNet.dao.pc.pcDao;
import com.DeaJayaNet.dao.pengguna.penggunaDao;
import com.DeaJayaNet.model.pc.pc;
import com.DeaJayaNet.model.pc.pcReguler;
import com.DeaJayaNet.model.pc.pcVip;
import com.DeaJayaNet.model.makanan.menuMakanan;
import com.DeaJayaNet.model.pengguna.admin;
import com.DeaJayaNet.model.pengguna.member;
import com.DeaJayaNet.model.pengguna.vip;

public class main {
    public static void main(String[] args) {

        // note : 
        // kalau mau akses database 'users.db' download dulu DB Browser(SQLite). 
        // terus buka file users.db yang ada di folder project ini pakai DB Browser(SQLite).

        // //-----tes CRUD pengguna-----
        // penggunaDao pdao = new penggunaDao();  
        // // Create
        // admin a1 = new admin(null, "jull", "qwerty");
        // vip v1 = new vip(null,"jamal", "qwerty");
        // member m1 = new member(null, "zaki", "qwerty");
        // // Read
        // pdao.readPengguna(a1.getUsername());
        // pdao.readPengguna(v1.getUsername());
        // pdao.readPengguna(m1.getUsername());
        // // Update
        // a1.setEmail("jull@gmail.com");
        // v1.setEmail("jamal@gmail.com");
        // m1.setEmail("zaki@gmail.com");
        // pdao.readPengguna(a1.getUsername());
        // pdao.readPengguna(v1.getUsername());
        // pdao.readPengguna(m1.getUsername());
        // // Delete
        // pdao.deletePengguna(a1.getUsername());
        // pdao.deletePengguna(v1.getUsername());
        // pdao.deletePengguna(m1.getUsername());
        // pdao.readPengguna(v1.getUsername());
        // pdao.readPengguna(m1.getUsername());

        // //-----tes CRUD pc-----
        // pcDao pcDao = new pcDao();
        // // Create
        // pcReguler pcr1 = new pcReguler("PC-R001");
        // pcVip pcv1 = new pcVip("PC-V001");
        // pcReguler pcr2 = new pcReguler("PC-R002");
        // // Read
        // pcDao.readPc(pcr1.getNomor_pc());
        // pcDao.readPc(pcv1.getNomor_pc());
        // pcDao.readPc(pcr2.getNomor_pc());
        // //Update
        // pcDao.updatePc(pcr1.getNomor_pc(), true);
        // pcDao.updatePc(pcv1.getNomor_pc(), true);
        // pcDao.updatePc(pcr2.getNomor_pc(), true);
        // pcDao.readPc(pcr1.getNomor_pc());
        // pcDao.readPc(pcv1.getNomor_pc());
        // pcDao.readPc(pcr2.getNomor_pc());
        // // Delete
        // pcDao.deletePc(pcr1.getNomor_pc());
        // pcDao.deletePc(pcv1.getNomor_pc());
        // pcDao.deletePc(pcr2.getNomor_pc());

    }
}