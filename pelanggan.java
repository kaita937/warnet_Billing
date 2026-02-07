public class pelanggan {
    private String nama ;
    private String password ;

    public pelanggan (String nama, String password){
        this.nama = nama;
        this.password = password;
    }

    public void setNamaPelanggan(String nama){
        this.nama = nama;
    }

    public void setPasswordPelanggan(String password){
        this.password = password;
    }

    public String getNamaPelanggan(){
        return this.nama;
    }

    public String setPasswordPelanggan(){
        return this.password;
    }
}
