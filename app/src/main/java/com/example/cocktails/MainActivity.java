package com.example.cocktails;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {


    private MainViewModel viewModel;
    public RecyclerView recyclerViewDrink;
    private DrinkAdapter drinkAdapter;
    private ProgressBar progressBarLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarLoading = findViewById(R.id.progressBarLoading);
        recyclerViewDrink = findViewById(R.id.recyclerViewDrinks);
        drinkAdapter = new DrinkAdapter();
        recyclerViewDrink.setAdapter(drinkAdapter);
        recyclerViewDrink.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getDrinks().observe(this, drinks -> drinkAdapter.setDrinks(drinks));


        viewModel.getIsLoading().observe(this, isLoading -> {
            if (isLoading) {
                progressBarLoading.setVisibility(View.VISIBLE);
            } else {
                progressBarLoading.setVisibility(View.GONE);
            }
        });

        drinkAdapter.setOnReachEndListener(() -> viewModel.loadDrinks());

        drinkAdapter.setOnDrinkClickListener(drink -> {
            Intent intent = DrinkDetailActivity.newIntent(MainActivity.this, drink);
            startActivity(intent);
        });


    }
}





