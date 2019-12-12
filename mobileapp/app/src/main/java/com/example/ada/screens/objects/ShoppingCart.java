package com.example.ada.screens.objects;

import com.example.ada.model.adaapi.pojos.Book;

import java.io.Serializable;
import java.util.List;

public class ShoppingCart implements Serializable {
    private List<Book> books;

    public ShoppingCart() {}

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
