package com.toankieu.toanvu.duan1_hoanthien.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.toankieu.toanvu.duan1_hoanthien.R;



public class ManHinhChoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhcho_activity);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent login = new Intent(ManHinhChoActivity.this, LoginAcivity.class);
                    startActivity(login);
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
