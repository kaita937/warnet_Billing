package com.DeaJayaNet.main;

// Import disesuaikan dengan struktur class Bahasa Inggris kita
import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.dao.computer.ComputerDao; 
import com.DeaJayaNet.dao.user.UserDao;
import com.DeaJayaNet.model.food.FoodMenu;
import com.DeaJayaNet.model.computer.Computer;
import com.DeaJayaNet.model.computer.RegularComputer;
import com.DeaJayaNet.model.computer.VipComputer;
// import com.DeaJayaNet.model.transaksi.PaymentLog; 
// import com.DeaJayaNet.model.transaksi.Transaction; 
import com.DeaJayaNet.model.user.Admin;
import com.DeaJayaNet.model.user.Member;
import com.DeaJayaNet.model.user.Vip;

public class Main { 
    public static void main(String[] args) {

        // PENTING: Eksekusi pembuatan tabel SATU KALI saja di awal program
        DatabaseConnection.createNewTable();

        // note : 
        // Kalau mau akses database 'warnet.db', download dulu DB Browser (SQLite). 
        // Terus buka file warnet.db yang ada di folder project ini pakai DB Browser.
        System.out.println("=== TES CRUD USER ===");
        UserDao userDao = new UserDao();  
        
        Admin a1 = new Admin("Jull", "jull_admin", "qwerty");
        Vip v1 = new Vip("Jamal", "jamal_vip", "qwerty");
        Member m1 = new Member("Zaki", "zaki_member", "qwerty");
        
        // Read
        userDao.readUser(a1.getUsername());
        userDao.readUser(v1.getUsername());
        userDao.readUser(m1.getUsername());
        
        // Update
        a1.setEmail("jull@gmail.com");
        v1.setEmail("jamal@gmail.com");
        m1.setEmail("zaki@gmail.com");
        userDao.readUser(a1.getUsername());
        userDao.readUser(v1.getUsername());
        userDao.readUser(m1.getUsername());
        
        // Delete
        userDao.deleteUser(a1.getUsername());
        userDao.deleteUser(v1.getUsername());
        userDao.deleteUser(m1.getUsername());


        System.out.println("=== TES CRUD COMPUTER ===");
        ComputerDao computerDao = new ComputerDao();
        
        // Create
        RegularComputer pcr1 = new RegularComputer("PC-R001");
        VipComputer pcv1 = new VipComputer("PC-V001");
        RegularComputer pcr2 = new RegularComputer("PC-R002");
        
        // Read
        computerDao.readComputer(pcr1.getComputerNumber());
        computerDao.readComputer(pcv1.getComputerNumber());
        computerDao.readComputer(pcr2.getComputerNumber());
        
        // Update (Mengubah status isUnlocked jadi true)
        computerDao.updateComputer(pcr1.getComputerNumber(), true);
        computerDao.updateComputer(pcv1.getComputerNumber(), true);
        computerDao.updateComputer(pcr2.getComputerNumber(), true);
        
        computerDao.readComputer(pcr1.getComputerNumber());
        computerDao.readComputer(pcv1.getComputerNumber());
        computerDao.readComputer(pcr2.getComputerNumber());
        
        // Delete
        computerDao.deleteComputer(pcr1.getComputerNumber());
        computerDao.deleteComputer(pcv1.getComputerNumber());
        computerDao.deleteComputer(pcr2.getComputerNumber());

        //-----tes CRUD paymentlog-----
        System.out.println("=== TES CRUD SELESAI ===");
    }
}