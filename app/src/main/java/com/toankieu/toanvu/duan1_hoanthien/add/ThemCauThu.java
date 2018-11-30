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
import com.toankieu.toanvu.duan1_hoanthien.model.CauThuModel;

public class ThemCauThu extends AppCompatActivity {
    private TextInputEditText editMaCT;
    private TextInputEditText editTenCT;
    private TextInputEditText editChisoCT;
    private TextInputEditText editQTCT, editVTCT;
    private TextInputEditText editGiaCT;
    private TextInputEditText editGhiChuCT;
    private Button btThemCT;
    private Button btHuyCT;
    ImageView show;
    CauThuDao cauThuDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_cau_thu);

        show = findViewById(R.id.show_cau_thu);
        editMaCT = (TextInputEditText) findViewById(R.id.edit_maCT);
        editTenCT = (TextInputEditText) findViewById(R.id.editTenCT);
        editChisoCT = (TextInputEditText) findViewById(R.id.editChisoCT);
        editQTCT = (TextInputEditText) findViewById(R.id.editQTCT);
        editGiaCT = (TextInputEditText) findViewById(R.id.editGiaCT);
        editGhiChuCT = findViewById(R.id.editGhiChuCT);
        editVTCT = findViewById(R.id.editVTCT);
        btThemCT = (Button) findViewById(R.id.btThemCT);
        btHuyCT = (Button) findViewById(R.id.btHuyCT);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btThemCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauThuDao = new CauThuDao(getApplicationContext());
                CauThuModel ct = new CauThuModel(editMaCT.getText().toString(),
                        editTenCT.getText().toString(),
                        editChisoCT.getText().toString(),
                        editVTCT.getText().toString(),
                        editQTCT.getText().toString(),
                        Double.parseDouble(editGiaCT.getText().toString()),
                        editGhiChuCT.getText().toString());
                try {

                    if (validateform() > 0) {
                        if (cauThuDao.insertCauThu(ct) > 0) {
                            Toast.makeText(ThemCauThu.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ThemCauThu.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
        btHuyCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private int validateform() {
        int check = 1;
        String ma = editMaCT.getText().toString();
        String ten = editTenCT.getText().toString();
        String vt = editChisoCT.getText().toString();
        String qt = editQTCT.getText().toString();
        String cs = editGiaCT.getText().toString();
        String gia = editGhiChuCT.getText().toString();
        if (ma.isEmpty() || ten.isEmpty() || vt.isEmpty() || qt.isEmpty() || cs.isEmpty() || gia.isEmpty()) {
            Toast.makeText(this, "Bạn phải nhập đầy đủ để thêm", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
