package com.DeaJayaNet.main;

import javax.swing.SwingUtilities;
import com.DeaJayaNet.controller.LoginController;
import com.DeaJayaNet.controller.SignUpController;
import com.DeaJayaNet.dao.DatabaseConnection;
import com.DeaJayaNet.dao.user.UserDao;
import com.DeaJayaNet.service.AuthService;
import com.DeaJayaNet.view.LoginView;
import com.DeaJayaNet.view.MainView;
import com.DeaJayaNet.view.SignUpView;

public class main { 
    public static void main(String[] args) {

        // PENTING: Eksekusi pembuatan tabel SATU KALI saja di awal program
        DatabaseConnection.createNewTable();

        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            UserDao userDao = new UserDao();
            AuthService authService = new AuthService(userDao);

            mainView.addLoginListener(e -> {
                LoginView loginView = new LoginView();
                new LoginController(loginView, authService).showView();
                mainView.dispose();
            });

            mainView.addSignUpListener(e -> {
                SignUpView signUpView = new SignUpView();
                new SignUpController(signUpView, userDao).showView();
                mainView.dispose();
            });

            mainView.setVisible(true);
        });

    }
}