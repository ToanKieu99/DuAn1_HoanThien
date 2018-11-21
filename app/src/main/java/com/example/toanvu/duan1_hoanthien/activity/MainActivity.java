package com.example.toanvu.duan1_hoanthien.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.toanvu.duan1_hoanthien.R;

import com.example.toanvu.duan1_hoanthien.fragment.BanQuanLyFragment;
import com.example.toanvu.duan1_hoanthien.fragment.CauThuFragment;
import com.example.toanvu.duan1_hoanthien.fragment.CauThuNoiBatFragment;
import com.example.toanvu.duan1_hoanthien.fragment.IntroFragment;
import com.example.toanvu.duan1_hoanthien.quanlytab.DoiHinhFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.draweLayout);
        toolbar = findViewById(R.id.toolbar);
        Actionbar();
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        QuanLyFragment(new CauThuNoiBatFragment());
    }

    private void Actionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.danhCTNB:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new CauThuNoiBatFragment()).commit();
                Toast.makeText(this, "Danh sách ban quản lý ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.danhSBQL:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new BanQuanLyFragment()).commit();
                Toast.makeText(this, "Danh sách ban quản lý ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.danhsachCT:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new CauThuFragment()).commit();
                Toast.makeText(this, "Danh sách cầu thủ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.doihinh:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new DoiHinhFragment()).commit();
                Toast.makeText(this, "Danh sách cầu thủ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.gioiThieu:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new IntroFragment()).commit();
                Toast.makeText(this, "Giới thiệu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.share:
                Toast.makeText(this, "Danh sách cầu thủ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.dangxuat:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Bạn có chắc chắn muốn thoát không?");
                builder.setIcon(R.drawable.iconthoat);
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.show();

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
    public void QuanLyFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentLayout, fragment);
            fragmentTransaction.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
