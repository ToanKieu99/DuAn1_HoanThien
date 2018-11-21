package com.example.toanvu.duan1_hoanthien.quanlytab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.toanvu.duan1_hoanthien.R;

public class DoiHinhFragment extends Fragment {
    private TabLayout tab;
    private ViewPager viewPager;
    private TabDoiHinh tabDoiHinh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doi_hinh_fragment,container,false);

        tab = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager_doihinh);
        tabDoiHinh  = new TabDoiHinh(getChildFragmentManager());
        viewPager.setAdapter(tabDoiHinh);

        tab.post(new Runnable() {
            @Override
            public void run() {
                tab.setupWithViewPager(viewPager);
            }
        });
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
