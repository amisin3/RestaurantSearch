package com.booklisting.android.beproject;

import android.content.Intent;
import android.net.Uri;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantDeatilActivity extends AppCompatActivity {

    String restaurantId;
    ImageView coverImage;
    TextView addressTv, phoneTv, cuisinetv, restaurantNameTv, ratingTv;
    MaterialButton zomatoBtn, menuBtn, photoBtn;
    private String TAG = RestaurantDeatilActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_deatil);



        coverImage = findViewById(R.id.iv_coverimg);
        addressTv = findViewById(R.id.tv_address);
        phoneTv = findViewById(R.id.tv_phone);
        cuisinetv = findViewById(R.id.tv_cuisines);
        zomatoBtn = findViewById(R.id.btn_zomato);
        menuBtn = findViewById(R.id.btn_menu);
        photoBtn = findViewById(R.id.btn_photo);
        restaurantNameTv = findViewById(R.id.tv_restaurantname);
        ratingTv = findViewById(R.id.tv_rating);



        Intent data = getIntent();
        if(data.hasExtra("res_id"))
            restaurantId = data.getStringExtra("res_id");




        Retrofit retrofit = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .baseUrl("https://developers.zomato.com/")
                                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        final Call<RestaurantDetail> restaurantCall = jsonPlaceHolderApi.getRestaurantDetail(restaurantId);
        restaurantCall.enqueue(new Callback<RestaurantDetail>() {
            @Override
            public void onResponse(Call<RestaurantDetail> call, Response<RestaurantDetail> response) {
                final RestaurantDetail restaurantDetail = response.body();
                Log.d(TAG, response.toString());
//                Toast.makeText(RestaurantDeatilActivity.this, "Started loading page", Toast.LENGTH_SHORT).show();


                Picasso.get().load(restaurantDetail.getFeaturedImage()).into(coverImage);
                restaurantNameTv.setText(restaurantDetail.getName());
                addressTv.setText(restaurantDetail.getLocation().getAddress());
                cuisinetv.setText(restaurantDetail.getCuisines());
                phoneTv.setText(restaurantDetail.getPhoneNumbers());
                ratingTv.setText(restaurantDetail.getUserRating().getRatingText() +" " +   restaurantDetail.getUserRating().getAggregateRating());


                menuBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = restaurantDetail.getMenuUrl();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });


                zomatoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = restaurantDetail.getUrl();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });


                photoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = restaurantDetail.getPhotosUrl();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });


            }

            @Override
            public void onFailure(Call<RestaurantDetail> call, Throwable t) {
                Toast.makeText(RestaurantDeatilActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
