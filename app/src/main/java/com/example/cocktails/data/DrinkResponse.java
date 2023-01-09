package com.example.cocktails.data;

import com.example.cocktails.domain.Drink;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrinkResponse {

        @SerializedName("drinks")
        private final List<Drink> drinks;

        public DrinkResponse(List<Drink> drinks) {
            this.drinks = drinks;
        }

        public List<Drink> getDrinks() {
            return drinks;
        }

    @Override
    public String toString() {
        return "DrinkResponse{" +
                "drinks=" + drinks +
                '}';
    }
}


