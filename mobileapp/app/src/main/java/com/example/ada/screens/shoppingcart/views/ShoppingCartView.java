package com.example.ada.screens.shoppingcart.views;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ada.R;
import com.example.ada.model.adaapi.pojos.Book;
import com.example.ada.screens.objects.ShoppingCart;
import com.example.ada.screens.shoppingcart.controllers.ShoppingCartActivity;

import java.util.List;

public class ShoppingCartView {

    private View mRootView;
    private static int layout = R.layout.shopping_cart_layout;

    private ShoppingCart cart;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ShoppingCartActivity mActivity;

    public ShoppingCartView(ShoppingCartActivity activity, ViewGroup container) {
        mRootView = LayoutInflater.from(activity).inflate(layout, container);
        mActivity = activity;

        recyclerView = mRootView.findViewById(R.id.shopping_cart_rv);
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        mRootView.findViewById(R.id.buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.buy(cart.getBooks());
            }
        });

    }

    public View getRootView() {
        return mRootView;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
        List<Book> books1 = cart.getBooks();
        Book[] books = books1.toArray(new Book[books1.size()]);
        mAdapter = new ShoppingCartAdapter(books, mActivity);
        recyclerView.setAdapter(mAdapter);
    }

    public void deleteBook(Book book) {
        List<Book> books = cart.getBooks();
        books.remove(book);
        cart.setBooks(books);
        mActivity.updateCart(cart);

        Book[] books2 = books.toArray(new Book[books.size()]);
        mAdapter = new ShoppingCartAdapter(books2, mActivity);
        recyclerView.setAdapter(mAdapter);
    }


}
