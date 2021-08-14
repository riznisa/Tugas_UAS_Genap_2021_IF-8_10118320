package com.latihan.uas_10118320_if8.maps;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.latihan.uas_10118320_if8.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsWisata1Activity extends FragmentActivity implements OnMapReadyCallback {
    // 12 Agustus 2021 Raden Rizka M Nisa IF8

    private GoogleMap mMap;
    TextView tvDetailNamaWisata1, tvDetailBiayaMasukWisata1, tvDetailAlamatTempatWisata1;
    ImageView ivDetailMaps1;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_wisata1);

        tvDetailNamaWisata1 = findViewById(R.id.tvDetailNamaWisata1);
        tvDetailNamaWisata1.setText(getIntent().getStringExtra("nama_tempat"));

        tvDetailBiayaMasukWisata1 = findViewById(R.id.tvDetailBiayaMasukWisata1);
        tvDetailBiayaMasukWisata1.setText("Biaya Masuk : " + getIntent().getStringExtra("biaya_masuk"));

        tvDetailAlamatTempatWisata1 = findViewById(R.id.tvDetailAlamatTempatWisata1);
        tvDetailAlamatTempatWisata1.setText("Alamat : " + getIntent().getStringExtra("alamat_tempat"));

        ivDetailMaps1 = findViewById(R.id.ivDetailMaps1);
        Glide.with(this)
                .load(getIntent().getStringExtra("gambar_tempat"))
                .into(ivDetailMaps1);
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
        LatLng wisata1 = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(wisata1).title(getIntent().getStringExtra("nama_tempat").toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wisata1));
    }
}

