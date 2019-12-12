package com.example.ada.screens.book.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ada.model.adaapi.pojos.Book;
import com.example.ada.screens.book.views.BookDetailView;

public class BookDetailActivity extends AppCompatActivity {


    BookDetailView mBookDetailView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBookDetailView = new BookDetailView(this, null);
        setContentView(mBookDetailView.getRootView());
        Book book = (Book) getIntent().getSerializableExtra("book");
        mBookDetailView.setBook(book);
    }
}
