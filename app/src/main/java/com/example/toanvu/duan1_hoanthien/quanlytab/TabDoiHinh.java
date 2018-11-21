package com.example.toanvu.duan1_hoanthien.quanlytab;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.toanvu.duan1_hoanthien.fragment.DoiHinhChinhFragment;
import com.example.toanvu.duan1_hoanthien.fragment.DoiHinhPhuFragment;


public class TabDoiHinh extends FragmentStatePagerAdapter {
    private DoiHinhPhuFragment doiHinhPhuFragment;
    private DoiHinhChinhFragment doiHinhChinhFragment;


    public TabDoiHinh(FragmentManager fm) {
        super(fm);
        doiHinhChinhFragment = new DoiHinhChinhFragment();
        doiHinhPhuFragment = new DoiHinhPhuFragment();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return doiHinhChinhFragment;
        } else if (position == 1) {
            return doiHinhPhuFragment;
        } else {
            //TODO nothing
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Đội hình chính";
            case 1:
                return "Đội hình phụ";
            default:
                return null;
        }

    }
}
