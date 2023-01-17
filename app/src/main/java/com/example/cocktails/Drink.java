package com.example.cocktails;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Drink implements Serializable {

    @SerializedName("strDrink")
    @Expose
    private String strDrink;
    @SerializedName("strDrinkThumb")
    @Expose
    private String strDrinkThumb;
    @SerializedName("idDrink")
    @Expose
    private String idDrink;


    public Drink(String strDrink, String strDrinkThumb, String idDrink) {
        super();
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Drink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("strDrink");
        sb.append('=');
        sb.append(((this.strDrink == null)?"<null>":this.strDrink));
        sb.append(',');
        sb.append("strDrinkThumb");
        sb.append('=');
        sb.append(((this.strDrinkThumb == null)?"<null>":this.strDrinkThumb));
        sb.append(',');
        sb.append("idDrink");
        sb.append('=');
        sb.append(((this.idDrink == null)?"<null>":this.idDrink));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}