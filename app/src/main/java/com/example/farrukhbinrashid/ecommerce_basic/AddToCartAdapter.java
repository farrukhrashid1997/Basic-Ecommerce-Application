package com.example.farrukhbinrashid.ecommerce_basic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.ViewHolder>{

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> price = new ArrayList<>();

    @NonNull
    @Override
    public AddToCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_layout,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddToCartAdapter.ViewHolder viewHolder, int i) {
        viewHolder.pname.setText(mImageNames.get(i));
        viewHolder.price.setText(price.get(i));
        viewHolder.img.setImageResource(mImages.get(i));

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView price;
        TextView pname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.productimage_cart);
            price = itemView.findViewById(R.id.price_cart);
            pname = itemView.findViewById(R.id.productname_cart);

        }
    }






}
