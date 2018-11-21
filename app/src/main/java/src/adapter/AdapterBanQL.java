package src.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toanvu.duan1_hoanthien.R;

import java.util.List;

import src.database.DanhSachBanQuanLyDao;
import src.edit.EditBanQuanLy;
import src.edit.EditCauThuNoiBat;
import src.model.QuanLyModel;

public class AdapterBanQL extends RecyclerView.Adapter<AdapterBanQL.ViewHolder> {
    private Context context;
    private List<QuanLyModel> quanLyModelList;
    private DanhSachBanQuanLyDao danhSachBanQuanLyDao;

    public AdapterBanQL(Context context, List<QuanLyModel> quanLyModelList) {
        this.context = context;
        this.quanLyModelList = quanLyModelList;
        danhSachBanQuanLyDao = new DanhSachBanQuanLyDao(context);
    }
    

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ban_ql,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        QuanLyModel ql = quanLyModelList.get(position);
        holder.itemMaQL.setText(quanLyModelList.get(position).getMaQL());
        holder.itemTenQL.setText(quanLyModelList.get(position).getTenQL());
        holder.itemCVQL.setText((quanLyModelList.get(position).getChuvuQL()));
        holder.itemTcQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Optional");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(context, EditBanQuanLy.class);
                        Bundle sBQL = new Bundle();
                        sBQL.putString("ADMABQL", quanLyModelList.get(position).getMaQL());
                        sBQL.putString("ADTENBQL", quanLyModelList.get(position).getTenQL());
                        sBQL.putString("ADCHUVUBQL", quanLyModelList.get(position).getChuvuQL());
                        sBQL.putString("ADQUOCTICHBQL", quanLyModelList.get(position).getQuoctichQL());
                        sBQL.putString("ADLUONGBQL", String.valueOf(quanLyModelList.get(position).getLuongQL()));
                        sBQL.putString("ADGHICHUBQL",quanLyModelList.get(position).getGhiChu());
                        intent1.putExtras(sBQL);
                        context.startActivity(intent1);
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        danhSachBanQuanLyDao.deleteBanhSachQL(quanLyModelList.get(position).getMaQL());
                        quanLyModelList.remove(position);
                        notifyDataSetChanged();
                    }
                });

                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return quanLyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avtatarQL;
        TextView itemMaQL;
        TextView itemTenQL;
        TextView itemCVQL;
        ImageView itemTcQL;


        public ViewHolder(View itemView) {
            super(itemView);
            avtatarQL = itemView.findViewById(R.id.avtatarQL);
            itemMaQL = itemView.findViewById(R.id.item_maQL);
            itemTenQL = itemView.findViewById(R.id.item_ten_QL);
            itemCVQL = itemView.findViewById(R.id.item_CV_QL);
            itemTcQL = itemView.findViewById(R.id.item_tc_QL);
        }
    }
    public void changeDataset(List<QuanLyModel> quanLyModels) {
        this.quanLyModelList = quanLyModels;
        notifyDataSetChanged();
    }
}
