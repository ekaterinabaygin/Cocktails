package com.example.cocktails.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocktails.R;
import com.example.cocktails.domain.Drink;
import com.example.cocktails.presentation.MainViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    public RecyclerView recyclerViewDrink;
    private ProgressBar progressBarLoading;
    private DrinkAdapter drinkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBarLoading = findViewById(R.id.progressBarLoading);
        recyclerViewDrink = findViewById(R.id.rv_shop_list);
        drinkAdapter = new DrinkAdapter();
        recyclerViewDrink.setAdapter(drinkAdapter);

        Intent intent = new Intent(MainActivity.this, DrinkDetailActivity.class);
        startActivity(intent);

        recyclerViewDrink.setLayoutManager(new GridLayoutManager(this, 2));
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getDrinks().observe(this, new Observer<List<Drink>>() {
            @Override
            public void onChanged(List<Drink> drinks) {
                drinkAdapter.setDrinks(drinks);
            }
        });
        viewModel.getIsloading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) {
                    progressBarLoading.setVisibility(View.VISIBLE);
                } else {
                    progressBarLoading.setVisibility(View.INVISIBLE);
                }
            }
        });

        drinkAdapter.setOnReachEndListener(new DrinkAdapter.OnReachEndListener() {
            @Override
            public void OnReachEnd() {
                viewModel.loadDrinks();
            }
        });

        drinkAdapter.setOnDrinkClickListener(new DrinkAdapter.OnDrinkClickListener() {
            @Override
            public void onDrinkClick(Drink drink) {
                Intent intent = DrinkDetailActivity.newIntent(MainActivity.this,drink);
                startActivity(intent);
            }
        });

    }
}


