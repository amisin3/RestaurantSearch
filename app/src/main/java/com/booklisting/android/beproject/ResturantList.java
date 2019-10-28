package com.booklisting.android.beproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Url;

public class ResturantList extends AppCompatActivity {

    RecyclerView recyclerView;
    RestaurantAdapter restaurantAdapter;

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


        String arrayList = (String) getIntent().getSerializableExtra("nearbyRestaurant");
        ArrayList<NearbyRestaurant> nr = gson.fromJson(arrayList, new TypeToken<ArrayList<NearbyRestaurant>>(){}.getType());

//        Log.e("MyActivity",String.valueOf(nr.get(0).getRestaurant().getZomatoEvents().get(0).getEvent().getPhotos().get(0).getPhoto().getUrl()));

//        Toast.makeText(getApplicationContext(), nr.get(0).getRestaurant().getName(), Toast.LENGTH_LONG).show();

//        adding some items to our list
        String image;
        for(int i=0; i<nr.size(); i++){

            restaurantList.add(
                    new RestaurantCard(
                            i,
                            nr.get(i).getRestaurant().getName(),
                            nr.get(i).getRestaurant().getLocation().getAddress(),
                            Double.parseDouble(nr.get(i).getRestaurant().getUserRating().getAggregateRating()),
                            Double.parseDouble(""+nr.get(i).getRestaurant().getAverageCostForTwo())
//                            image
                    )
            );

        }
//        restaurantList.add(
//                new RestaurantCard(
//                        1,
//                        "Name",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000));

//        restaurantList.add(
//                new RestaurantCard(
//                        1,
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        4.3,
//                        60000));
//
//        restaurantList.add(
//                new RestaurantCard(
//                        1,
//                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000));
//
        restaurantAdapter = new RestaurantAdapter(this, restaurantList);
//
        recyclerView.setAdapter(restaurantAdapter);
    }


}
