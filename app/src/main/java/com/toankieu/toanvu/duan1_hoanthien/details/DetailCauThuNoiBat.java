package com.toankieu.toanvu.duan1_hoanthien.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.toankieu.toanvu.duan1_hoanthien.R;

import com.toankieu.toanvu.duan1_hoanthien.database.CauThuNoiBatDao;

public class DetailCauThuNoiBat extends AppCompatActivity {

    private ImageView showDetailCTNB;
    private TextView detailName;
    private TextView detailVt;
    private TextView detailQt;
    private TextView detailCstl;
    private TextView detailGia;
    private String strName,strTV, strQT,strCHISO,strGia;
    CauThuNoiBatDao cauThuNoiBatDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cau_thu_noi_bat);

        showDetailCTNB = (ImageView) findViewById(R.id.show_detail_CTNB);
        detailName = (TextView) findViewById(R.id.detail_name);
        detailVt = (TextView) findViewById(R.id.detail_vt);
        detailQt = (TextView) findViewById(R.id.detail_qt);
        detailCstl = (TextView) findViewById(R.id.detail_cstl);
        detailGia = (TextView) findViewById(R.id.detail_gia);

        showDetailCTNB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cauThuNoiBatDao = new CauThuNoiBatDao(this);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        strName = b.getString("TENCTNB");
        strTV = b.getString("VITRICTNB");
        strCHISO = b.getString("CHISOCTMNB");
        strQT = b.getString("QUOCTICHCTNB");
        strGia = b.getString("GIACTNB");

        detailName.setText(strName);
        detailVt.setText(strTV);
        detailQt.setText(strQT);
        detailCstl.setText(strCHISO);
        detailGia.setText(strGia);



    }
}
