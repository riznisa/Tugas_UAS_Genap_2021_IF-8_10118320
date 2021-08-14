package com.latihan.uas_10118320_if8.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.latihan.uas_10118320_if8.R;

public class MapsWisata2Activity extends FragmentActivity implements OnMapReadyCallback {
    // 12 Agustus 2021 Raden Rizka M Nisa IF8

    private GoogleMap mMap;
    TextView tvDetailNamaWisata2, tvDetailBiayaMasukWisata2, tvDetailAlamatTempatWisata2;
    ImageView ivDetailMaps2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_wisata2);

        tvDetailNamaWisata2 = findViewById(R.id.tvDetailNamaWisata2);
        tvDetailNamaWisata2.setText(getIntent().getStringExtra("nama_tempat"));

        tvDetailBiayaMasukWisata2 = findViewById(R.id.tvDetailBiayaMasukWisata2);
        tvDetailBiayaMasukWisata2.setText("Biaya Masuk : " + getIntent().getStringExtra("biaya_masuk"));

        tvDetailAlamatTempatWisata2 = findViewById(R.id.tvDetailAlamatTempatWisata2);
        tvDetailAlamatTempatWisata2.setText("Alamat : " + getIntent().getStringExtra("alamat_tempat"));

        ivDetailMaps2 = findViewById(R.id.ivDetailMaps2);
        Glide.with(this)
                .load(getIntent().getStringExtra("gambar_tempat"))
                .into(ivDetailMaps2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        Double longitude = getIntent().getDoubleExtra("longitude", 0.0);


        LatLng wisata2 = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(wisata2).title(getIntent().getStringExtra("nama_tempat").toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wisata2));
    }
}