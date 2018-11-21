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

import src.database.DanhSachBanQuanLyDao;

public class EditBanQuanLy extends AppCompatActivity {
    private ImageView showUpdateBanQuanLy;
    private TextInputEditText editUPDATEMaQL;
    private TextInputEditText editUPDATETenQL;
    private TextInputEditText editUPDATEChuVuQL;
    private TextInputEditText editUPDATEQTQL;
    private TextInputEditText editUPDATELuongQL;
    private TextInputEditText editUPDATEGhichuQL;
    private Button btUPDATEThemQL;
    private Button btUPDATEHuyQL;
    String strMa,strName,strCV,strQT,strLuong,strGhiChu;

    DanhSachBanQuanLyDao danhSachBanQuanLyDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ban_quan_ly);

        showUpdateBanQuanLy = (ImageView) findViewById(R.id.show_Update_ban_quan_ly);

        editUPDATEMaQL = (TextInputEditText) findViewById(R.id.edit_UPDATE_MaQL);
        editUPDATETenQL = (TextInputEditText) findViewById(R.id.edit_UPDATE_TenQL);
        editUPDATEChuVuQL = (TextInputEditText) findViewById(R.id.edit_UPDATE_ChuVuQL);
        editUPDATEQTQL = (TextInputEditText) findViewById(R.id.edit_UPDATE_QTQL);
        editUPDATELuongQL = (TextInputEditText) findViewById(R.id.edit_UPDATE_LuongQL);
        editUPDATEGhichuQL = (TextInputEditText) findViewById(R.id.edit_UPDATE_ghichuQL);

        btUPDATEThemQL = (Button) findViewById(R.id.bt_UPDATE_Them_QL);
        btUPDATEHuyQL = (Button) findViewById(R.id.bt_UPDATE_Huy_QL);
        danhSachBanQuanLyDao = new DanhSachBanQuanLyDao(this);
        showUpdateBanQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        strMa = b1.getString("ADMABQL");
        strName = b1.getString("ADTENBQL");
        strCV = b1.getString("ADCHUVUBQL");
        strQT = b1.getString("ADQUOCTICHBQL");
        strLuong = b1.getString("ADLUONGBQL");
        strGhiChu = b1.getString("ADGHICHUBQL");

        editUPDATEMaQL.setText(strMa);
        editUPDATETenQL.setText(strName);
        editUPDATEChuVuQL.setText(strCV);
        editUPDATEQTQL.setText(strQT);
        editUPDATELuongQL.setText(strLuong);
        editUPDATEGhichuQL.setText(strGhiChu);

        btUPDATEThemQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (danhSachBanQuanLyDao.updateInforBanQuanLy(strMa,
                        editUPDATETenQL.getText().toString(),
                        editUPDATEChuVuQL.getText().toString(),
                        editUPDATEQTQL.getText().toString(),
                        String.valueOf(Double.parseDouble(editUPDATELuongQL.getText().toString())),
                        editUPDATEGhichuQL.getText().toString()) > 0) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EditBanQuanLy.this, "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
