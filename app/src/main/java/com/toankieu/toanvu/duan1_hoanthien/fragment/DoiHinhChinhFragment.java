package com.toankieu.toanvu.duan1_hoanthien.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toankieu.toanvu.duan1_hoanthien.R;

import com.toankieu.toanvu.duan1_hoanthien.adapter.AdapterBanQL;
import com.toankieu.toanvu.duan1_hoanthien.adapter.DoiHinhChinhAdapter;
import com.toankieu.toanvu.duan1_hoanthien.add.ThemDoiHinhChinh;
import com.toankieu.toanvu.duan1_hoanthien.database.DanhSachBanQuanLyDao;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhChinhDao;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;
import com.toankieu.toanvu.duan1_hoanthien.model.QuanLyModel;

import java.util.ArrayList;
import java.util.List;

public class DoiHinhChinhFragment extends Fragment {
    private FloatingActionButton fab;

    public List<DoiHinhChinhModel> dsdhc;
    RecyclerView recyclerQL;
    DoiHinhChinhAdapter adapter;
    DoiHinhChinhDao doiHinhChinhDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doi_hinh_chinh_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.fab_doi_hinh_chinh);

        recyclerQL = view.findViewById(R.id.reyclDoiHinhChinh);
        dsdhc = new ArrayList<>();
        doiHinhChinhDao = new DoiHinhChinhDao(getContext());
        try {
            dsdhc = doiHinhChinhDao.getAllDoiHinhChinh();
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter = new DoiHinhChinhAdapter(getContext(), dsdhc);
        recyclerQL.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerQL.setLayoutManager(manager);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent them = new Intent(getContext(), ThemDoiHinhChinh.class);
                startActivity(them);

            }
        });
    }

    public void onResume() {
        super.onResume();
        dsdhc.clear();
        dsdhc = doiHinhChinhDao.getAllDoiHinhChinh();
        adapter.changeDataset(dsdhc);
    }
}
