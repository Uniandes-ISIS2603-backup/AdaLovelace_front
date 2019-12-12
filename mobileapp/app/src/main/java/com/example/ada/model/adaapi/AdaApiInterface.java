package com.example.ada.model.adaapi;

import com.example.ada.model.adaapi.pojos.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AdaApiInterface {
    @GET("books")
    Call<ArrayList<Book>> getBooks();
}
