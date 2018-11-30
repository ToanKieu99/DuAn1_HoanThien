package com.toankieu.toanvu.duan1_hoanthien.edit;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.database.CauThuDao;

public class EditCauThu extends AppCompatActivity {
    private ImageView showUPDATECauThu;
    private TextInputEditText editUPDATEMaCT;
    private TextInputEditText editUPDATETenCT;
    private TextInputEditText editUPDATEChisoCT;
    private TextInputEditText editUPDATEVTCT;
    private TextInputEditText editUPDATEQTCT;
    private TextInputEditText editUPDATEGiaCT;
    private TextInputEditText editUPDATEGhiChuCT;
    private Button btUPDATEThemCT;
    private Button btUPDATEHuyCT;
    CauThuDao cauThuDao;
    String strMact, strName, strChiSo, strVT, strQT, strGia, strGhiChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_cau_thu);
        showUPDATECauThu = (ImageView) findViewById(R.id.show_UPDATE_cau_thu);
        editUPDATEMaCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_maCT);
        editUPDATETenCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_TenCT);
        editUPDATEChisoCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_ChisoCT);
        editUPDATEVTCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_VTCT);
        editUPDATEQTCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_QTCT);
        editUPDATEGiaCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_GiaCT);
        editUPDATEGhiChuCT = (TextInputEditText) findViewById(R.id.edit_UPDATE_GhiChuCT);
        btUPDATEThemCT = (Button) findViewById(R.id.bt_UPDATE_ThemCT);
        btUPDATEHuyCT = (Button) findViewById(R.id.bt_UPDATE_HuyCT);

        showUPDATECauThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        cauThuDao = new CauThuDao(this);
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        strMact = b1.getString("ADMACT");
        strName = b1.getString("ADTENCT");
        strChiSo = b1.getString("ADCHISOCT");
        strVT = b1.getString("ADVITRICT");
        strQT = b1.getString("ADQUOCTICH");
        strGia = b1.getString("ADGIACT");
        strGhiChu = b1.getString("ADGHICHU");
        editUPDATEMaCT.setText(strMact);
        editUPDATETenCT.setText(strName);
        editUPDATEChisoCT.setText(strChiSo);
        editUPDATEVTCT.setText(strVT);
        editUPDATEQTCT.setText(strQT);
        editUPDATEGiaCT.setText(strGia);
        editUPDATEGhiChuCT.setText(strGhiChu);

        btUPDATEThemCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cauThuDao.updateCauThu(strMact,
                        editUPDATETenCT.getText().toString(),
                        editUPDATEChisoCT.getText().toString(),
                        editUPDATEVTCT.getText().toString(),
                        editUPDATEQTCT.getText().toString(),
                        String.valueOf(editUPDATEGiaCT.getText().toString()),
                        editUPDATEGhiChuCT.getText().toString()) > 0) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditCauThu.this, "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btUPDATEHuyCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
