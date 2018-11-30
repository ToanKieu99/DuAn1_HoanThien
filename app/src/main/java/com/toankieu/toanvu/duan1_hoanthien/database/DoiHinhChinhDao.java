package com.toankieu.toanvu.duan1_hoanthien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;

import java.util.ArrayList;
import java.util.List;

public class DoiHinhChinhDao {
    public SQLiteDatabase db;
    public DatabaseSQL dbHelper;

    public static final String TABLE_NAME = "DoiHinhChinh";
    public static final String SQL_DOI_HINH_CHINH = "CREATE TABLE DoiHinhChinh(MaCTDHC text primary key, " +
            "tenCTDHC text,ViTriDHC text, ChiSoCTDHC text, QuocTichDHC text, GiaCHC double)";
    public static final String TAG = "DoiHinhChinhDao";

    public DoiHinhChinhDao(Context context) {
        dbHelper = new DatabaseSQL(context);
        db = dbHelper.getWritableDatabase();
    }

    //Insert
    public int insertDoiHinhChinh(DoiHinhChinhModel dh) {
        ContentValues values = new ContentValues();
        values.put("MaCTDHC", dh.getMaCTDHC());
        values.put("tenCTDHC", dh.getTenCTDHC());
        values.put("ViTriDHC", dh.getVitriDHC());
        values.put("ChiSoCTDHC", dh.getChiSoDHC());
        values.put("QuocTichDHC", dh.getQuoctichDHC());
        values.put("GiaCHC", dh.getGiaCTDHC());
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
    public List<DoiHinhChinhModel> getAllDoiHinhChinh() {
        List<DoiHinhChinhModel> dsDH = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            DoiHinhChinhModel dh = new DoiHinhChinhModel();
            dh.setMaCTDHC(c.getString(0));
            dh.setTenCTDHC(c.getString(1));
            dh.setVitriDHC(c.getString(2));
            dh.setChiSoDHC(c.getString(3));
            dh.setQuoctichDHC(c.getString(4));
            dh.setGiaCTDHC(Double.parseDouble(c.getString(5)));
            dsDH.add(dh);
            Log.d("//====", dh.toString());
            c.moveToNext();
        }
        c.close();
        return dsDH;
    }

    public int updateDoiHinhChinh(String mact, String tenCT, String vt, String csct, String qt, double g) {
        ContentValues values = new ContentValues();
        values.put("MaCTDHC", mact);
        values.put("tenCTDHC", tenCT);
        values.put("ViTriDHC", vt);
        values.put("ChiSoCTDHC", csct);
        values.put("QuocTichDHC", qt);
        values.put("GiaCHC", g);
        int result = db.update(TABLE_NAME, values, "MaCTDHC=?", new String[]{mact});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteDoiHinhChinh(String mact) {
        int result = db.delete(TABLE_NAME, "MaCTDHC=?", new String[]{mact});
        if (result == 0)
            return -1;
        return 1;
    }

}
