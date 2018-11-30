package com.toankieu.toanvu.duan1_hoanthien.add;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.database.CauThuDao;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhChinhDao;
import com.toankieu.toanvu.duan1_hoanthien.model.CauThuModel;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhPhuModel;

public class ThemDoiHinhChinh extends AppCompatActivity {
    ImageView show;
    private ImageView showDoiHinhChinh;
    private TextInputEditText editMaDHC;
    private TextInputEditText editTenDHC;
    private TextInputEditText editVTDHC;
    private TextInputEditText editCSDHC;
    private TextInputEditText editQTDHC;
    private TextInputEditText editGiaDHC;
    private Button btThemDHC;
    private Button btHuyDHC;
    DoiHinhChinhDao doiHinhChinhDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_doi_hinh_chinh);

        show = findViewById(R.id.show_doi_Hinh_chinh);
        showDoiHinhChinh = (ImageView) findViewById(R.id.show_doi_Hinh_chinh);
        editMaDHC = (TextInputEditText) findViewById(R.id.editMaDHC);
        editTenDHC = (TextInputEditText) findViewById(R.id.editTenDHC);
        editVTDHC = (TextInputEditText) findViewById(R.id.editVTDHC);
        editCSDHC = (TextInputEditText) findViewById(R.id.editCSDHC);
        editQTDHC = (TextInputEditText) findViewById(R.id.editQTDHC);
        editGiaDHC = (TextInputEditText) findViewById(R.id.editGiaDHC);
        btThemDHC = (Button) findViewById(R.id.btThemDHC);
        btHuyDHC = (Button) findViewById(R.id.btHuyDHC);
        doiHinhChinhDao = new DoiHinhChinhDao(this);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btThemDHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiHinhChinhDao = new DoiHinhChinhDao(getApplicationContext());

                try {
                    DoiHinhChinhModel dh = new DoiHinhChinhModel(editMaDHC.getText().toString(),
                            editTenDHC.getText().toString(),
                            editVTDHC.getText().toString(),
                            editCSDHC.getText().toString(),
                            editQTDHC.getText().toString(),
                            Double.parseDouble(editGiaDHC.getText().toString()));

                    if (validateform() > 0) {
                        if (doiHinhChinhDao.insertDoiHinhChinh(dh) > 0) {
                            Toast.makeText(ThemDoiHinhChinh.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ThemDoiHinhChinh.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
        btHuyDHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int validateform() {
        int check = 1;
        String ma = editMaDHC.getText().toString();
        String ten = editTenDHC.getText().toString();
        String vt = editCSDHC.getText().toString();
        String qt = editQTDHC.getText().toString();
        String cs = editGiaDHC.getText().toString();
        if (ma.isEmpty() || ten.isEmpty() || vt.isEmpty() || qt.isEmpty() || cs.isEmpty()) {
            Toast.makeText(this, "Bạn phải nhập đầy đủ để thêm", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
