package com.toankieu.toanvu.duan1_hoanthien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseSQL extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "clb";
    public static final int VERSION = 1;

    public DatabaseSQL(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CauThuNoiBatDao.SQL_DANH_SACH_CAU_THU);
        db.execSQL(DanhSachBanQuanLyDao.SQL_DANH_SACH_QUAN_LY);
        db.execSQL(CauThuDao.SQL_CAU_THU);
        db.execSQL(DoiHinhChinhDao.SQL_DOI_HINH_CHINH);
        db.execSQL(DoiHinhPhuDao.SQL_DOI_HINH_PHU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" Drop table if exists " + CauThuNoiBatDao.TABLE_NAME);
        db.execSQL(" Drop table if exists " + DanhSachBanQuanLyDao.TABLE_NAME);
        db.execSQL(" Drop table if exists " + CauThuDao.TABLE_NAME);
        db.execSQL(" Drop table if exists " + DoiHinhChinhDao.TABLE_NAME);
        db.execSQL(" Drop table if exists " + DoiHinhPhuDao.TABLE_NAME);
        onCreate(db);
    }
}
