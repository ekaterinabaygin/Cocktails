package com.example.cocktails.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cocktails.R;
import com.example.cocktails.domain.Drink;

import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private List<Drink> drinks = new ArrayList<>();
    private OnReachEndListener onReachEndListener;
    private OnDrinkClickListener onDrinkClickListener;

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setOnDrinkClickListener(OnDrinkClickListener onDrinkClickListener) {
        this.onDrinkClickListener = onDrinkClickListener;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.drink_item,
                parent,
                false
        );
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        Drink drink = drinks.get(position);
        Glide.with(holder.itemView)
                .load(drink.getDrinkImage().getUrl())
                .into(holder.drinkImage);
        if (position == drinks.size() - 10 && onReachEndListener !=null) {
            onReachEndListener.OnReachEnd();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onReachEndListener !=null){
                    onDrinkClickListener.onDrinkClick(drink);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public interface OnReachEndListener {
        void OnReachEnd();
    }

    public interface OnDrinkClickListener{
        void onDrinkClick(Drink drink);
    }

    static class DrinkViewHolder extends RecyclerView.ViewHolder {

        private final ImageView drinkImage;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            drinkImage = itemView.findViewById(R.id.textViewDrink);

        }
    }
}
