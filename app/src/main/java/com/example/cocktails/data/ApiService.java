package com.example.cocktails.data;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/json/v1/1/search.php?s=margarita")

    Single<DrinkResponse> loadDrinks(@Query("page") int page);

}
