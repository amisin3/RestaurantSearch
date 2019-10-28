package com.booklisting.android.beproject;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearbyRestaurant implements Serializable {

    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;

    public NearbyRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "NearbyRestaurant{" +
                "restaurant=" + restaurant +
                '}';
    }
}