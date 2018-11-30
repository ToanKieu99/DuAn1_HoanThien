package com.toankieu.toanvu.duan1_hoanthien.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.database.CauThuDao;
import com.toankieu.toanvu.duan1_hoanthien.database.CauThuNoiBatDao;

public class DetailsCauThu extends AppCompatActivity {
    private ImageView showDetailCT;
    private TextView detailNameCT;
    private TextView detailCstlCT;
    private TextView detailVtCT;
    private TextView detailQtCT;
    private TextView detailGiaCT;
    private TextView detailGhichuCT;
    CauThuDao cauThuDao;
    String strName, strChiSo, strVT, strQT, strGia, strGhiChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_cau_thu);

        showDetailCT = (ImageView) findViewById(R.id.show_detail_CT);
        detailNameCT = (TextView) findViewById(R.id.detail_nameCT);
        detailCstlCT = (TextView) findViewById(R.id.detail_cstlCT);
        detailVtCT = (TextView) findViewById(R.id.detail_vtCT);
        detailQtCT = (TextView) findViewById(R.id.detail_qtCT);
        detailGiaCT = (TextView) findViewById(R.id.detail_giaCT);
        detailGhichuCT = (TextView) findViewById(R.id.detail_ghichuCT);

        showDetailCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cauThuDao = new CauThuDao(this);
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        strName = b1.getString("TENCT");
        strChiSo = b1.getString("CHISOCT");
        strVT = b1.getString("VITRICT");
        strQT = b1.getString("QUOCTICH");
        strGia = b1.getString("GIACT");
        strGhiChu = b1.getString("GHICHU");
        detailNameCT.setText(strName);
        detailCstlCT.setText(strChiSo);
        detailVtCT.setText(strVT);
        detailQtCT.setText(strQT);
        detailGiaCT.setText(strGia);
        detailGhichuCT.setText(strGhiChu);


    }
}
