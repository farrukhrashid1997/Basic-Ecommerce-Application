package com.example.farrukhbinrashid.ecommerce_basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AddtoCart extends AppCompatActivity {

    private ArrayList<String> imageNames;
    private ArrayList<Integer>images ;
    private ArrayList<String>price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_cart);
        Intent intent = getIntent();
        imageNames = intent.getStringArrayListExtra("ImageNames");
        images = intent.getIntegerArrayListExtra("Images");
        price = intent.getStringArrayListExtra("Price");
        initRecyclerView();
    }



    private void initRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_ATC);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageNames,images, price, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
