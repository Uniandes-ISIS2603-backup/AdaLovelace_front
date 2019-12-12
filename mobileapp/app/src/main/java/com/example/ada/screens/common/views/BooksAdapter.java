package com.example.ada.screens.common.views;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ada.R;
import com.example.ada.model.adaapi.pojos.Book;
import com.example.ada.screens.book.controllers.BookDetailActivity;
import com.example.ada.screens.common.controllers.MainActivity;
import com.facebook.drawee.view.SimpleDraweeView;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private Book[] mDataset;
    private MainActivity activity;

    static class BooksViewHolder extends RecyclerView.ViewHolder {

        private TextView bookName;
        private SimpleDraweeView bookImage;
        private View bookContainer;
        private View add;

        private BooksViewHolder(View view) {
            super(view);
            bookName = view.findViewById(R.id.book_name);
            bookImage = view.findViewById(R.id.book_image);
            bookContainer = view.findViewById(R.id.book_container);
            add = view.findViewById(R.id.add);
        }
    }

    BooksAdapter(Book[] myDataset, MainActivity activity) {
        mDataset = myDataset;
        this.activity = activity;
    }

    @Override
    public BooksAdapter.BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BooksViewHolder holder, int position) {
        holder.bookName.setText(mDataset[position].getName());

        Uri uri = Uri.parse(mDataset[position].getImage());
        holder.bookImage.setImageURI(uri);

        holder.bookContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, BookDetailActivity.class);
                intent.putExtra("book", mDataset[holder.getAdapterPosition()]);
                activity.startActivity(intent);
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.addBook(mDataset[holder.getAdapterPosition()]);
                Toast.makeText(activity, "Se añadió al carrito", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
