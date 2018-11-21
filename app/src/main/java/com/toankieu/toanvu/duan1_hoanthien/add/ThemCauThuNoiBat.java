package com.toankieu.toanvu.duan1_hoanthien.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.toankieu.toanvu.duan1_hoanthien.R;

import com.toankieu.toanvu.duan1_hoanthien.database.CauThuNoiBatDao;
import com.toankieu.toanvu.duan1_hoanthien.model.CauThuNoiBatModel;


public class ThemCauThuNoiBat extends AppCompatActivity {
    EditText editmaCT,editTenCT,editVT,editQT,editGiact,editChiso;
    ImageView show;
    Button btThem,btHuy;
    CauThuNoiBatDao cauThuNoiBatDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_cau_thu_noi_bat);

        editmaCT = findViewById(R.id.editMaCTNB);
        editTenCT = findViewById(R.id.editTenCTNB);
        editVT = findViewById(R.id.editVTCTNB);
        editQT = findViewById(R.id.editQTCTNB);
        editChiso = findViewById(R.id.editChiSCTNB);
        editGiact = findViewById(R.id.editGiaCTNB);
        btThem = findViewById(R.id.btThemCauThu_nb);
        btHuy = findViewById(R.id.btHuy_CTNB);

        show = findViewById(R.id.show_cau_thu_noi_bat);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauThuNoiBatDao = new CauThuNoiBatDao(ThemCauThuNoiBat.this);
                CauThuNoiBatModel ctnb = new CauThuNoiBatModel(editmaCT.getText().toString(),
                        editTenCT.getText().toString(),
                        editVT.getText().toString(),
                        editChiso.getText().toString(),
                        editQT.getText().toString(),
                        editGiact.getText().toString());
                try {
                    if(validateform() >0){
                        if (cauThuNoiBatDao.insertDanhSachCT(ctnb) >0){
                            Toast.makeText(ThemCauThuNoiBat.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ThemCauThuNoiBat.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    
                }catch (Exception e){
                    
                }
            }
        });
    }

    private int validateform() {
        int check = 1;
        String ma = editmaCT.getText().toString();
        String ten = editTenCT.getText().toString();
        String vt = editVT.getText().toString();
        String qt = editQT.getText().toString();
        String cs = editChiso.getText().toString();
        String gia = editGiact.getText().toString();
        if (ma.isEmpty() || ten.isEmpty() || vt.isEmpty() || qt.isEmpty() || cs.isEmpty() || gia.isEmpty()){
            Toast.makeText(this, "Bạn phải nhập đầy đủ để thêm", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

}
