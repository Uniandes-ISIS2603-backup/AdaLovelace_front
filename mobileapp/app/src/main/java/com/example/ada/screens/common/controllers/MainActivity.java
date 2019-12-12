package com.example.ada.screens.common.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ada.model.adaapi.AdaAPIClient;
import com.example.ada.model.adaapi.pojos.Book;
import com.example.ada.screens.common.views.BaseView;
import com.example.ada.screens.objects.ShoppingCart;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private BaseView rootView;
    private ShoppingCart shoppingCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shoppingCart = new ShoppingCart();
        Fresco.initialize(this);
        rootView = new BaseView(this, null);
        setContentView(rootView.getRootView());
        AdaAPIClient api = new AdaAPIClient(this);
        api.getBooks().enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                ArrayList<Book> books = response.body();
                for (Book b : books) {
                    System.out.println(b.getName());
                }
                rootView.bindBooks(books);
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });
    }

    public void addBook(Book book) {
        List<Book> books = shoppingCart.getBooks();
        if (books == null) books = new ArrayList<Book>();
        books.add(book);
        shoppingCart.setBooks(books);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void onBackPressed() {
        if(rootView.getModalOn()) rootView.hideModal();
    }
}
