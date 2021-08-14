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
import com.latihan.uas_10118320_if8.adapter.Wisata2Adapter;
import com.latihan.uas_10118320_if8.model.Wisata2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WisataFragment2 extends Fragment {
    // 13 Agustus 2021 Raden Rizka M Nisa IF8
    private DatabaseReference reference;
    ArrayList<Wisata2> wisata2List;
    Wisata2Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wisata2, container, false);

        mRecyclerView = rootView.findViewById(R.id.list_kabupaten_bandung);
        mRecyclerView.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance("")
                .getReference().child("kabupaten_bandung");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                wisata2List = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Wisata2 wisata2 = dataSnapshot.getValue(Wisata2.class);
                    wisata2.setKey(dataSnapshot.getKey());
                    wisata2List.add(wisata2);
                }
                mAdapter = new Wisata2Adapter(getContext(), wisata2List);
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
