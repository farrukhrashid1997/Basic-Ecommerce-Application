package com.example.farrukhbinrashid.ecommerce_basic;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerViewAdapter adapter;
    private ArrayList<String>imageNames = new ArrayList<>();
    private ArrayList<Integer>images = new ArrayList<>();
    private ArrayList<String>price = new ArrayList<>();
    private static ArrayList<String>imageNames_cart = new ArrayList<>();
    private static ArrayList<Integer>images_cart = new ArrayList<>();
    private static ArrayList<String>price_cart = new ArrayList<>();

    public static ArrayList<String> getImageNames_cart() {
        return imageNames_cart;
    }

    public static ArrayList<Integer> getImages_cart() {
        return images_cart;
    }
/*
    public static void setImageNames_cart(ArrayList<String> imageNames_cart) {
        this.imageNames_cart = imageNames_cart;
    }

    public static void setImages_cart(ArrayList<Integer> images_cart) {
        this.images_cart = images_cart;
    }

    public static void setPrice_cart(ArrayList<String> price_cart) {
        this.price_cart = price_cart;
    }*/

    public static ArrayList<String> getPrice_cart() {
        return price_cart;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Products");
        EditText editText = findViewById(R.id.search_products);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });


        setSupportActionBar(toolbar);
        addImages();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this,AddtoCart.class);
                intent1.putExtra("Images",images_cart);
                intent1.putExtra("ImageNames",imageNames_cart);
                intent1.putExtra("Price",price_cart);
                Intent intent2 = new Intent(HomeActivity.this,emptycart.class);
                if(images_cart.size()>0)
                    startActivity(intent1);
                else
                    startActivity(intent2);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void filter(String s) {
         ArrayList<String>imageNames_f = new ArrayList<>();
         ArrayList<Integer>images_f = new ArrayList<>();
         ArrayList<String>price_f = new ArrayList<>();

         for(int i=0;i<imageNames.size();i++){
             if(imageNames.get(i).toLowerCase().contains(s.toLowerCase())){
                 imageNames_f.add(imageNames.get(i));
                 images_f.add(images.get(i));
                 price_f.add(price.get(i));}
         }
         adapter.searchList(imageNames_f,images_f,price_f);

    }


    private void addImages() {
        imageNames.add("Bone");
        images.add(R.drawable.bone);
        price.add("12 Dollars");

        imageNames.add("Carrot");
        images.add(R.drawable.carrot);
        price.add("15 Dollars");

        imageNames.add("Dog");
        images.add(R.drawable.dog);
        price.add("16 Dollars");

        imageNames.add("Flame");
        images.add(R.drawable.flame);
        price.add("10 Dollars");

        imageNames.add("Grapes");
        images.add(R.drawable.grapes);
        price.add("12 Dollars");

        imageNames.add("House");
        images.add(R.drawable.house);
        price.add("30 Dollars");

        imageNames.add("Lamp");
        images.add(R.drawable.lamp);
        price.add("3 Dollars");

        imageNames.add("Mouse");
        images.add(R.drawable.mouse);
        price.add("5 Dollars");

        imageNames.add("Nail");
        images.add(R.drawable.nail);
        price.add("7 Dollars");

        imageNames.add("Penguin");
        images.add(R.drawable.penguin);
        price.add("78 Dollars");

        imageNames.add("Rocks");
        images.add(R.drawable.rocks);
        price.add("1 Dollars");

        imageNames.add("Star");
        images.add(R.drawable.star);
        price.add("60 Dollars");

        imageNames.add("toad");
        images.add(R.drawable.toad);
        price.add("9 Dollars");

        imageNames.add("Van");
        images.add(R.drawable.van);
        price.add("24 Dollars");

        imageNames.add("Wheat");
        images.add(R.drawable.wheat);
        price.add("11 Dollars");

        imageNames.add("Yak");
        images.add(R.drawable.yak);
        price.add("90 Dollars");

        initRecyclerView();
    }

    private void initRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(imageNames,images, price, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_logout)
        {
            Intent intent =  new Intent(HomeActivity.this,loginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
