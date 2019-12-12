package com.example.ada.screens.historial.views;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ada.R;

public class HistorialView {

    private View mRootView;
    private static int layout = R.layout.historial_layout;

    public HistorialView(AppCompatActivity activity, ViewGroup container) {
        mRootView = LayoutInflater.from(activity).inflate(layout, container);
    }

    public View getRootView() {
        return mRootView;
    }
}
