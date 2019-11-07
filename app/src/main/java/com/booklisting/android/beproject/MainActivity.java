package com.booklisting.android.beproject;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.booklisting.android.beproject.search.Restaurant;
import com.booklisting.android.beproject.search.Restaurant_;
import com.booklisting.android.beproject.search.SearchResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private static final String TAG = "MyActivity";
    private TextView textViewResult;
    private Button nearby;

    LocationManager locationManager;
    LocationListener locationListenerner;


    private Location mobileLocation;
    private double Latitude;
    private double Longitude;

    private SearchView search;

    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nearby = (Button) findViewById(R.id.nearBy);
        search = (SearchView) findViewById(R.id.mySearch);



        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

//        Intent intent = getIntent();
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            doMySearch(query);
//        }



        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ctx = getApplicationContext();
                getLocation(ctx);

            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

//        getSearch(19.0760, 72.8777);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                textViewResult.setText("");
                query = s;
                getSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(s);
                return false;
            }
        });




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });



    }

    void getLocation(Context ctx) {
        try {
            locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
            locationListenerner = new LocationListener(){



                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }

                @Override
                public void onLocationChanged(android.location.Location location) {
                    Log.e(TAG, String.valueOf(location));
                    mobileLocation = location;
                }
            };
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListenerner);
            mobileLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            List<String> providers = locationManager.getProviders(true);
            android.location.Location bestLocation = null;
            for (String provider : providers) {
                Location l = locationManager.getLastKnownLocation(provider);
                if (l == null) {
                    continue;
                }
                if (mobileLocation == null || l.getAccuracy() < mobileLocation.getAccuracy()) {
                    // Found best last known location: %s", l);
                    mobileLocation = l;
                }            }
            if (mobileLocation != null) {
                locationManager.removeUpdates(locationListenerner);
                String longitude = "Longitude: " + mobileLocation.getLongitude();
                String latitude = "Latitude: " + mobileLocation.getLatitude();
                String altitiude = "Altitiude: " + mobileLocation.getAltitude();
                String accuracy = "Accuracy: " + mobileLocation.getAccuracy();
                String time = "Time: " + mobileLocation.getTime();
                Toast.makeText(ctx, "Latitude is = "+latitude +"Longitude is ="+longitude, Toast.LENGTH_LONG).show();
                Longitude =  mobileLocation.getLongitude();
                Latitude = mobileLocation.getLatitude();
                getSearch(Latitude, Longitude);

            } else {
                System.out.println("in find location 4");
                Toast.makeText(ctx, "Sorry location is not determined", Toast.LENGTH_LONG).show();
            }
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }


    private void getSearch(double Latitude, double Longitude) {

        Log.d(TAG, "getSearch: "+ Double.parseDouble(String.format("%.6f", Latitude)) + " " + Double.parseDouble(String.format("%.6f", Longitude)));

        Call<Post> call = jsonPlaceHolderApi
                .getSearch(19, 72);

//        19.0643418   lat
//        72.8356988    lon

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }


                Post post = response.body();
                Log.d(TAG, String.valueOf(post));




                String content = "";
                Gson gson = new Gson();


                ArrayList<NearbyRestaurant> nr = post.getNearbyRestaurants();
                String json = gson.toJson(nr);


                Intent i = new Intent(getApplicationContext() ,ResturantList.class);
                i.putExtra("nearbyRestaurant", json);

                startActivity(i);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                Log.e(TAG, "I am here " + t.getMessage());
//                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getSearch(String query) {
        Call<Post1> call = jsonPlaceHolderApi
                .getSearch(query);

        call.enqueue(new Callback<Post1>() {
            @Override
            public void onResponse(Call<Post1> call, Response<Post1> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }



                Post1 search = response.body();
                Log.e(TAG, String.valueOf(search));

                String content = "";


                content += "locationSuggestion: "+ search.getLocationSuggestions();
                content += "status: "+ search.getStatus();

                content += "entity_id: " + search.getLocationSuggestions();
                int entity_id = search.getLocationSuggestions().get(0).getEntityId();
                Log.d(TAG, String.valueOf(entity_id));

//                textViewResult.append(entity_id);

                getSearchUsingEntity(entity_id);





            }

            @Override
            public void onFailure(Call<Post1> call, Throwable t) {
                Log.e(TAG, "I am here");
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getSearchUsingEntity(int entity_id) {
        Call<SearchResult> call = jsonPlaceHolderApi
                .searchEntity(entity_id, 8);

        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult result = response.body();
                Log.d(TAG, String.valueOf(result));
                ArrayList<RestaurantCard> restaurantCards = new ArrayList<>();
//                for(Restaurant restaurant : result.getRestaurants()){
//
//                    Restaurant_ currRestaurant = restaurant.getRestaurant();
//                    restaurantCards.add(
//                            new RestaurantCard(currRestaurant.getId(),
//                                    currRestaurant.getName(),
//                                    currRestaurant.getLocation().getAddress(),
//                                    Double.parseDouble(currRestaurant.getUserRating().getAggregateRating()),
//                                    currRestaurant.getAverageCostForTwo(),
//                                    currRestaurant.getFeaturedImage()
//                                    )
//
//
//                    );
//
//                }


                Gson gson = new Gson();


                List<Restaurant> restaurants = result.getRestaurants();
                String json = gson.toJson(restaurants);


                Intent i = new Intent(getApplicationContext() ,ResturantList.class);
                i.putExtra("restaurantsfromentity", json);

                startActivity(i);
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {

            }
        });

    }


}
