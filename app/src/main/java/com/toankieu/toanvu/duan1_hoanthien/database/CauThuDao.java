package com.toankieu.toanvu.duan1_hoanthien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.toankieu.toanvu.duan1_hoanthien.model.CauThuModel;

import java.util.ArrayList;
import java.util.List;

public class CauThuDao {
    private SQLiteDatabase db;
    private DatabaseSQL dbHelper;
    public static final String TABLE_NAME = "CauThu";
    public static final String SQL_CAU_THU = "CREATE TABLE CauThu( MaCT text primary key,TenCT text, ChiSoCT text," +
            "VtiTriCT text," +
            "QuocTichCT text, GiaCT text, GhiChuCT text)";

    public static final String TAG = "CauThuDao";

    public CauThuDao(Context context) {
        dbHelper = new DatabaseSQL(context);
        db = dbHelper.getWritableDatabase();
    }

    //Insert
    public int insertCauThu(CauThuModel ct) {
        ContentValues values = new ContentValues();
        values.put("MaCT", ct.getMaCT());
        values.put("TenCT", ct.getTenCT());
        values.put("ChiSoCT", ct.getChisoCT());
        values.put("VtiTriCT", ct.getVitriCT());
        values.put("QuocTichCT", ct.getQuoctichCT());
        values.put("GiaCT", ct.getGiaCT());
        values.put("GhiChuCT", ct.getGhichuCT());
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
    public List<CauThuModel> getAllCauThu() {
        List<CauThuModel> dsCT = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            CauThuModel ct = new CauThuModel();
            ct.setMaCT(c.getString(0));
            ct.setTenCT(c.getString(1));
            ct.setChisoCT(c.getString(2));
            ct.setVitriCT(c.getString(3));
            ct.setQuoctichCT(c.getString(4));
            ct.setGiaCT(Double.parseDouble(c.getString(5)));
            ct.setGhichuCT(c.getString(6));
            dsCT.add(ct);
            Log.d("//====", ct.toString());
            c.moveToNext();
        }
        c.close();
        return dsCT;
    }

    public int updateCauThu(String mact, String tenCT, String csct, String vt, String qtCT, String giaCT, String gc) {
        ContentValues values = new ContentValues();
        values.put("MaCT", mact);
        values.put("TenCT", tenCT);
        values.put("ChiSoCT", csct);
        values.put("VtiTriCT", vt);
        values.put("QuocTichCT", qtCT);
        values.put("GiaCT", giaCT);
        values.put("GhiChuCT", gc);
        int result = db.update(TABLE_NAME, values, "MaCT=?", new String[]{mact});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteCauThu(String mact) {
        int result = db.delete(TABLE_NAME, "MaCT=?", new String[]{mact});
        if (result == 0)
            return -1;
        return 1;
    }
}
