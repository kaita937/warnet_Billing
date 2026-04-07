package com.DeaJayaNet.model.pengguna;

public class vip extends pengguna {

    String role = "VIP";

    // konstruktor
    public vip () {
        super();
        this.role = "VIP";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public vip(String nama, String username, String password) {
        super(nama, username, password);
        this.role = "VIP";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public vip(String nama, String username, String password, String email) {
        super(nama, username, password, email);
        this.role = "VIP";
        pdao.createPengguna(super.getNama(), super.getUsername(), super.getPassword(), super.getEmail(), super.getNoTelp(), this.role);
    }

    public vip(String nama, String username, String password, String email, String noTelp) {
        super(nama, username, password, email, noTelp);
        this.role = "VIP";
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
