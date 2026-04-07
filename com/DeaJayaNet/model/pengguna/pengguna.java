package com.DeaJayaNet.model.pengguna;

import com.DeaJayaNet.dao.pengguna.penggunaDao;

public abstract class pengguna{

    private String nama ;
    private String username ;
    private String password ;
    private String email ;
    private String noTelp ;
    protected String role;
    penggunaDao pdao = new penggunaDao();

    // konstrukror
    public pengguna () {
        this.nama = null ;
        this.username = null ;
        this.password = null ;
        this.email = null ;
        this.noTelp = null ;
        this.role = getRole();
    }

    public pengguna (String nama, String username, String password) {
        this.nama = nama ;
        this.username = username ;
        this.password = password ;
        this.email = null ;
        this.noTelp = null ;
        this.role = getRole();
    }

    public pengguna (String nama, String username, String password, String email) {
        this.nama = nama ;
        this.username = username ;
        this.password = password ;
        this.email = email ;
        this.noTelp = null ;
        this.role = getRole();
    }

    public pengguna (String nama, String username, String password, String email, String noTelp) {
        this.nama = nama ;
        this.username = username ; 
        this.password = password ;
        this.email = email ;
        this.noTelp = noTelp ;
        this.role = getRole();
    }

    // setter
    public void setNama (String nama) {
        this.nama = nama;
        this.role = getRole();
    }

    public void setUsername (String username) {
        this.username = username;
        this.role = getRole();
    }

    public void setPassword (String password) {
        this.password = password;
        this.role = getRole();
    }

    public void setEmail (String email) {
        this.email = email;
        this.role = getRole();
    }

    public void setNoTelp (String noTelp) {
        this.noTelp = noTelp;
        this.role = getRole();
    }

    // getter
    public String getNama () {
        return this.nama;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

    public String getEmail () {
        return this.email;
    }

    public String getNoTelp () {
        return this.noTelp;
    }

    public abstract String getRole();

}
