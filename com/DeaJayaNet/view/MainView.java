package com.DeaJayaNet.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JButton loginButton;
    private JButton signUpButton;

    public MainView() {
        setTitle("Welcome to DeaJayaNet");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        loginButton = new JButton("Login");
        loginButton.setBounds(40, 40, 100, 25);
        panel.add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(150, 40, 100, 25);
        panel.add(signUpButton);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addSignUpListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }
}
