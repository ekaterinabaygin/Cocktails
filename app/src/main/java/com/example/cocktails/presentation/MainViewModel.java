package com.example.cocktails.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cocktails.data.ApiFactory;
import com.example.cocktails.data.DrinkResponse;
import com.example.cocktails.domain.Drink;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private final String TAG = "MainViewModel";

    private final MutableLiveData<List<Drink>> drinks = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isloading = new MutableLiveData<>(false);
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private int page = 1;

    public MainViewModel(@NonNull Application application) {
        super(application);
        loadDrinks();

    }

    public LiveData<List<Drink>> getDrinks() {
        return drinks;
    }

    public LiveData<Boolean> getIsloading() {
        return isloading;
    }

    public void loadDrinks() {
        Disposable disposable = ApiFactory.apiService.loadDrinks(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DrinkResponse>() {
                    @Override
                    public void accept(DrinkResponse DrinkResponse) throws Throwable {
                        List<Drink> loadedDrinks = drinks.getValue();
                        if (loadedDrinks != null) {
                            loadedDrinks.addAll(DrinkResponse.getDrinks());
                            drinks.setValue(loadedDrinks);
                        } else {
                            drinks.setValue(DrinkResponse.getDrinks());

                        }
                        page++;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });

        compositeDisposable.add(disposable);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}

