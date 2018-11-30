package com.toankieu.toanvu.duan1_hoanthien.model;

public class CauThuModel {
    String maCT, tenCT, chisoCT, vitriCT, quoctichCT;
    double giaCT;
    String ghichuCT;

    public CauThuModel(String maCT, String tenCT, String chisoCT, String quoctichCT, double giaCT, String ghichuCT) {
        this.maCT = maCT;
        this.tenCT = tenCT;
        this.chisoCT = chisoCT;
        this.quoctichCT = quoctichCT;
        this.giaCT = giaCT;
        this.ghichuCT = ghichuCT;
    }

    public CauThuModel(String maCT, String tenCT, String chisoCT, String vitriCT, String quoctichCT, double giaCT, String ghichuCT) {
        this.maCT = maCT;
        this.tenCT = tenCT;
        this.chisoCT = chisoCT;
        this.vitriCT = vitriCT;
        this.quoctichCT = quoctichCT;
        this.giaCT = giaCT;
        this.ghichuCT = ghichuCT;
    }

    public CauThuModel() {
    }

    public String getVitriCT() {
        return vitriCT;
    }

    public void setVitriCT(String vitriCT) {
        this.vitriCT = vitriCT;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public String getChisoCT() {
        return chisoCT;
    }

    public void setChisoCT(String chisoCT) {
        this.chisoCT = chisoCT;
    }

    public String getQuoctichCT() {
        return quoctichCT;
    }

    public void setQuoctichCT(String quoctichCT) {
        this.quoctichCT = quoctichCT;
    }

    public double getGiaCT() {
        return giaCT;
    }

    public void setGiaCT(double giaCT) {
        this.giaCT = giaCT;
    }

    public String getGhichuCT() {
        return ghichuCT;
    }

    public void setGhichuCT(String ghichuCT) {
        this.ghichuCT = ghichuCT;
    }

    @Override
    public String toString() {
        return "CauThuModel{" +
                "maCT='" + maCT + '\'' +
                ", tenCT='" + tenCT + '\'' +
                ", chisoCT='" + chisoCT + '\'' +
                ", vitriCT='" + vitriCT + '\'' +
                ", quoctichCT='" + quoctichCT + '\'' +
                ", giaCT=" + giaCT +
                ", ghichuCT='" + ghichuCT + '\'' +
                '}';
    }
}

