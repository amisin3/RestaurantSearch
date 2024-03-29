package com.booklisting.android.beproject;

import android.widget.ImageView;

import retrofit2.http.Url;

public class RestaurantCard {
    private String id;
    private String title;
    private String shortdesc;
    private double rating;
    private double price;
    private String featuredImageUrl;



    public RestaurantCard(String id, String title, String shortdesc, double rating, double price, String featuredImageUrl ) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.featuredImageUrl = featuredImageUrl;

    }

    public String getId() {
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

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }



}
