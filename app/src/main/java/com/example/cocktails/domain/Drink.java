package com.example.cocktails.domain;


import com.example.cocktails.presentation.DrinkImage;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Drink implements Serializable{

    @SerializedName("idDrink")
    public static int idDrink;
    @SerializedName("strDrink")
    public static String strDrink;
    @SerializedName("strInstructions")
    public String strInstructions;
    @SerializedName("strImageSource")
    public String strImageSource;
    @SerializedName("drinkImage")
    public DrinkImage drinkImage;

    public Drink(String strDrink, String strInstructions, String strImageSource, DrinkImage drinkImage) {
        this.strDrink = strDrink;
        this.strInstructions = strInstructions;
        this.strImageSource = strImageSource;
        this.drinkImage = drinkImage;
    }


    public static int getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public DrinkImage getDrinkImage() {
        return drinkImage;
    }
}




