package com.example.ada.screens.common.views;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ada.R;
import com.example.ada.model.adaapi.pojos.Book;
import com.example.ada.screens.common.controllers.MainActivity;
import com.example.ada.screens.shoppingcart.controllers.ShoppingCartActivity;

import java.util.ArrayList;

public class BaseView {

    private View mRootView;
    private static int layout = R.layout.main_layout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainActivity mActivity;


    public BaseView(MainActivity activity, ViewGroup container) {
        mRootView = LayoutInflater.from(activity).inflate(layout, container);
        recyclerView = mRootView.findViewById(R.id.books_rv);
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        mActivity = activity;
        mRootView.findViewById(R.id.shopping_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, ShoppingCartActivity.class);
                intent.putExtra("cart", mActivity.getShoppingCart());
                mActivity.startActivity(intent);
            }
        });
    }

    public View getRootView() {
        return mRootView;
    }

    public void bindBooks(ArrayList<Book> data) {
        Book[] books = data.toArray(new Book[data.size()]);
        mAdapter = new BooksAdapter(books, mActivity);
        recyclerView.setAdapter(mAdapter);
    }
}
