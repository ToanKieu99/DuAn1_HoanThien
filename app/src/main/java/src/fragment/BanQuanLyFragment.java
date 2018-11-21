package src.fragment;

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
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.toanvu.duan1_hoanthien.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import src.adapter.AdapterBanQL;
import src.adapter.AdapterCauThuNoiBat;
import src.add.ThemBanQuanLy;
import src.database.CauThuNoiBatDao;
import src.database.DanhSachBanQuanLyDao;
import src.model.CauThuNoiBatModel;
import src.model.QuanLyModel;


public class BanQuanLyFragment extends Fragment {
    private FloatingActionButton fab;

    public List<QuanLyModel> dsql;
    RecyclerView recyclerQL;
    AdapterBanQL adapter;
    DanhSachBanQuanLyDao danhSachBanQuanLyDao;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ban_quan_ly_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.fabBanQuanLy);


        recyclerQL = view.findViewById(R.id.reyclBanQuanLy);
        dsql = new ArrayList<>();
        danhSachBanQuanLyDao = new DanhSachBanQuanLyDao(getContext());
        try {
            dsql = danhSachBanQuanLyDao.getALLQuanLy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter = new AdapterBanQL(getContext(),dsql);
        recyclerQL.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerQL.setLayoutManager(manager);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ql = new Intent(getContext(), ThemBanQuanLy.class);
                startActivity(ql);
            }
        });
    }
    public void onResume() {
        super.onResume();
        dsql.clear();
        dsql = danhSachBanQuanLyDao.getALLQuanLy();
        adapter.changeDataset(dsql);
    }


}
