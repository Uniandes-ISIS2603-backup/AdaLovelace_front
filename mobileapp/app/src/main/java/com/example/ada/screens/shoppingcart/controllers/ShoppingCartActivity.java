package com.example.ada.screens.shoppingcart.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ada.model.adaapi.pojos.Book;
import com.example.ada.screens.objects.ShoppingCart;
import com.example.ada.screens.shoppingcart.views.ShoppingCartView;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    private ShoppingCartView mShoppingCartView;
    private ShoppingCart cart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShoppingCartView = new ShoppingCartView(this, null);
        cart = (ShoppingCart) getIntent().getSerializableExtra("cart");
        mShoppingCartView.setCart(cart);
        setContentView(mShoppingCartView.getRootView());

        System.out.println("MOSTRANDO: inicie cart");
        for (Book b : cart.getBooks()) {
            System.out.println("MOSTRANDO: " + b.getName());
        }
    }

    public void updateCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public void deleteBook(Book book) {
        mShoppingCartView.deleteBook(book);
    }

    public void buy(List<Book> books) {
        //TODO: Complete
    }
}
