package com.example.toanvu.duan1_hoanthien.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.toanvu.duan1_hoanthien.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.example.toanvu.duan1_hoanthien.adapter.AdapterCauThuNoiBat;
import com.example.toanvu.duan1_hoanthien.add.ThemCauThuNoiBat;
import com.example.toanvu.duan1_hoanthien.database.CauThuNoiBatDao;
import com.example.toanvu.duan1_hoanthien.details.DetailCauThuNoiBat;
import com.example.toanvu.duan1_hoanthien.model.CauThuNoiBatModel;

public class CauThuNoiBatFragment extends Fragment {
    private ViewFlipper viewFlipper;
    FloatingActionButton fab;


    public static List<CauThuNoiBatModel> dsCTNB = new ArrayList<>();
    ListView lvCTNB;
    AdapterCauThuNoiBat adapter = null;
    CauThuNoiBatDao cauThuNoiBatDao;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cau_thu_noi_bat_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewFlipper = view.findViewById(R.id.viewFlipper_Home);
        fab = view.findViewById(R.id.fab_danhSach);
        ActionViewFlipper();

        lvCTNB = view.findViewById(R.id.lvDanhsachCTNB);
        registerForContextMenu(lvCTNB);
        cauThuNoiBatDao = new CauThuNoiBatDao(getActivity());
        dsCTNB = cauThuNoiBatDao.getALLCauThuNB();
        adapter = new AdapterCauThuNoiBat(getContext(), dsCTNB);
        lvCTNB.setAdapter(adapter);

        lvCTNB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailCauThuNoiBat.class);
                Bundle bundle = new Bundle();
                bundle.putString("MACTNB", dsCTNB.get(position).getMactNB());
                bundle.putString("TENCTNB", dsCTNB.get(position).getTenCTNB());
                bundle.putString("VITRICTNB", dsCTNB.get(position).getVitriCTNB());
                bundle.putString("QUOCTICHCTNB", dsCTNB.get(position).getQuoctichCTNB());
                bundle.putString("CHISOCTMNB",dsCTNB.get(position).getChisoCTNB());
                bundle.putString("GIACTNB",dsCTNB.get(position).getGiaCTNB());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent themDS = new Intent(getContext(), ThemCauThuNoiBat.class);
                startActivity(themDS);
            }
        });
    }

    private void ActionViewFlipper() {
        ArrayList<Integer> mangquangcaoCT = new ArrayList<>();
        mangquangcaoCT.add(R.drawable.gioithieu);
        mangquangcaoCT.add(R.drawable.cauthu10);
        mangquangcaoCT.add(R.drawable.cauthu11);
        mangquangcaoCT.add(R.drawable.cauthu1);
        mangquangcaoCT.add(R.drawable.cauthu2);
        mangquangcaoCT.add(R.drawable.cauthu4);


        for (int i = 0; i < mangquangcaoCT.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext()).load(mangquangcaoCT.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        Animation animation_silde_in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_silde_in);
        viewFlipper.setOutAnimation(animation_slide_out);


    }

    @Override
    public void onResume() {
        super.onResume();
        dsCTNB.clear();
        dsCTNB = cauThuNoiBatDao.getALLCauThuNB();
        adapter.changeDataset(dsCTNB);
    }

}
