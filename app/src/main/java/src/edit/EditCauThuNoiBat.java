package src.edit;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.toanvu.duan1_hoanthien.R;

import src.database.CauThuNoiBatDao;

public class EditCauThuNoiBat extends AppCompatActivity {
    private ImageView showUpdateCauThuNoiBat;
    private TextInputEditText editSuaMaCTNB;
    private TextInputEditText editSuaTenCTNB;
    private TextInputEditText editSuaVTCTNB;
    private TextInputEditText editSuaQTCTNB;
    private TextInputEditText editSuaChiSCTNB;
    private TextInputEditText editSuaGiaCTNB;
    private Button btUpdateNb;
    private Button btHuyUpdateCTNB;
    private String strMact,strName,strTV, strQT,strCHISO,strGia;
    CauThuNoiBatDao cauThuNoiBatDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_cau_thu_noi_bat);



        showUpdateCauThuNoiBat = (ImageView) findViewById(R.id.show_Update_cau_thu_noi_bat);
        editSuaMaCTNB = (TextInputEditText) findViewById(R.id.edit_sua_MaCTNB);
        editSuaTenCTNB = (TextInputEditText) findViewById(R.id.edit_sua_TenCTNB);
        editSuaVTCTNB = (TextInputEditText) findViewById(R.id.edit_sua_VTCTNB);
        editSuaQTCTNB = (TextInputEditText) findViewById(R.id.edit_sua_QTCTNB);
        editSuaChiSCTNB = (TextInputEditText) findViewById(R.id.edit_sua_ChiSCTNB);
        editSuaGiaCTNB = (TextInputEditText) findViewById(R.id.edit_sua_GiaCTNB);
        btUpdateNb = (Button) findViewById(R.id.btUpdate_nb);
        btHuyUpdateCTNB = (Button) findViewById(R.id.btHuyUpdate_CTNB);

        showUpdateCauThuNoiBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        cauThuNoiBatDao = new CauThuNoiBatDao(this);
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        strMact = b1.getString("ADMACTNB");
        strName = b1.getString("ADTENCTNB");
        strTV = b1.getString("ADVITRICTNB");
        strCHISO = b1.getString("ADCHISOCTMNB");
        strQT = b1.getString("ADQUOCTICHCTNB");
        strGia = b1.getString("ADGIACTNB");
        editSuaMaCTNB.setText(strMact);
        editSuaTenCTNB.setText(strName);
        editSuaVTCTNB.setText(strTV);
        editSuaQTCTNB.setText(strQT);
        editSuaChiSCTNB.setText(strCHISO);
        editSuaGiaCTNB.setText(strGia);

        btUpdateNb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cauThuNoiBatDao.updateinfoDanhSachCT(strMact,
                        editSuaTenCTNB.getText().toString(),
                        editSuaVTCTNB.getText().toString(),
                        editSuaChiSCTNB.getText().toString(),
                        Double.parseDouble(editSuaGiaCTNB.getText().toString())) > 0) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EditCauThuNoiBat.this, "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
