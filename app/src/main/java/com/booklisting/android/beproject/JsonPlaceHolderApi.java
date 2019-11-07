package com.booklisting.android.beproject;

import com.booklisting.android.beproject.search.SearchResult;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/geocode")
    Call<Post> getSearch(@Query("lat") double lat,
                         @Query("lon") double lon);

    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/locations")
    Call<Post1> getSearch(@Query("query") String query);

    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/restaurant")
    Call<RestaurantDetail> getRestaurantDetail(@Query("res_id") String restaurantId);


    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/search")
    Call<SearchResult> search(@Query("q") String searchString,
                              @Query("count") int count);

    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/search")
    Call<SearchResult> searchEntity(@Query("entity_id") int entity_id ,
                              @Query("count") int count);


}
