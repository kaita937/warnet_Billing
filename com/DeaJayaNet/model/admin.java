package com.DeaJayaNet.model;

public class admin extends pengguna{

    String role = "Admin";

    // konstruktor
    public admin () {
        super();
        this.role = "Admin";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public admin(String nama, String username, String password) {
        super(nama, username, password);
        this.role = "Admin";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public admin(String nama, String username, String password, String email) {
        super(nama, username, password, email);
        this.role = "Admin";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public admin(String nama, String username, String password, String email, String noTelp) {
        super(nama, username, password, email, noTelp);
        this.role = "Admin";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    @Override
    public String getRole() {
        return this.role;
    }

    // setter
    public void setNama (String nama) {
        super.setNama(nama);
        this.role = getRole();
        pdao.updatePengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public void setUsername (String username) {
        super.setUsername(username);
        this.role = getRole();
        pdao.updatePengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public void setPassword (String password) {
        super.setPassword(password);
        this.role = getRole();
        pdao.updatePengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public void setEmail (String email) {
        super.setEmail(email);
        this.role = getRole();
        pdao.updatePengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public void setNoTelp (String noTelp) {
        super.setNoTelp(noTelp);
        this.role = getRole();
        pdao.updatePengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }
    
}
