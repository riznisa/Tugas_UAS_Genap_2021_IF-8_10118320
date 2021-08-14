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

public class MapsWisata3Activity extends FragmentActivity implements OnMapReadyCallback {
    // 12 Agustus 2021 Raden Rizka M Nisa IF8

    private GoogleMap mMap;
    TextView tvDetailNamaWisata3, tvDetailBiayaMasukWisata3, tvDetailAlamatTempatWisata3;
    ImageView ivDetailMaps3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_wisata3);

        tvDetailNamaWisata3 = findViewById(R.id.tvDetailNamaWisata3);
        tvDetailNamaWisata3.setText(getIntent().getStringExtra("nama_tempat"));

        tvDetailBiayaMasukWisata3 = findViewById(R.id.tvDetailBiayaMasukWisata3);
        tvDetailBiayaMasukWisata3.setText("Biaya Masuk : " + getIntent().getStringExtra("biaya_masuk"));

        tvDetailAlamatTempatWisata3 = findViewById(R.id.tvDetailAlamatTempatWisata3);
        tvDetailAlamatTempatWisata3.setText("Alamat : " + getIntent().getStringExtra("alamat_tempat"));

        ivDetailMaps3 = findViewById(R.id.ivDetailMaps3);
        Glide.with(this)
                .load(getIntent().getStringExtra("gambar_tempat"))
                .into(ivDetailMaps3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        Double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        // Add a marker in Sydney and move the camera
        LatLng wisata3 = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(wisata3).title(getIntent().getStringExtra("nama_tempat").toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wisata3));
    }
}

