package com.toankieu.toanvu.duan1_hoanthien.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhChinhDao;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhPhuDao;
import com.toankieu.toanvu.duan1_hoanthien.edit.EditDoiHinhPhu;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhPhuModel;

import java.util.List;

public class DoiHinhPhuAdapter extends RecyclerView.Adapter<DoiHinhPhuAdapter.ViewHolder> {
    private Context context;
    private List<DoiHinhPhuModel> doiHinhPhuModels;
    private DoiHinhPhuDao doiHinhPhuDao;

    public DoiHinhPhuAdapter(Context context, List<DoiHinhPhuModel> doiHinhPhuModels) {
        this.context = context;
        this.doiHinhPhuModels = doiHinhPhuModels;
        doiHinhPhuDao = new DoiHinhPhuDao(context);
    }

    @NonNull
    @Override
    public DoiHinhPhuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_doi__hinh_phu, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DoiHinhPhuAdapter.ViewHolder holder, final int position) {
        DoiHinhPhuModel ql = doiHinhPhuModels.get(position);
        holder.itemMactDHP.setText(doiHinhPhuModels.get(position).getMaCTDHP());
        holder.itemTenCauThuDHP.setText(doiHinhPhuModels.get(position).getTenCTDHP());
        holder.itemVtDHP.setText(doiHinhPhuModels.get(position).getVitriDHP());
        holder.itemCsCtDHP.setText(doiHinhPhuModels.get(position).getChiSoDHP());
        holder.itemDeleteCtDHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiHinhPhuDao.deleteDoiHinhPhu(doiHinhPhuModels.get(position).getMaCTDHP());
                doiHinhPhuModels.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.itemEditCtDHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, EditDoiHinhPhu.class);
                Bundle sBQL = new Bundle();
                sBQL.putString("ADMADHP", doiHinhPhuModels.get(position).getMaCTDHP());
                sBQL.putString("ADTENDHP", doiHinhPhuModels.get(position).getTenCTDHP());
                sBQL.putString("ADVITRIDHP", doiHinhPhuModels.get(position).getVitriDHP());
                sBQL.putString("ADCHISODHP", doiHinhPhuModels.get(position).getChiSoDHP());
                sBQL.putString("ADQUOCTICHDHP", doiHinhPhuModels.get(position).getQuoctichDHP());
                sBQL.putString("ADGIADHP", String.valueOf(doiHinhPhuModels.get(position).getGiaCTDHP()));
                intent1.putExtras(sBQL);
                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doiHinhPhuModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avtatarCT;
        private TextView itemMactDHP;
        private TextView itemTenCauThuDHP;
        private TextView itemVtDHP;
        private TextView itemCsCtDHP;
        private ImageView itemDeleteCtDHP;
        private ImageView itemEditCtDHP;


        public ViewHolder(View itemView) {
            super(itemView);
            avtatarCT = (ImageView) itemView.findViewById(R.id.avtatarCT);
            itemMactDHP = (TextView) itemView.findViewById(R.id.item_mact_DHP);
            itemTenCauThuDHP = (TextView) itemView.findViewById(R.id.item_ten_cau_thu_DHP);
            itemVtDHP = (TextView) itemView.findViewById(R.id.item_vt_DHP);
            itemCsCtDHP = (TextView) itemView.findViewById(R.id.item_cs_ctDHP);
            itemDeleteCtDHP = (ImageView) itemView.findViewById(R.id.item_delete_ct_DHP);
            itemEditCtDHP = (ImageView) itemView.findViewById(R.id.item_edit_ct_DHP);


        }
    }

    public void changeDataset(List<DoiHinhPhuModel> doiHinhChinhModels) {
        this.doiHinhPhuModels = doiHinhChinhModels;
        notifyDataSetChanged();
    }
}
