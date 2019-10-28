package com.booklisting.android.beproject;

import android.widget.ImageView;

import retrofit2.http.Url;

public class RestaurantCard {
    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private double price;
//    private String url;


    public RestaurantCard(int id, String title, String shortdesc, double rating, double price ) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
//        this.url = url;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

//    public String getUrl() {
//        return url;
//    }


}
