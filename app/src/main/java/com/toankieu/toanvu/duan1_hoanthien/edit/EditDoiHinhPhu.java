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
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhChinhDao;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhPhuDao;

public class EditDoiHinhPhu extends AppCompatActivity {
    private ImageView showUPDATEDoiHinhPhu;
    private TextInputEditText editUPDATEMaDHP;
    private TextInputEditText editUPDATETenDHP;
    private TextInputEditText editUPDATEVitriDHP;
    private TextInputEditText editUPDATECSDHP;
    private TextInputEditText editQTDHP;
    private TextInputEditText editUPDATEGCTDHP;
    private Button btUPDATEThemDHP;
    private Button btHUYDHP;
    String strMa, strTen, strVT, strCS, strQT, strG;
    DoiHinhPhuDao doiHinhPhuDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_doi_hinh_phu);

        showUPDATEDoiHinhPhu = (ImageView) findViewById(R.id.show_UPDATE_doi_hinh_phu);
        editUPDATEMaDHP = (TextInputEditText) findViewById(R.id.edit_UPDATE_MaDHP);
        editUPDATETenDHP = (TextInputEditText) findViewById(R.id.edit_UPDATE_TenDHP);
        editUPDATEVitriDHP = (TextInputEditText) findViewById(R.id.edit_UPDATE_VitriDHP);
        editUPDATECSDHP = (TextInputEditText) findViewById(R.id.edit_UPDATE_CSDHP);
        editQTDHP = (TextInputEditText) findViewById(R.id.editQTDHP);
        editUPDATEGCTDHP = (TextInputEditText) findViewById(R.id.edit_UPDATE_GCTDHP);
        btUPDATEThemDHP = (Button) findViewById(R.id.bt_UPDATE_ThemDHP);
        btHUYDHP = (Button) findViewById(R.id.btHUYDHP);

        showUPDATEDoiHinhPhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        doiHinhPhuDao = new DoiHinhPhuDao(this);
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        strMa = b1.getString("ADMADHP");
        strTen = b1.getString("ADTENDHP");
        strVT = b1.getString("ADVITRIDHP");
        strCS = b1.getString("ADCHISODHP");
        strQT = b1.getString("ADQUOCTICHDHP");
        strG = b1.getString("ADGIADHP");

        editUPDATEMaDHP.setText(strMa);
        editUPDATETenDHP.setText(strTen);
        editUPDATEVitriDHP.setText(strVT);
        editUPDATECSDHP.setText(strCS);
        editQTDHP.setText(strQT);
        editUPDATEGCTDHP.setText(strG);

        btUPDATEThemDHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doiHinhPhuDao.updateDoiHinhPhu(strMa,
                        editUPDATETenDHP.getText().toString(),
                        editUPDATEVitriDHP.getText().toString(),
                        editUPDATECSDHP.getText().toString(),
                        editQTDHP.getText().toString(),
                        Double.parseDouble(editUPDATEGCTDHP.getText().toString())) > 0) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditDoiHinhPhu.this, "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btHUYDHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
