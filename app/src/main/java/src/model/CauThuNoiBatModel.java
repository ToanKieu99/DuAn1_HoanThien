package src.model;

public class CauThuNoiBatModel {
    String mactNB,tenCTNB,vitriCTNB,chisoCTNB,quoctichCTNB,giaCTNB;

    public CauThuNoiBatModel() {
    }

    public CauThuNoiBatModel(String mactNB, String tenCTNB, String vitriCTNB, String chisoCTNB, String quoctichCTNB, String giaCTNB) {
        this.mactNB = mactNB;
        this.tenCTNB = tenCTNB;
        this.vitriCTNB = vitriCTNB;
        this.chisoCTNB = chisoCTNB;
        this.quoctichCTNB = quoctichCTNB;
        this.giaCTNB = giaCTNB;
    }

    public String getMactNB() {
        return mactNB;
    }

    public void setMactNB(String mactNB) {
        this.mactNB = mactNB;
    }

    public String getTenCTNB() {
        return tenCTNB;
    }

    public void setTenCTNB(String tenCTNB) {
        this.tenCTNB = tenCTNB;
    }

    public String getVitriCTNB() {
        return vitriCTNB;
    }

    public void setVitriCTNB(String vitriCTNB) {
        this.vitriCTNB = vitriCTNB;
    }

    public String getChisoCTNB() {
        return chisoCTNB;
    }

    public void setChisoCTNB(String chisoCTNB) {
        this.chisoCTNB = chisoCTNB;
    }

    public String getQuoctichCTNB() {
        return quoctichCTNB;
    }

    public void setQuoctichCTNB(String quoctichCTNB) {
        this.quoctichCTNB = quoctichCTNB;
    }

    public String getGiaCTNB() {
        return giaCTNB;
    }

    public void setGiaCTNB(String giaCTNB) {
        this.giaCTNB = giaCTNB;
    }

    @Override
    public String toString() {
        return "CauThuNoiBatModel{" +
                "mactNB='" + mactNB + '\'' +
                ", tenCTNB='" + tenCTNB + '\'' +
                ", vitriCTNB='" + vitriCTNB + '\'' +
                ", chisoCTNB='" + chisoCTNB + '\'' +
                ", quoctichCTNB='" + quoctichCTNB + '\'' +
                ", giaCTNB='" + giaCTNB + '\'' +
                '}';
    }
}
