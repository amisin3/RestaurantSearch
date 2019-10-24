package com.booklisting.android.beproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/geocode")
    Call<Post> getSearch(@Query("lat") Double lat,
                         @Query("lon") Double lon);
}
