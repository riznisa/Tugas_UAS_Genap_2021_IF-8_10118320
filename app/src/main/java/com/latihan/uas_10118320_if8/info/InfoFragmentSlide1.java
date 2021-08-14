package com.latihan.uas_10118320_if8.info;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.latihan.uas_10118320_if8.R;

public class InfoFragmentSlide1 extends Fragment {
    // 11 Agustus 2021 Raden Rizka M Nisa IF8

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            ,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_info_slide1, container, false);
        return rootView;
    }
}
