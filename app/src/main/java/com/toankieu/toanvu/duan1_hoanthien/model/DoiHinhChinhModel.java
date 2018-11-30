package com.toankieu.toanvu.duan1_hoanthien.model;

public class DoiHinhChinhModel {
    String maCTDHC, tenCTDHC, vitriDHC, chiSoDHC, quoctichDHC;
    double giaCTDHC;

    public DoiHinhChinhModel() {
    }

    public DoiHinhChinhModel(String maCTDHC, String tenCTDHC, String vitriDHC, String chiSoDHC, String quoctichDHC, double giaCTDHC) {
        this.maCTDHC = maCTDHC;
        this.tenCTDHC = tenCTDHC;
        this.vitriDHC = vitriDHC;
        this.chiSoDHC = chiSoDHC;
        this.quoctichDHC = quoctichDHC;
        this.giaCTDHC = giaCTDHC;
    }

    public String getMaCTDHC() {
        return maCTDHC;
    }

    public void setMaCTDHC(String maCTDHC) {
        this.maCTDHC = maCTDHC;
    }

    public String getVitriDHC() {
        return vitriDHC;
    }

    public void setVitriDHC(String vitriDHC) {
        this.vitriDHC = vitriDHC;
    }

    public String getTenCTDHC() {
        return tenCTDHC;
    }

    public void setTenCTDHC(String tenCTDHC) {
        this.tenCTDHC = tenCTDHC;
    }

    public String getChiSoDHC() {
        return chiSoDHC;
    }

    public void setChiSoDHC(String chiSoDHC) {
        this.chiSoDHC = chiSoDHC;
    }

    public String getQuoctichDHC() {
        return quoctichDHC;
    }

    public void setQuoctichDHC(String quoctichDHC) {
        this.quoctichDHC = quoctichDHC;
    }

    public double getGiaCTDHC() {
        return giaCTDHC;
    }

    public void setGiaCTDHC(double giaCTDHC) {
        this.giaCTDHC = giaCTDHC;
    }


    @Override
    public String toString() {
        return "DoiHinhChinhModel{" +
                "maCTDHC='" + maCTDHC + '\'' +
                ", tenCTDHC='" + tenCTDHC + '\'' +
                ", vitriDHC='" + vitriDHC + '\'' +
                ", chiSoDHC='" + chiSoDHC + '\'' +
                ", quoctichDHC='" + quoctichDHC + '\'' +
                ", giaCTDHC=" + giaCTDHC +
                '}';
    }
}
