package src.database;

public class DoiHinhChinhDao {
    public static final String TABLE_NAME = "DoiHinhChinh";
    public static final String SQL_DOI_HINH_CHINH = "CREATE TABLE DoiHinhChinh(MaCTDH text primary key, " +
            "tenCTDH text, ChiSoCTDH text, QuocTichDH text, GiaCH double, avatarDH int)";

}
