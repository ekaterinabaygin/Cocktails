package com.example.cocktails.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.cocktails.R;
import com.example.cocktails.domain.Drink;

public class DrinkDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK = "drink";

    private ImageView ImageViewDrink;
    private TextView textViewDrink;
    private TextView TextViewIngredients;
    private TextView textViewNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);
        initViews();
        Drink drink = (Drink) getIntent().getSerializableExtra(EXTRA_DRINK);


        Bundle extras = getIntent().getExtras();
        textViewDrink.setText(String.valueOf(Drink.idDrink));
        TextViewIngredients.setText(drink.strInstructions);
        textViewNotes.setText(Drink.strDrink);


        Glide.with(this)
                .load(drink.drinkImage.getUrl())
                .into(ImageViewDrink);

        textViewDrink.setText(Drink.idDrink);
        TextViewIngredients.setText(Drink.strDrink);


    }

    private void initViews() {
        ImageViewDrink = findViewById(R.id.ImageViewDrink);
        textViewDrink = findViewById(R.id.textViewDrink);
        TextViewIngredients = findViewById(R.id.TextViewIngredients);
        textViewNotes = findViewById(R.id.textViewNotes);
        Button button = findViewById(R.id.button);
    }


    public static Intent newIntent(Context context, Drink drink) {
        Intent intent = new Intent(context, DrinkDetailActivity.class);
        intent.putExtra(EXTRA_DRINK, drink);
        return intent;
    }
}
