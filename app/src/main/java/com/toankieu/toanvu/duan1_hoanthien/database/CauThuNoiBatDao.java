package com.toankieu.toanvu.duan1_hoanthien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.toankieu.toanvu.duan1_hoanthien.model.CauThuNoiBatModel;

public class CauThuNoiBatDao {
    private SQLiteDatabase db;
    private DatabaseSQL dbHeper;
    public static final String TABLE_NAME = "DSCauThu";
    public static final String SQL_DANH_SACH_CAU_THU = "CREATE TABLE DSCauThu(MaCTDS text primary key," +
            " TenCTDS text,ViTri text, ChiSoCTDS text, QuocTichDS text, GiaCTDS double)";
    public static final String TAG = "CauThuNoiBatDao";

    public CauThuNoiBatDao(Context context) {
        dbHeper = new DatabaseSQL(context);
        db = dbHeper.getWritableDatabase();
    }

    //insert
    public int insertDanhSachCT(CauThuNoiBatModel ct) {
        ContentValues values = new ContentValues();
        values.put("MaCTDS", ct.getMactNB());
        values.put("TenCTDS", ct.getTenCTNB());
        values.put("ViTri", ct.getVitriCTNB());
        values.put("ChiSoCTDS", ct.getChisoCTNB());
        values.put("QuocTichDS", ct.getQuoctichCTNB());
        values.put("GiaCTDS", ct.getGiaCTNB());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return 1;
    }

    //getALL
    public List<CauThuNoiBatModel> getALLCauThuNB() {
        List<CauThuNoiBatModel> dsCT = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            CauThuNoiBatModel ctnb = new CauThuNoiBatModel();
            ctnb.setMactNB(c.getString(0));
            ctnb.setTenCTNB(c.getString(1));
            ctnb.setVitriCTNB(c.getString(2));
            ctnb.setChisoCTNB(c.getString(3));
            ctnb.setQuoctichCTNB(c.getString(4));
            ctnb.setGiaCTNB(c.getString(5));
            dsCT.add(ctnb);
            Log.d("//====", ctnb.toString());
            c.moveToNext();
        }
        c.close();
        return dsCT;
    }

    ///Update
    public int updateinfoDanhSachCT(String mct, String tenCT, String vt, String chisoCT, double giaCT) {
        ContentValues values = new ContentValues();
        values.put("MaCTDS", mct);
        values.put("TenCTDS", tenCT);
        values.put("ChiSoCTDS", chisoCT);
        values.put("ViTri", vt);
        values.put("QuocTichDS", giaCT);
        int result = db.update(TABLE_NAME, values, "MaCTDS=?", new String[]{mct});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteDanhsachCTNT(String mact) {
        int result = db.delete(TABLE_NAME, "MaCTDS=?", new String[]{mact});
        if (result == 0)
            return -1;
        return 1;
    }
}
