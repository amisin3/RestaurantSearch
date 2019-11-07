package com.booklisting.android.beproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.booklisting.android.beproject.search.Restaurant;
import com.booklisting.android.beproject.search.Restaurant_;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Url;

public class ResturantList extends AppCompatActivity {

    RecyclerView recyclerView;
    RestaurantAdapter restaurantAdapter;
    ArrayList<NearbyRestaurant> nr;
    List<Restaurant> restaurants;

    ArrayList<RestaurantCard> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_list);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        restaurantList = new ArrayList<>();


//        Location loc = (Location) getIntent().getSerializableExtra("loc");
        Gson gson = new Gson();

        if(getIntent().hasExtra("nearbyRestaurant")) {
            String arrayList = (String) getIntent().getSerializableExtra("nearbyRestaurant");
            nr = gson.fromJson(arrayList, new TypeToken<ArrayList<NearbyRestaurant>>() {
            }.getType());



            for(int i=0; i<nr.size(); i++){

                restaurantList.add(
                        new RestaurantCard(
                                nr.get(i).getRestaurant().getId(),
                                nr.get(i).getRestaurant().getName(),
                                nr.get(i).getRestaurant().getLocation().getAddress(),
                                Double.parseDouble(nr.get(i).getRestaurant().getUserRating().getAggregateRating()),
                                Double.parseDouble(""+nr.get(i).getRestaurant().getAverageCostForTwo()),
                                nr.get(i).getRestaurant().getFeaturedImage()

                        )
                );

            }
        }

        if(getIntent().hasExtra("restaurantsfromentity")){
            String restaurantsfromentity = (String) getIntent().getSerializableExtra("restaurantsfromentity");
            restaurants = gson.fromJson(restaurantsfromentity, new TypeToken<List<Restaurant>>(){}.getType());


                    for(Restaurant restaurant : restaurants){
                        Restaurant_ currRestaurant = restaurant.getRestaurant();
                        restaurantList.add(
                        new RestaurantCard(currRestaurant.getId(),
                                currRestaurant.getName(),
                                currRestaurant.getLocation().getAddress(),
                                Double.parseDouble(currRestaurant.getUserRating().getAggregateRating()),
                                currRestaurant.getAverageCostForTwo(),
                                currRestaurant.getFeaturedImage()
                                )


                    );

                }



        }


//        Log.e("MyActivity",String.valueOf(nr.get(0).getRestaurant().getZomatoEvents().get(0).getEvent().getPhotos().get(0).getPhoto().getUrl()));

//        Toast.makeText(getApplicationContext(), nr.get(0).getRestaurant().getName(), Toast.LENGTH_LONG).show();

//        adding some items to our lis;


        restaurantAdapter = new RestaurantAdapter(this, restaurantList);
        recyclerView.setAdapter(restaurantAdapter);
    }


}
