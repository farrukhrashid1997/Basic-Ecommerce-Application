package com.example.farrukhbinrashid.ecommerce_basic;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> price = new ArrayList<>();
    private ArrayList<String> mImageNames_cart = HomeActivity.getImageNames_cart();
    private ArrayList<Integer> mImages_cart = HomeActivity.getImages_cart();
    private ArrayList<String> price_cart = HomeActivity.getPrice_cart();

    private Context pcontext;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<Integer> mImages, ArrayList<String> price, Context pcontext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.price = price;
        this.pcontext = pcontext;
    }

    Dialog myDialog;

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.pname.setText(mImageNames.get(i));
        viewHolder.price.setText(price.get(i));
        viewHolder.img.setImageResource(mImages.get(i));

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog = new Dialog(pcontext);
                myDialog.setTitle("Purchase for "+price.get(i)+"Dollars ?");
                myDialog.setContentView(R.layout.purchase_popup);
                Button purchase_btn = myDialog.findViewById(R.id.purchase_btn);
                purchase_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mImageNames_cart.add(mImageNames.get(i));
                        mImages_cart.add(mImages.get(i));
                        price_cart.add(price.get(i));
                        Toast.makeText(pcontext, "The item is added to your cart.", Toast.LENGTH_SHORT).show();

                    }
                });
                Button cancel_btn = myDialog.findViewById(R.id.cancel_button);
                myDialog.show();
                cancel_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.hide();
                    }
                });
            }
        });


    }


    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public void searchList(ArrayList<String> imageNames_f, ArrayList<Integer> images_f, ArrayList<String> price_f) {
        mImageNames = imageNames_f;
        mImages = images_f;
        price = price_f;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView price;
        TextView pname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.productimage);
            price = itemView.findViewById(R.id.price);
            pname = itemView.findViewById(R.id.productname);

        }
    }
}
