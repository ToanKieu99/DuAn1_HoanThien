package src.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toanvu.duan1_hoanthien.R;

import java.util.List;

import src.database.CauThuNoiBatDao;
import src.database.DanhSachBanQuanLyDao;
import src.model.CauThuNoiBatModel;
import src.model.QuanLyModel;

public class AdapterCTNB extends RecyclerView.Adapter<AdapterCTNB.ViewHolder> {

    private Context context;
    private List<CauThuNoiBatModel> cauThuNoiBatModelList;
    private CauThuNoiBatDao cauThuNoiBatDao;

    public AdapterCTNB(Context context, List<CauThuNoiBatModel> cauThuNoiBatModelList) {
        this.context = context;
        this.cauThuNoiBatModelList = cauThuNoiBatModelList;
        cauThuNoiBatDao = new CauThuNoiBatDao(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cau_thu_noi_bat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CauThuNoiBatModel ql = cauThuNoiBatModelList.get(position);
        holder.itemMactnb.setText(cauThuNoiBatModelList.get(position).getMactNB());
        holder.itemTenCauThuNoiBat.setText(cauThuNoiBatModelList.get(position).getTenCTNB());
        holder.itemVtCtnb.setText((cauThuNoiBatModelList.get(position).getVitriCTNB()));
        holder.itemDeleteCtnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauThuNoiBatDao.deleteDanhsachCTNT(cauThuNoiBatModelList.get(position).getMactNB());
                cauThuNoiBatModelList.remove(position);
                notifyDataSetChanged();
            }
        });



    }

    @Override
    public int getItemCount() {
        return cauThuNoiBatModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avtatarCTNB;
        private TextView itemMactnb;
        private TextView itemTenCauThuNoiBat;
        private TextView itemVtCtnb;
        private ImageView itemDeleteCtnb;
        private ImageView itemEditCtnb;



        public ViewHolder(View itemView) {
            super(itemView);
            avtatarCTNB = (ImageView) itemView.findViewById(R.id.avtatarCTNB);
            itemMactnb = (TextView) itemView.findViewById(R.id.item_mactnb);
            itemTenCauThuNoiBat = (TextView) itemView.findViewById(R.id.item_ten_cau_thu_noi_bat);
            itemVtCtnb = (TextView) itemView.findViewById(R.id.item_vt_ctnb);
            itemDeleteCtnb = (ImageView) itemView.findViewById(R.id.item_delete_ctnb);
            itemEditCtnb = (ImageView) itemView.findViewById(R.id.item_edit_ctnb);
        }
    }
}
