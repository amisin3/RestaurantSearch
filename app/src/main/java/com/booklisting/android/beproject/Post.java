package com.booklisting.android.beproject;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("popularity")
    @Expose
    private Popularity popularity;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("nearby_restaurants")
    @Expose
    private ArrayList<NearbyRestaurant> nearbyRestaurants = null;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<NearbyRestaurant> getNearbyRestaurants() {
        return nearbyRestaurants;
    }

    public void setNearbyRestaurants(ArrayList<NearbyRestaurant> nearbyRestaurants) {
        this.nearbyRestaurants = nearbyRestaurants;
    }

    @Override
    public String toString() {
        return "Post{" +
                "location=" + location +
                ", popularity=" + popularity +
                ", link='" + link + '\'' +
                ", nearbyRestaurants=" + nearbyRestaurants +
                '}';
    }
}
