package src.add;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.toanvu.duan1_hoanthien.R;

import src.database.DanhSachBanQuanLyDao;
import src.model.QuanLyModel;

public class ThemBanQuanLy extends AppCompatActivity {

    private ImageView showBanQuanLy;
    private TextInputEditText editMaQL;
    private TextInputEditText editTenQL;
    private TextInputEditText editChuVuQL;
    private TextInputEditText editQTQL;
    private TextInputEditText editLuongQL;
    private TextInputEditText editghichuQL;
    private Button btThemQL;
    private Button btHuyQL;

    DanhSachBanQuanLyDao danhSachBanQuanLyDaol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_ban_quan_ly);

        showBanQuanLy = (ImageView) findViewById(R.id.show_ban_quan_ly);
        editMaQL = (TextInputEditText) findViewById(R.id.editMaQL);
        editTenQL = (TextInputEditText) findViewById(R.id.editTenQL);
        editChuVuQL = (TextInputEditText) findViewById(R.id.editChuVuQL);
        editQTQL = (TextInputEditText) findViewById(R.id.editQTQL);
        editLuongQL = (TextInputEditText) findViewById(R.id.editLuongQL);
        editghichuQL = (TextInputEditText) findViewById(R.id.editghichuQL);
        btThemQL = findViewById(R.id.btThem_QL);
        btHuyQL = (Button) findViewById(R.id.btHuy_QL);

        showBanQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btThemQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                danhSachBanQuanLyDaol = new DanhSachBanQuanLyDao(ThemBanQuanLy.this);


                try{
                    QuanLyModel ql = new QuanLyModel(editMaQL.getText().toString(),
                        editTenQL.getText().toString(),
                        editChuVuQL.getText().toString(),
                        editQTQL.getText().toString(),
                        Double.parseDouble(editLuongQL.getText().toString()),
                        editghichuQL.getText().toString());
                    if(validateform() > 0){
                        if (danhSachBanQuanLyDaol.insertDanhSachBanQL(ql) > 0){
                            Toast.makeText(ThemBanQuanLy.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ThemBanQuanLy.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){

                }
            }
        });
    }

    private int validateform() {
        int check = 1;
        String ma = editMaQL.getText().toString();
        String ten = editTenQL.getText().toString();
        String cv = editChuVuQL.getText().toString();
        String qt = editQTQL.getText().toString();
        String l = editLuongQL.getText().toString();
        String gc = editghichuQL.getText().toString();
        if (ma.isEmpty() || ten.isEmpty() || cv.isEmpty() || qt.isEmpty() || l.isEmpty() || gc.isEmpty()){
            Toast.makeText(this, "Bạn phải nhập đầy đủ để thêm", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

}
