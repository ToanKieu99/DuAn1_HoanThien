package src.model;

public class QuanLyModel {
    String maQL,tenQL,chuvuQL,quoctichQL;
    double luongQL;
    String ghiChu;
    public QuanLyModel() {
    }

    public QuanLyModel(String maQL, String tenQL, String chuvuQL, String quoctichQL, double luongQL, String ghiChu) {
        this.maQL = maQL;
        this.tenQL = tenQL;
        this.chuvuQL = chuvuQL;
        this.quoctichQL = quoctichQL;
        this.luongQL = luongQL;
        this.ghiChu = ghiChu;
    }

    public String getMaQL() {
        return maQL;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }

    public String getTenQL() {
        return tenQL;
    }

    public void setTenQL(String tenQL) {
        this.tenQL = tenQL;
    }

    public String getChuvuQL() {
        return chuvuQL;
    }

    public void setChuvuQL(String chuvuQL) {
        this.chuvuQL = chuvuQL;
    }

    public String getQuoctichQL() {
        return quoctichQL;
    }

    public void setQuoctichQL(String quoctichQL) {
        this.quoctichQL = quoctichQL;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getLuongQL() {
        return luongQL;
    }

    public void setLuongQL(double luongQL) {
        this.luongQL = luongQL;
    }

    @Override
    public String toString() {
        return "QuanLyModel{" +
                "maQL='" + maQL + '\'' +
                ", tenQL='" + tenQL + '\'' +
                ", chuvuQL='" + chuvuQL + '\'' +
                ", quoctichQL='" + quoctichQL + '\'' +
                ", luongQL=" + luongQL +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
