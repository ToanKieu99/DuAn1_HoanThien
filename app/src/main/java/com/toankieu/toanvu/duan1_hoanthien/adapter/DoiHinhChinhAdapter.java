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

import com.toankieu.toanvu.duan1_hoanthien.edit.EditDoiHinhChinh;
import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.database.DoiHinhChinhDao;
import com.toankieu.toanvu.duan1_hoanthien.model.DoiHinhChinhModel;

import java.util.List;

public class DoiHinhChinhAdapter extends RecyclerView.Adapter<DoiHinhChinhAdapter.ViewHolder> {
    private Context context;
    private List<DoiHinhChinhModel> doiHinhChinhModels;
    private DoiHinhChinhDao doiHinhChinhDao;

    public DoiHinhChinhAdapter(Context context, List<DoiHinhChinhModel> doiHinhChinhModels) {
        this.context = context;
        this.doiHinhChinhModels = doiHinhChinhModels;
        doiHinhChinhDao = new DoiHinhChinhDao(context);
    }

    @NonNull
    @Override
    public DoiHinhChinhAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_doi_hinh_chinh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoiHinhChinhAdapter.ViewHolder holder, final int position) {
        DoiHinhChinhModel ql = doiHinhChinhModels.get(position);
        holder.itemMactDHC.setText(doiHinhChinhModels.get(position).getMaCTDHC());
        holder.itemTenCauThuDHC.setText(doiHinhChinhModels.get(position).getTenCTDHC());
        holder.itemVtCt.setText(doiHinhChinhModels.get(position).getVitriDHC());
        holder.itemCsCtDHC.setText(doiHinhChinhModels.get(position).getChiSoDHC());
        holder.itemDeleteCtDHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiHinhChinhDao.deleteDoiHinhChinh(doiHinhChinhModels.get(position).getMaCTDHC());
                doiHinhChinhModels.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.itemDeleteCtDHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, EditDoiHinhChinh.class);
                Bundle sBQL = new Bundle();
                sBQL.putString("ADMADHC", doiHinhChinhModels.get(position).getMaCTDHC());
                sBQL.putString("ADTENDHC", doiHinhChinhModels.get(position).getTenCTDHC());
                sBQL.putString("ADVITRIDHC", doiHinhChinhModels.get(position).getVitriDHC());
                sBQL.putString("ADCHISODHC", doiHinhChinhModels.get(position).getChiSoDHC());
                sBQL.putString("ADQUOCTICHDHC", doiHinhChinhModels.get(position).getQuoctichDHC());
                sBQL.putString("ADGIADHC", String.valueOf(doiHinhChinhModels.get(position).getGiaCTDHC()));
                intent1.putExtras(sBQL);
                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doiHinhChinhModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avtatarCT;
        private TextView itemMactDHC;
        private TextView itemTenCauThuDHC;
        private TextView itemVtCt;
        private TextView itemCsCtDHC;
        private ImageView itemDeleteCtDHC;
        private ImageView itemEditCtDHC;


        public ViewHolder(View itemView) {
            super(itemView);
            avtatarCT = (ImageView) itemView.findViewById(R.id.avtatarCT);
            itemMactDHC = (TextView) itemView.findViewById(R.id.item_mact_DHC);
            itemTenCauThuDHC = (TextView) itemView.findViewById(R.id.item_ten_cau_thu_DHC);
            itemVtCt = (TextView) itemView.findViewById(R.id.item_vt_ct);
            itemCsCtDHC = (TextView) itemView.findViewById(R.id.item_cs_ctDHC);
            itemDeleteCtDHC = (ImageView) itemView.findViewById(R.id.item_delete_ct_DHC);
            itemEditCtDHC = (ImageView) itemView.findViewById(R.id.item_edit_ct_DHC);


        }
    }

    public void changeDataset(List<DoiHinhChinhModel> doiHinhChinhModels) {
        this.doiHinhChinhModels = doiHinhChinhModels;
        notifyDataSetChanged();
    }
}
