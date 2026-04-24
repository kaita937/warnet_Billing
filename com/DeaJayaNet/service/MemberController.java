package com.DeaJayaNet.service;

import javax.swing.JOptionPane;

import com.DeaJayaNet.dao.user.UserDao;
import com.DeaJayaNet.model.user.Member;
import com.DeaJayaNet.model.user.Admin;
import com.DeaJayaNet.model.user.Vip;

public class MemberController {

    private UserDao userDao ;

    //konstruktor
    public MemberController(UserDao userDao) {
        this.userDao = userDao;
    }

    public void daftarMemberBaru(String name, String username, String password, String email, String phoneNumber) {
        
        int remainingTime = 0;

        if (username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        try {

            Member memberBaru = new Member(name, username, password, email, phoneNumber, remainingTime);

            boolean berhasil = userDao.createUserMember(memberBaru);

            if (berhasil) {
                JOptionPane.showMessageDialog(null, "Akun Member berhasil dibuat!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal membuat akun. Username mungkin sudah ada.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saldo harus berupa angka!");
        }
    }

    public void daftarVIPBaru(String name, String username, String password, String email, String phoneNumber) {
        
        int remainingTime = 0;

        if (username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        try {

            Vip VIPBaru = new Vip(name, username, password, email, phoneNumber, remainingTime);

            boolean berhasil = userDao.createUserVIP(VIPBaru);

            if (berhasil) {
                JOptionPane.showMessageDialog(null, "Akun VIP berhasil dibuat!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal membuat akun. Username mungkin sudah ada.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saldo harus berupa angka!");
        }
    }

    public void daftarAdminBaru(String name, String username, String password, String email, String phoneNumber) {
        
        int remainingTime = 0;

        if (username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        try {

            Admin adminBaru = new Admin(name, username, password, email, phoneNumber, remainingTime);

            boolean berhasil = userDao.createUserAdmin(adminBaru);

            if (berhasil) {
                JOptionPane.showMessageDialog(null, "Akun Admin berhasil dibuat!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal membuat akun. Username mungkin sudah ada.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saldo harus berupa angka!");
        }
    }
    
}
