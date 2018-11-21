package com.toankieu.toanvu.duan1_hoanthien.add;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.toankieu.toanvu.duan1_hoanthien.R;

public class ThemDoiHinhPhu extends AppCompatActivity {

    ImageView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_doi_hinh_phu);


        show = findViewById(R.id.show_doi_hinh_phu);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
