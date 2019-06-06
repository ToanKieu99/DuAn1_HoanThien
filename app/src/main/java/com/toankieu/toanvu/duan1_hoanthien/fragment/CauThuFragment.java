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
import android.widget.AdapterView;
import android.widget.ListView;

import com.toankieu.toanvu.duan1_hoanthien.details.DetailsCauThu;
import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.adapter.CauThuAdapter;
import com.toankieu.toanvu.duan1_hoanthien.add.ThemCauThu;
import com.toankieu.toanvu.duan1_hoanthien.database.CauThuDao;
import com.toankieu.toanvu.duan1_hoanthien.model.CauThuModel;

import java.util.List;

public class CauThuFragment extends Fragment {
    private FloatingActionButton fab;

    public List<CauThuModel> dsCT;
    ListView lvCT;
    CauThuAdapter adapter;
    CauThuDao cauThuDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cau_thu_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.fab_cau_thu);
        lvCT = view.findViewById(R.id.lvCT);
        registerForContextMenu(lvCT);
        cauThuDao = new CauThuDao(getActivity());
        dsCT = cauThuDao.getAllCauThu();
        adapter = new CauThuAdapter(getContext(), dsCT);
        lvCT.setAdapter(adapter);


        lvCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsCauThu.class);
                Bundle bundle = new Bundle();
                bundle.putString("MACT", dsCT.get(position).getMaCT());
                bundle.putString("TENCT", dsCT.get(position).getTenCT());
                bundle.putString("CHISOCT", dsCT.get(position).getChisoCT());
                bundle.putString("VITRICT", dsCT.get(position).getVitriCT());
                bundle.putString("QUOCTICH", dsCT.get(position).getQuoctichCT());
                bundle.putString("GIACT", String.valueOf(dsCT.get(position).getGiaCT()));
                bundle.putString("GHICHU", dsCT.get(position).getGhichuCT());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent them = new Intent(getContext(), ThemCauThu.class);
                startActivity(them);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        dsCT.clear();
        dsCT = cauThuDao.getAllCauThu();
        adapter.changeDataset(dsCT);
    }
}
