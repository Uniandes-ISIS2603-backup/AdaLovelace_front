package com.example.ada.screens.book.views;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ada.R;
import com.example.ada.model.adaapi.pojos.Book;
import com.facebook.drawee.view.SimpleDraweeView;

public class BookDetailView {

    View mRootView;

    private static int layout = R.layout.book_detail;

    public BookDetailView(AppCompatActivity activity, ViewGroup container) {
        mRootView = LayoutInflater.from(activity).inflate(layout, container);
    }

    public View getRootView() {
        return mRootView;
    }

    public void setBook(Book book) {
        TextView tv1 = mRootView.findViewById(R.id.book_author);
        tv1.setText(book.getAuthor());

        TextView tv2 = mRootView.findViewById(R.id.book_date);
        tv2.setText(book.getPublishingdate());

        TextView tv3 = mRootView.findViewById(R.id.book_genre);
        tv3.setText(book.getGenre());

        TextView tv4 = mRootView.findViewById(R.id.book_isbn);
        tv4.setText(book.getIsbn());

        TextView tv5 = mRootView.findViewById(R.id.book_name);
        tv5.setText(book.getName());

        TextView tv6 = mRootView.findViewById(R.id.book_score);
        tv6.setText(String.valueOf(book.getAvgRating()));

        SimpleDraweeView book_image = mRootView.findViewById(R.id.book_image);
        Uri uri = Uri.parse(book.getImage());
        book_image.setImageURI(uri);
    }
}
