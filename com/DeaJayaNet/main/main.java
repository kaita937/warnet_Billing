package com.DeaJayaNet.main;

// Import disesuaikan dengan struktur class Bahasa Inggris kita
import com.DeaJayaNet.dao.DatabaseConnection;

//import user
import com.DeaJayaNet.dao.user.UserDao;
import com.DeaJayaNet.model.user.Admin;
import com.DeaJayaNet.model.user.Member;
import com.DeaJayaNet.model.user.Vip;

//import computer
import com.DeaJayaNet.dao.computer.ComputerDao;
import com.DeaJayaNet.model.computer.Computer;
import com.DeaJayaNet.model.computer.RegularComputer;
import com.DeaJayaNet.model.computer.VipComputer;

//import transaction
import com.DeaJayaNet.dao.transaction.TransactionDao;
import com.DeaJayaNet.dao.transaction.PaymentLogDao;
import com.DeaJayaNet.model.transaction.PaymentLog;
import com.DeaJayaNet.model.transaction.Transaction; 

//import food
import com.DeaJayaNet.dao.food.FoodMenusDao;
import com.DeaJayaNet.model.food.FoodMenus;

public class main { 
    public static void main(String[] args) {

        // PENTING: Eksekusi pembuatan tabel SATU KALI saja di awal program
        DatabaseConnection.createNewTable();

        // ---------------------------------------------------------------------------------------------------------
        // note : 
        // Kalau mau akses database 'warnet.db', download dulu DB Browser (SQLite). 
        // Terus buka file warnet.db yang ada di folder project ini pakai DB Browser.

        // ---------------------------------------------------------------------------------------------------------
        // System.out.println("=== TES CRUD USER ===");
        // UserDao userDao = new UserDao();  
        
        // Admin a1 = new Admin("Jull", "jull_admin", "qwerty");
        // Vip v1 = new Vip("Jamal", "jamal_vip", "qwerty");
        // Member m1 = new Member("Zaki", "zaki_member", "qwerty");
        
        // // Read
        // userDao.readUser(a1.getUsername());
        // userDao.readUser(v1.getUsername());
        // userDao.readUser(m1.getUsername());
        
        // // Update
        // a1.setEmail("jull@gmail.com");
        // v1.setEmail("jamal@gmail.com");
        // m1.setEmail("zaki@gmail.com");
        // userDao.readUser(a1.getUsername());
        // userDao.readUser(v1.getUsername());
        // userDao.readUser(m1.getUsername());
        
        // // Delete
        // userDao.deleteUser(a1.getUsername());
        // userDao.deleteUser(v1.getUsername());
        // userDao.deleteUser(m1.getUsername());

        // ---------------------------------------------------------------------------------------------------------
        // System.out.println("=== TES CRUD COMPUTER ===");
        // ComputerDao computerDao = new ComputerDao();
        
        // // Create
        // RegularComputer pcr1 = new RegularComputer("PC-R001");
        // VipComputer pcv1 = new VipComputer("PC-V001");
        // RegularComputer pcr2 = new RegularComputer("PC-R002");
        
        // // Read
        // computerDao.readComputer(pcr1.getComputerNumber());
        // computerDao.readComputer(pcv1.getComputerNumber());
        // computerDao.readComputer(pcr2.getComputerNumber());
        
        // // Update (Mengubah status isUnlocked jadi true)
        // computerDao.updateComputer(pcr1.getComputerNumber(), true);
        // computerDao.updateComputer(pcv1.getComputerNumber(), true);
        // computerDao.updateComputer(pcr2.getComputerNumber(), true);
        
        // computerDao.readComputer(pcr1.getComputerNumber());
        // computerDao.readComputer(pcv1.getComputerNumber());
        // computerDao.readComputer(pcr2.getComputerNumber());
        
        // // Delete
        // computerDao.deleteComputer(pcr1.getComputerNumber());
        // computerDao.deleteComputer(pcv1.getComputerNumber());
        // computerDao.deleteComputer(pcr2.getComputerNumber());

        // ---------------------------------------------------------------------------------------------------------
        // System.out.println("=== TES CRUD TRANSACTION ===");
        // PaymentLogDao paymentLog = new PaymentLogDao();
        // TransactionDao transactionDao = new TransactionDao();

        // // Create
        // Transaction t1 = new Transaction("1", "P001", "O001", "PESANAN", 100000, "PENDING", "Credit Card", "qris_string_example");
        // PaymentLog pl1 = new PaymentLog(transactionDao.getTransactionIdByOrderId(t1.getOrderId()), "PaymentLog-001");

        // // Update
        // t1.setStatus("PAID");
        // pl1.setSuccessful(false);

        // // Read
        // transactionDao.readTransaction(t1.getOrderId());
        // paymentLog.readPaymentLog(pl1.getPaymentLogName());

        // // Delete
        // transactionDao.deleteTransaction(t1.getOrderId());
        // paymentLog.deletePaymentLog(pl1.getPaymentLogName());

        // ---------------------------------------------------------------------------------------------------------
        System.out.println("=== TES CRUD food ===");
        FoodMenusDao foodMenusDao = new FoodMenusDao();

        // Create
        FoodMenus fm1 = new FoodMenus("Nasi Goreng", 15000, 10);
        FoodMenus fm2 = new FoodMenus("Mie Goreng", 12000, 15);

        // Read
        foodMenusDao.readFoodMenu(fm1.getName());
        foodMenusDao.readFoodMenu(fm2.getName());

        // Update
        foodMenusDao.updateFoodMenu(fm1.getName(), 16000, 8);
        foodMenusDao.updateFoodMenu(fm2.getName(), 13000, 12);

        // Delete
        foodMenusDao.deleteFoodMenu(fm1.getName());
        foodMenusDao.deleteFoodMenu(fm2.getName());

    }
}