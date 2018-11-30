package com.toankieu.toanvu.duan1_hoanthien.add;

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
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhPhuModel;

public class ThemDoiHinhPhu extends AppCompatActivity {
    ImageView show;
    private TextInputEditText editMaDHP;
    private TextInputEditText editTenDHP;
    private TextInputEditText editVitriDHP;
    private TextInputEditText editCSDHP;
    private TextInputEditText editQTDHP;
    private TextInputEditText editGCTDHP;
    private Button btThemDHP;
    private Button btHUYDHP;
    DoiHinhPhuDao doiHinhPhuDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_doi_hinh_phu);


        show = findViewById(R.id.show_doi_hinh_phu);
        editMaDHP = (TextInputEditText) findViewById(R.id.editMaDHP);
        editTenDHP = (TextInputEditText) findViewById(R.id.editTenDHP);
        editVitriDHP = (TextInputEditText) findViewById(R.id.editVitriDHP);
        editCSDHP = (TextInputEditText) findViewById(R.id.editCSDHP);
        editQTDHP = (TextInputEditText) findViewById(R.id.editQTDHP);
        editGCTDHP = (TextInputEditText) findViewById(R.id.editGCTDHP);
        btThemDHP = (Button) findViewById(R.id.btThemDHP);
        btHUYDHP = (Button) findViewById(R.id.btHUYDHP);
        doiHinhPhuDao = new DoiHinhPhuDao(this);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btThemDHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiHinhPhuDao = new DoiHinhPhuDao(getApplicationContext());

                try {
                    DoiHinhPhuModel dh = new DoiHinhPhuModel(editMaDHP.getText().toString(),
                            editTenDHP.getText().toString(),
                            editVitriDHP.getText().toString(),
                            editCSDHP.getText().toString(),
                            editQTDHP.getText().toString(),
                            Double.parseDouble(editGCTDHP.getText().toString()));

                    if (validateform() > 0) {
                        if (doiHinhPhuDao.insertDoiHinhPhu(dh) > 0) {
                            Toast.makeText(ThemDoiHinhPhu.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ThemDoiHinhPhu.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {

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

    private int validateform() {
        int check = 1;
        String ma = editMaDHP.getText().toString();
        String ten = editTenDHP.getText().toString();
        String vt = editVitriDHP.getText().toString();
        String qt = editCSDHP.getText().toString();
        String cs = editQTDHP.getText().toString();
        if (ma.isEmpty() || ten.isEmpty() || vt.isEmpty() || qt.isEmpty() || cs.isEmpty()) {
            Toast.makeText(this, "Bạn phải nhập đầy đủ để thêm", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
