package com.booklisting.android.beproject;

import android.content.Context;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = (TextView) findViewById(R.id.text_view_result);
        nearby = (Button) findViewById(R.id.nearBy);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

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
        Call<Post> call = jsonPlaceHolderApi
                .getSearch(Latitude, Longitude);

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

                ArrayList<NearbyRestaurant> nr = post.getNearbyRestaurants();
                Log.e(TAG, String.valueOf(nr.get(0)));

                content += "locality: " + post.getLocality() + "\n";
                content += "getStatus: " + post.getLink() + "\n";
                content += "popularity: " + post.getPopularity() + "\n";
                content += "nearby_resturants: " + post.getNearbyRestaurants() + "\n";




                textViewResult.append(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "I am here");
                textViewResult.setText(t.getMessage());
            }
        });
    }

}
