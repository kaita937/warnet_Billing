package com.DeaJayaNet.model.pc;

public class pcVip extends pc {

    String tipe_pc = "Vip";
    
    //konstruktor
    public pcVip() {
        super();
        this.tipe_pc = "Vip";
        pcDao.createPc(super.getNomor_pc(), super.getStatus(), this.getTipe_pc());
    }

    public pcVip(String nomor_pc) {
        super(nomor_pc);
        this.tipe_pc = "Vip";
        pcDao.createPc(super.getNomor_pc(), super.getStatus(), this.getTipe_pc());
    }

    public pcVip(String nomor_pc, boolean status) {
        super(nomor_pc, status);
        this.tipe_pc = "Vip";
        pcDao.createPc(super.getNomor_pc(), super.getStatus(), this.getTipe_pc());
    }

    @Override
    public String getTipe_pc() {
        return this.tipe_pc;
    }

    //setter
    public void setTipe_pc(String nomor_pc) {
        super.setNomor_pc(nomor_pc);
    }

    public void setStatus(boolean status) {
        super.setStatus(status);
    }

}
