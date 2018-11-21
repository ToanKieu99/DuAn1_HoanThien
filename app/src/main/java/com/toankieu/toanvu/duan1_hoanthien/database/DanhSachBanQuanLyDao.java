package com.toankieu.toanvu.duan1_hoanthien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.toankieu.toanvu.duan1_hoanthien.model.QuanLyModel;

public class DanhSachBanQuanLyDao {
    private SQLiteDatabase db;
    private DatabaseSQL dbHelper;

    public static final String TABLE_NAME = "QuanLy";
    public static final String SQL_DANH_SACH_QUAN_LY = "CREATE TABLE QuanLy(MaQL text primary key, TenQL text," +
            " ChuVuQL text, QuocTichQL text, LuongQL double,Ghichu text)";
    public static final String TAG = "DanhSachBanQuanLyDao";

    public DanhSachBanQuanLyDao(Context context) {
        this.dbHelper = new DatabaseSQL(context);
        this.db = dbHelper.getWritableDatabase();
    }

    //insert
    public  int insertDanhSachBanQL(QuanLyModel ql){
        ContentValues values = new ContentValues();
        values.put("MaQL",ql.getMaQL());
        values.put("TenQL",ql.getTenQL());
        values.put("ChuVuQL",ql.getChuvuQL());
        values.put("QuocTichQL",ql.getQuoctichQL());
        values.put("LuongQL",ql.getLuongQL());
        values.put("Ghichu",ql.getGhiChu());
        try {
            if (db.insert(TABLE_NAME,null,values) == -1){
                return  -1;
            }
        }catch (Exception e){
            Log.e(TAG,e.toString());
        }
        return  1;
    }

    public List<QuanLyModel> getALLQuanLy(){
        List<QuanLyModel> dsQL = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            QuanLyModel ql = new QuanLyModel();
            ql.setMaQL(c.getString(0));
            ql.setTenQL(c.getString(1));
            ql.setChuvuQL(c.getString(2));
            ql.setQuoctichQL(c.getString(3));
            ql.setLuongQL(Double.parseDouble(c.getString(4)));
            ql.setGhiChu(c.getString(5));
            dsQL.add(ql);
            Log.d("//====",ql.toString());
            c.moveToNext();
        }
        c.close();
        return dsQL;
    }


    public int updateInforBanQuanLy(String maQL, String tenQL, String cvql, String qtQL, String luongQL, String ghiChu){
        ContentValues values = new ContentValues();
        values.put("MaQL",maQL);
        values.put("TenQL",tenQL);
        values.put("ChuVuQL",cvql);
        values.put("QuocTichQL",qtQL);
        values.put("LuongQL",luongQL);
        values.put("Ghichu",ghiChu);
        int result = db.update(TABLE_NAME,values,"MaQL=?",new String[]{maQL});
        if (result == 0){
            return -1;
        }
        return 1;
        }
        public int deleteBanhSachQL(String maQL){
            int result = db.delete(TABLE_NAME,"MaQL=?",new String[]{maQL});
            if (result == 0)
                return -1;
            return 1;
        }
}

