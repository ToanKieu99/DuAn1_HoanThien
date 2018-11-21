package com.toankieu.toanvu.duan1_hoanthien.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toankieu.toanvu.duan1_hoanthien.R;

import com.toankieu.toanvu.duan1_hoanthien.add.ThemDoiHinhChinh;

public class DoiHinhChinhFragment extends Fragment {
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doi_hinh_chinh_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.fab_doi_hinh_chinh);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent them  = new Intent(getContext(),ThemDoiHinhChinh.class);
                startActivity(them);

            }
        });
    }
}
