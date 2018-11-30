package com.toankieu.toanvu.duan1_hoanthien.model;

public class DoiHinhPhuModel {
    String maCTDHP, tenCTDHP, vitriDHP, chiSoDHP, quoctichDHP;
    double giaCTDHP;

    public DoiHinhPhuModel() {
    }

    public DoiHinhPhuModel(String maCTDHP, String tenCTDHP, String vitriDHP, String chiSoDHP, String quoctichDHP, double giaCTDHP) {
        this.maCTDHP = maCTDHP;
        this.tenCTDHP = tenCTDHP;
        this.vitriDHP = vitriDHP;
        this.chiSoDHP = chiSoDHP;
        this.quoctichDHP = quoctichDHP;
        this.giaCTDHP = giaCTDHP;
    }

    public String getVitriDHP() {
        return vitriDHP;
    }

    public void setVitriDHP(String vitriDHP) {
        this.vitriDHP = vitriDHP;
    }

    public String getMaCTDHP() {
        return maCTDHP;
    }

    public void setMaCTDHP(String maCTDHP) {
        this.maCTDHP = maCTDHP;
    }

    public String getTenCTDHP() {
        return tenCTDHP;
    }

    public void setTenCTDHP(String tenCTDHP) {
        this.tenCTDHP = tenCTDHP;
    }

    public String getChiSoDHP() {
        return chiSoDHP;
    }

    public void setChiSoDHP(String chiSoDHP) {
        this.chiSoDHP = chiSoDHP;
    }

    public String getQuoctichDHP() {
        return quoctichDHP;
    }

    public void setQuoctichDHP(String quoctichDHP) {
        this.quoctichDHP = quoctichDHP;
    }

    public double getGiaCTDHP() {
        return giaCTDHP;
    }

    public void setGiaCTDHP(double giaCTDHP) {
        this.giaCTDHP = giaCTDHP;
    }

    @Override
    public String toString() {
        return "DoiHinhPhuModel{" +
                "maCTDHP='" + maCTDHP + '\'' +
                ", tenCTDHP='" + tenCTDHP + '\'' +
                ", vitriDHP='" + vitriDHP + '\'' +
                ", chiSoDHP='" + chiSoDHP + '\'' +
                ", quoctichDHP='" + quoctichDHP + '\'' +
                ", giaCTDHP=" + giaCTDHP +
                '}';
    }
}
