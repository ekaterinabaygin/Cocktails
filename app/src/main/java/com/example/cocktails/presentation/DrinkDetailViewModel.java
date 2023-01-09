package com.example.cocktails.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cocktails.data.ApiFactory;
import com.example.cocktails.data.DrinkResponse;
import com.example.cocktails.domain.Drink;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DrinkDetailViewModel extends AndroidViewModel {

    private MutableLiveData<Drink> drinks = new MutableLiveData<>();

    public DrinkDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Drink> getDrinks() {
        return drinks;
    }

    public void loadDrinks(MutableLiveData<Drink> drinks) {
        this.drinks = drinks;
    }

    public void loadDrinks(int Id) {
        ApiFactory.apiService.loadDrinks(Drink.idDrink)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DrinkResponse>() {
                    @Override
                    public void accept(DrinkResponse drinkResponse) throws Throwable {
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });
    }
}


