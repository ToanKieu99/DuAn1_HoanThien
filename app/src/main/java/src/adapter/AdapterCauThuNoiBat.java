package src.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toanvu.duan1_hoanthien.R;

import java.util.List;

import src.database.CauThuNoiBatDao;
import src.details.DetailCauThuNoiBat;
import src.edit.EditCauThuNoiBat;
import src.fragment.CauThuNoiBatFragment;
import src.model.CauThuNoiBatModel;

public class AdapterCauThuNoiBat extends BaseAdapter {
    List<CauThuNoiBatModel> arrCauThuNB;
    public Context context;
    public LayoutInflater inflater;
    CauThuNoiBatDao cauThuNoiBatDao;

    public AdapterCauThuNoiBat(Context context,List<CauThuNoiBatModel> arrCauThuNB) {
        super();
        this.context = context;
        this.arrCauThuNB = arrCauThuNB;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        cauThuNoiBatDao = new CauThuNoiBatDao(context);
    }

    @Override
    public int getCount() {
        return arrCauThuNB.size();
    }

    @Override
    public Object getItem(int position) {
        return arrCauThuNB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView avatarCauThuNB,imgxoa,imgEdit;
        TextView txtMaCTNB, txtTenCTNB, txtViTriCTNB;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_cau_thu_noi_bat, null);
            holder.avatarCauThuNB = convertView.findViewById(R.id.avtatarCTNB);
            holder.txtMaCTNB = convertView.findViewById(R.id.item_mactnb);
            holder.txtTenCTNB = convertView.findViewById(R.id.item_ten_cau_thu_noi_bat);
            holder.txtViTriCTNB = convertView.findViewById(R.id.item_vt_ctnb);
            holder.imgxoa = convertView.findViewById(R.id.item_delete_ctnb);
            holder.imgxoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cauThuNoiBatDao.deleteDanhsachCTNT(arrCauThuNB.get(position).getMactNB());
                    arrCauThuNB.remove(position);
                    notifyDataSetChanged();
                }
            });
            holder.imgEdit = convertView.findViewById(R.id.item_edit_ctnb);
            holder.imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(context, EditCauThuNoiBat.class);
                    Bundle sCTNB = new Bundle();
                    sCTNB.putString("ADMACTNB", arrCauThuNB.get(position).getMactNB());
                    sCTNB.putString("ADTENCTNB", arrCauThuNB.get(position).getTenCTNB());
                    sCTNB.putString("ADVITRICTNB", arrCauThuNB.get(position).getVitriCTNB());
                    sCTNB.putString("ADQUOCTICHCTNB", arrCauThuNB.get(position).getQuoctichCTNB());
                    sCTNB.putString("ADCHISOCTMNB",arrCauThuNB.get(position).getChisoCTNB());
                    sCTNB.putString("ADGIACTNB",arrCauThuNB.get(position).getGiaCTNB());
                    intent1.putExtras(sCTNB);
                    context.startActivity(intent1);
                }
            });

            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();
        CauThuNoiBatModel ct = arrCauThuNB.get(position);
        holder.txtMaCTNB.setText(ct.getMactNB());
        holder.txtTenCTNB.setText(ct.getTenCTNB());
        holder.txtViTriCTNB.setText(ct.getVitriCTNB());

        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<CauThuNoiBatModel> items) {
        this.arrCauThuNB = items;
        notifyDataSetChanged();
    }
}
