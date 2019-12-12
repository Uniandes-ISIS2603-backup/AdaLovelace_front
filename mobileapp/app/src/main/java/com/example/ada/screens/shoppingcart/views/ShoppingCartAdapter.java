package com.example.ada.screens.shoppingcart.views;

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
import com.example.ada.screens.shoppingcart.controllers.ShoppingCartActivity;
import com.facebook.drawee.view.SimpleDraweeView;


public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder> {

    private Book[] mDataset;
    private ShoppingCartActivity activity;

    static class ShoppingCartViewHolder extends RecyclerView.ViewHolder {

        private TextView bookName;
        private SimpleDraweeView bookImage;
        private View bookContainer;
        private View delete;
        private TextView bookPrice;

        private ShoppingCartViewHolder(View view) {
            super(view);
            bookName = view.findViewById(R.id.book_name);
            bookImage = view.findViewById(R.id.book_image);
            bookContainer = view.findViewById(R.id.book_container);
            delete = view.findViewById(R.id.delete);
            bookPrice = view.findViewById(R.id.book_price);
        }
    }

    ShoppingCartAdapter(Book[] myDataset, ShoppingCartActivity activity) {
        mDataset = myDataset;
        this.activity = activity;
    }

    @Override
    public ShoppingCartAdapter.ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_cart, parent, false);
        return new ShoppingCartAdapter.ShoppingCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShoppingCartAdapter.ShoppingCartViewHolder holder, int position) {
        holder.bookName.setText(mDataset[position].getName());

        Uri uri = Uri.parse(mDataset[position].getImage());
        holder.bookImage.setImageURI(uri);

        String s = "" + mDataset[position].getPrice();
        holder.bookPrice.setText(s);
        holder.bookContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, BookDetailActivity.class);
                intent.putExtra("book", mDataset[holder.getAdapterPosition()]);
                activity.startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.deleteBook(mDataset[holder.getAdapterPosition()]);
                Toast.makeText(activity, "Se eliminó del carrito", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
