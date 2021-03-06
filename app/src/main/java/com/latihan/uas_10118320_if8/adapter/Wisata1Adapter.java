package com.latihan.uas_10118320_if8.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.latihan.uas_10118320_if8.R;
import com.latihan.uas_10118320_if8.maps.MapsWisata1Activity;
import com.latihan.uas_10118320_if8.model.Wisata1;

import java.util.ArrayList;

public class Wisata1Adapter extends RecyclerView.Adapter<Wisata1Adapter.ViewHolder> {
    // 12 Agustus 2021 Raden Rizka M Nisa IF8
    private Context context;
    private ArrayList<Wisata1> wisata1s;

    private DatabaseReference ref;

    public Wisata1Adapter(Context context, ArrayList<Wisata1> wisata1s){
        this.context= context;
        this.wisata1s = wisata1s;
        ref = FirebaseDatabase.getInstance("")
                .getReference().child("kota_bandung");
    }
    @Override
    public Wisata1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_wisata1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Wisata1Adapter.ViewHolder holder, int position) {
        holder.tvPreviewWisata1.setText(wisata1s.get(position).getNama_tempat());
        Glide.with(context)
                .load(wisata1s.get(position).getGambar_tempat())
                .into(holder.ivPreviewWisata1);

        holder.itemView.setOnClickListener(view -> {
            Intent detailWisata1 = new Intent(context.getApplicationContext(), MapsWisata1Activity.class);
            detailWisata1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            detailWisata1.putExtra("nama_tempat", wisata1s.get(position).getNama_tempat());
            detailWisata1.putExtra("biaya_masuk", wisata1s.get(position).getBiaya_masuk());
            detailWisata1.putExtra("alamat_tempat", wisata1s.get(position).getAlamat_tempat());
            detailWisata1.putExtra("gambar_tempat", wisata1s.get(position).getGambar_tempat());
            detailWisata1.putExtra("latitude", wisata1s.get(position).getLatitude());
            detailWisata1.putExtra("longitude", wisata1s.get(position).getLongitude());
            context.startActivity(detailWisata1);
        });
    }

    @Override
    public int getItemCount() {
        return wisata1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPreviewWisata1;
        TextView tvPreviewWisata1;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPreviewWisata1 = itemView.findViewById(R.id.ivPreviewWisata1);
            tvPreviewWisata1 = itemView.findViewById(R.id.tvPreviewWisata1);
        }
    }
}
