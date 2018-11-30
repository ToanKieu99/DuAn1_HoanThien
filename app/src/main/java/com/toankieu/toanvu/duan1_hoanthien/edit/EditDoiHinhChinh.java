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

public class EditDoiHinhChinh extends AppCompatActivity {
    private ImageView showDoiUPDATEHinhChinh;
    private TextInputEditText editMaUPDATEDHC;
    private TextInputEditText editTenUPDATEDHC;
    private TextInputEditText editVTUPDATEDHC;
    private TextInputEditText editCSUPDATEDHC;
    private TextInputEditText editQTUPDATEDHC;
    private TextInputEditText editGiaUPDATEDHC;
    private Button btThemUPDATEDHC;
    private Button btHuyUPDATEDHC;
    DoiHinhChinhDao doiHinhChinhDao;
    String strMa, strTen, strVT, strCS, strQT, strG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_doi_hinh_chinh);

        showDoiUPDATEHinhChinh = (ImageView) findViewById(R.id.show_doi_UPDATE_Hinh_chinh);
        editMaUPDATEDHC = (TextInputEditText) findViewById(R.id.editMa_UPDATE_DHC);
        editTenUPDATEDHC = (TextInputEditText) findViewById(R.id.editTen_UPDATE_DHC);
        editVTUPDATEDHC = (TextInputEditText) findViewById(R.id.editVT_UPDATE_DHC);
        editCSUPDATEDHC = (TextInputEditText) findViewById(R.id.editCS_UPDATE_DHC);
        editQTUPDATEDHC = (TextInputEditText) findViewById(R.id.editQT_UPDATE_DHC);
        editGiaUPDATEDHC = (TextInputEditText) findViewById(R.id.editGia_UPDATE_DHC);
        btThemUPDATEDHC = (Button) findViewById(R.id.btThem_UPDATE_DHC);
        btHuyUPDATEDHC = (Button) findViewById(R.id.btHuy_UPDATE_DHC);

        showDoiUPDATEHinhChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        doiHinhChinhDao = new DoiHinhChinhDao(this);
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        strMa = b1.getString("ADMADHC");
        strTen = b1.getString("ADTENDHC");
        strVT = b1.getString("ADVITRIDHC");
        strCS = b1.getString("ADCHISODHC");
        strQT = b1.getString("ADQUOCTICHDHC");
        strG = b1.getString("ADGIADHC");

        editMaUPDATEDHC.setText(strMa);
        editTenUPDATEDHC.setText(strTen);
        editVTUPDATEDHC.setText(strVT);
        editCSUPDATEDHC.setText(strCS);
        editQTUPDATEDHC.setText(strQT);
        editGiaUPDATEDHC.setText(strG);


        btThemUPDATEDHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doiHinhChinhDao.updateDoiHinhChinh(strMa,
                        editTenUPDATEDHC.getText().toString(),
                        editVTUPDATEDHC.getText().toString(),
                        editCSUPDATEDHC.getText().toString(),
                        editQTUPDATEDHC.getText().toString(),
                        Double.parseDouble(editGiaUPDATEDHC.getText().toString())) > 0) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditDoiHinhChinh.this, "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btHuyUPDATEDHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
