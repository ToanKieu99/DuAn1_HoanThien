package com.toankieu.toanvu.duan1_hoanthien.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.toankieu.toanvu.duan1_hoanthien.edit.EditCauThu;
import com.toankieu.toanvu.duan1_hoanthien.R;
import com.toankieu.toanvu.duan1_hoanthien.database.CauThuDao;
import com.toankieu.toanvu.duan1_hoanthien.model.CauThuModel;

import java.util.List;

public class CauThuAdapter extends BaseAdapter {
    List<CauThuModel> arrCauThu;
    public Context context;
    public LayoutInflater inflater;
    CauThuDao cauThuDao;

    public CauThuAdapter(Context context, List<CauThuModel> arrCauThu) {
        super();
        this.context = context;
        this.arrCauThu = arrCauThu;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        cauThuDao = new CauThuDao(context);
    }

    @Override
    public int getCount() {
        return arrCauThu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrCauThu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView avtatarCT;
        TextView itemMact;
        TextView itemTenCauThu;
        TextView itemVtCt;
        ImageView itemDeleteCt;
        ImageView itemEditCt;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_cauthu, null);
            holder.avtatarCT = convertView.findViewById(R.id.avtatarCT);
            holder.itemMact = convertView.findViewById(R.id.item_mact);
            holder.itemTenCauThu = convertView.findViewById(R.id.item_ten_cau_thu);
            holder.itemVtCt = convertView.findViewById(R.id.item_vt_ct);
            holder.itemDeleteCt = convertView.findViewById(R.id.item_delete_ct);
            holder.itemDeleteCt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cauThuDao.deleteCauThu(arrCauThu.get(position).getMaCT());
                    arrCauThu.remove(position);
                    notifyDataSetChanged();
                }
            });
            holder.itemEditCt = convertView.findViewById(R.id.item_edit_ct);
            holder.itemEditCt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(context, EditCauThu.class);
                    Bundle sCT = new Bundle();
                    sCT.putString("ADMACT", arrCauThu.get(position).getMaCT());
                    sCT.putString("ADTENCT", arrCauThu.get(position).getTenCT());
                    sCT.putString("ADCHISOCT", arrCauThu.get(position).getChisoCT());
                    sCT.putString("ADVITRICT", arrCauThu.get(position).getVitriCT());
                    sCT.putString("ADQUOCTICH", arrCauThu.get(position).getQuoctichCT());
                    sCT.putString("ADGIACT", String.valueOf(arrCauThu.get(position).getGiaCT()));
                    sCT.putString("ADGHICHU", arrCauThu.get(position).getGhichuCT());
                    intent1.putExtras(sCT);
                    context.startActivity(intent1);
                }
            });

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        CauThuModel ct = arrCauThu.get(position);
        holder.itemMact.setText(ct.getMaCT());
        holder.itemTenCauThu.setText(ct.getTenCT());
        holder.itemVtCt.setText(ct.getChisoCT());

        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<CauThuModel> items) {
        this.arrCauThu = items;
        notifyDataSetChanged();
    }
}
