package com.booklisting.android.beproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.booklisting.android.beproject.search.Restaurant;
import com.booklisting.android.beproject.search.SearchResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = SearchActivity.class.getSimpleName();
    SearchView searchView;
    ListView suggestionListView;
    long lastEditTime = 0;
    ArrayList<String> locality, restaurantNames;
    SearchResult result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("https://developers.zomato.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        locality = new ArrayList<>();
        restaurantNames = new ArrayList<>();


        final JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        suggestionListView = findViewById(R.id.lv_suggestion);
        searchView = findViewById(R.id.searchView);
        searchView.getTouchables().get(0).performClick();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d(TAG, "onQueryTextChange: "+ s);
                if (s.length() <= 3)
                    return false;

                if (System.currentTimeMillis() - lastEditTime <= 1000) {
                    lastEditTime = System.currentTimeMillis();
                    return false;
                }


                //do query
                jsonPlaceHolderApi.search(s, 8).enqueue(new Callback<SearchResult>() {
                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                        result = response.body();
                        Log.d(TAG, result.toString());
                        restaurantNames.clear();
                        for(Restaurant restaurant : result.getRestaurants()){
                            restaurantNames.add(restaurant.getRestaurant().getName());
                            locality.add(restaurant.getRestaurant().getLocation().getLocality());
                        }

                        ArrayAdapter<String> restNamesAdapter = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_list_item_2, android.R.id.text1, restaurantNames){
                            @NonNull
                            @Override
                            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                                View view = super.getView(position, convertView, parent);
                                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                                text1.setText(restaurantNames.get(position));
                                text2.setText(locality.get(position));
                                return view;
                            }
                        };
                        suggestionListView.setAdapter(restNamesAdapter);

                    }

                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {

                    }
                });

                return false;
            }
        });



        suggestionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String res_id = result.getRestaurants().get(i).getRestaurant().getId();
                Intent restDetail = new Intent(SearchActivity.this, RestaurantDeatilActivity.class);
                restDetail.putExtra("res_id", res_id);
                startActivity(restDetail);
            }
        });

    }
}
