package com.example.cocktails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DrinkDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK = "drinks";

    private ImageView imageViewDrinkDetail;
    private TextView textViewDrinkDetail;
    private TextView textViewNotes;
    //  private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);
        initViews();

        Drink drink = (Drink) getIntent().getSerializableExtra(EXTRA_DRINK);

        if(drink != null) {
            Glide.with(this)
                    .load(drink.getStrDrinkThumb())
                    .into(imageViewDrinkDetail);
        }
        if(drink != null) {
            textViewDrinkDetail.setText(drink.getStrDrink());
        }

    }

    private void initViews() {
        imageViewDrinkDetail = findViewById(R.id.imageViewDrinkDetail);
        textViewDrinkDetail = findViewById(R.id.textViewDrinkDetail);
        textViewNotes = findViewById(R.id.textViewNotes);
        //  button = findViewById(R.id.button);
    }

    public static Intent newIntent(Context context, Drink drink) {
        Intent intent = new Intent(context, DrinkDetailActivity.class);
        intent.putExtra(EXTRA_DRINK, drink);
        return intent;
    }

}

