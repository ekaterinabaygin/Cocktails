package com.example.cocktails;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DrinkResponse {

    @SerializedName("drinks")
    @Expose
    private List<Drink> drinks = null;


    public DrinkResponse(List<Drink> drinks) {
        super();
        this.drinks = drinks;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DrinkResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("drinks");
        sb.append('=');
        sb.append(((this.drinks == null) ? "<null>" : this.drinks));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}