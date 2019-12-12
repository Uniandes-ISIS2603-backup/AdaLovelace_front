package com.example.ada.screens.historial.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ada.screens.historial.views.HistorialView;

public class HistorialActivity extends AppCompatActivity {

    private HistorialView mHistorialView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHistorialView = new HistorialView(this, null);
        setContentView(mHistorialView.getRootView());
    }
}
