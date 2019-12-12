package com.example.ada.screens.common.views;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

    private boolean modalOn = false;

    private String filtro;

    private ArrayList<Book> books;


    public BaseView(MainActivity activity, ViewGroup container) {
        mRootView = LayoutInflater.from(activity).inflate(layout, container);
        recyclerView = mRootView.findViewById(R.id.books_rv);
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        mActivity = activity;

        Spinner spinner = mRootView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.filtros_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int i, long id) {
                filtro = (String) parentView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });


        mRootView.findViewById(R.id.shopping_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, ShoppingCartActivity.class);
                intent.putExtra("cart", mActivity.getShoppingCart());
                mActivity.startActivity(intent);
            }
        });
        mRootView.findViewById(R.id.filtrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRootView.findViewById(R.id.modal).setVisibility(View.VISIBLE);
                modalOn = true;
            }
        });

        mRootView.findViewById(R.id.btn_filtrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filt = ((EditText)mRootView.findViewById(R.id.filter_value)).getText().toString();
                filtrar(filt);
                mRootView.findViewById(R.id.modal).setVisibility(View.GONE);
                modalOn = false;
            }
        });
    }

    public View getRootView() {
        return mRootView;
    }

    public void bindBooks(ArrayList<Book> data) {
        Book[] books = data.toArray(new Book[data.size()]);
        this.books = data;
        mAdapter = new BooksAdapter(books, mActivity);
        recyclerView.setAdapter(mAdapter);
    }

    public boolean getModalOn() {
        return modalOn;
    }

    public void hideModal() {
        mRootView.findViewById(R.id.modal).setVisibility(View.GONE);
    }

    public void filtrar(String f) {
        if(filtro.equals("Nombre")) {
            filtrarNombre(f);
        } else if(filtro.equals("Género")) {
            filtrarGenero(f);
        } else {
            filtrarAutor(f);
        }
    }

    public void filtrarNombre(String nombre) {
        ArrayList<Book> b1 = new ArrayList<>();
        for(Book b : books) {
            if(b.getName().equals(nombre))
                b1.add(b);
        }
        bindBooks(b1);
    }

    public void filtrarAutor(String autor) {
        ArrayList<Book> b1 = new ArrayList<>();
        for(Book b : books) {
            if(b.getAuthor().equals(autor))
                b1.add(b);
        }
        bindBooks(b1);
    }

    public void filtrarGenero(String genero) {
        ArrayList<Book> b1 = new ArrayList<>();
        for(Book b : books) {
            if(b.getGenre().equals(genero))
                b1.add(b);
        }
        bindBooks(b1);
    }
}
