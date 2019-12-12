package com.example.ada.screens.common.views;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ada.R;

public class BaseView {

    private View mRootView;
    private static int layout = R.layout.main_layout;

    public BaseView(AppCompatActivity activity, ViewGroup container) {
        mRootView = LayoutInflater.from(activity).inflate(layout, container);
    }

    public View getRootView() {
        return mRootView;
    }
}
