package com.toankieu.toanvu.duan1_hoanthien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhPhuModel;

import java.util.ArrayList;
import java.util.List;

public class DoiHinhPhuDao {
    public SQLiteDatabase db;
    public DatabaseSQL dbHelper;
    public static final String TABLE_NAME = "DanhSachCauThuNoiBat";
    public static final String SQL_DOI_HINH_PHU = "CREATE TABLE DanhSachCauThuNoiBat(MaCTDHP text primary key, " +
            "TenCTDHP text,VitriCTDHP text,ChiSoDHP text, QTCTDHP text, GiaCTDHP double)";
    public static final String TAG = "DoiHinhPhuDao";

    public DoiHinhPhuDao(Context context) {
        dbHelper = new DatabaseSQL(context);
        db = dbHelper.getWritableDatabase();
    }

    //Insert
    public int insertDoiHinhPhu(DoiHinhPhuModel dh) {
        ContentValues values = new ContentValues();
        values.put("MaCTDHP", dh.getMaCTDHP());
        values.put("TenCTDHP", dh.getTenCTDHP());
        values.put("VitriCTDHP", dh.getVitriDHP());
        values.put("ChiSoDHP", dh.getChiSoDHP());
        values.put("QTCTDHP", dh.getQuoctichDHP());
        values.put("GiaCTDHP", dh.getGiaCTDHP());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return 1;
    }

    ///getAll
    public List<DoiHinhPhuModel> getAllDoiHinhPhu() {
        List<DoiHinhPhuModel> dsDH = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            DoiHinhPhuModel dh = new DoiHinhPhuModel();
            dh.setChiSoDHP(c.getString(0));
            dh.setTenCTDHP(c.getString(1));
            dh.setVitriDHP(c.getString(2));
            dh.setChiSoDHP(c.getString(3));
            dh.setQuoctichDHP(c.getString(4));
            dh.setGiaCTDHP(Double.parseDouble(c.getString(5)));
            dsDH.add(dh);
            Log.d("//====", dh.toString());
            c.moveToNext();
        }
        c.close();
        return dsDH;
    }

    public int updateDoiHinhPhu(String mact, String tenCT, String vt, String csct, String qt, double giA) {
        ContentValues values = new ContentValues();
        values.put("MaCTDHP", mact);
        values.put("TenCTDHP", tenCT);
        values.put("VitriCTDHP", vt);
        values.put("ChiSoDHP", csct);
        values.put("QTCTDHP", qt);
        values.put("GiaCTDHP", giA);
        int result = db.update(TABLE_NAME, values, "MaCTDHP=?", new String[]{mact});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteDoiHinhPhu(String mact) {
        int result = db.delete(TABLE_NAME, "MaCTDHP=?", new String[]{mact});
        if (result == 0)
            return -1;
        return 1;
    }
}
