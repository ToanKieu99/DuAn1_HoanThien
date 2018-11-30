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
import com.toankieu.toanvu.duan1_hoanthien.adapter.DoiHinhChinhAdapter;
import com.toankieu.toanvu.duan1_hoanthien.adapter.DoiHinhPhuAdapter;
import com.toankieu.toanvu.duan1_hoanthien.add.ThemDoiHinhPhu;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhChinhDao;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhPhuDao;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhPhuModel;

import java.util.ArrayList;
import java.util.List;

public class DoiHinhPhuFragment extends Fragment {
    private FloatingActionButton fab;

    public List<DoiHinhPhuModel> dsdhc;
    RecyclerView recyclerQL;
    DoiHinhPhuAdapter adapter;
    DoiHinhPhuDao doiHinhPhuDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doi_hinh_phu_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.fab_doi_hinh_phu);
        recyclerQL = view.findViewById(R.id.recylViewDHP);
        dsdhc = new ArrayList<>();
        doiHinhPhuDao = new DoiHinhPhuDao(getContext());
        try {
            dsdhc = doiHinhPhuDao.getAllDoiHinhPhu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter = new DoiHinhPhuAdapter(getContext(), dsdhc);
        recyclerQL.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerQL.setLayoutManager(manager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent them = new Intent(getContext(), ThemDoiHinhPhu.class);
                startActivity(them);
            }
        });
    }

    public void onResume() {
        super.onResume();
        dsdhc.clear();
        dsdhc = doiHinhPhuDao.getAllDoiHinhPhu();
        adapter.changeDataset(dsdhc);
    }
}
