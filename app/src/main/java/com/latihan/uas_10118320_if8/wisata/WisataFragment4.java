package com.latihan.uas_10118320_if8.wisata;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.latihan.uas_10118320_if8.R;
import com.latihan.uas_10118320_if8.adapter.Wisata4Adapter;
import com.latihan.uas_10118320_if8.model.Wisata4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WisataFragment4 extends Fragment {
    // 13 Agustus 2021 Raden Rizka M Nisa IF8
    private DatabaseReference reference;
    ArrayList<Wisata4> wisata4List;
    Wisata4Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wisata4, container, false);

        mRecyclerView = rootView.findViewById(R.id.list_kota_cimahi);
        mRecyclerView.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance("")
                .getReference().child("kota_cimahi");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                wisata4List = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Wisata4 wisata4 = dataSnapshot.getValue(Wisata4.class);
                    wisata4.setKey(dataSnapshot.getKey());
                    wisata4List.add(wisata4);
                }
                mAdapter = new Wisata4Adapter(getContext(), wisata4List);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}