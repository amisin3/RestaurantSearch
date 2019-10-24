package com.booklisting.android.beproject;

import java.util.List;

public class RestaurantsZomato {

    public LocationDetails location;
    public Popularity popularity;
    public String link;
    public NearbyRestaurants nearby_restaurants;

    public static class LocationDetails {
        public String entity_type;
        public int entity_id;
        public String title;
        public String latitude;
        public String longitude;
        public int city_id;
        public String city_name;
        public int country_id;
        public String country_name;
    }

    public static class Popularity {
        public String popularity;
        public String nightlife_index;
        public List<String> nearby_res;
        public List<String> top_cuisines;
        public String popularity_res;
        public String nightlife_res;
        public String subzone;
        public int subzone_id;
        public String city;
    }

    public static class NearbyRestaurants {

        public RestaurantDetails restaurant;
    }

    public class RestaurantDetails {

        public Rest R;
        public String apikey;
        public String id;
        public String name;
        public String url;
        public LocationDetails location;
        public String cuisines;
        public String average_cost_for_two;
        public String price_range;
        public String currency;
        public List<String> offers;
        public String thumb;
        public UserRating user_rating;
        public String photos_url;
        public String menu_url;
        public String featured_image;
        public String has_online_delivery;
        public String is_delivering_now;
        public String deeplink;
        public String events_url;
        public String all_reviews_count;
        public String photo_count;
        public String phone_numbers;

        public LocationDetails getLocation() {
            return location;
        }

        public class LocationDetails {
            public String address;
            public String locality;
            public String city;
            public String latitude;
            public String longitude;
            public String zipcode;
            public String country_id;

            public String getAddress() {
                return address;
            }
        }

        public class UserRating {
            public String aggregate_rating;
            public String rating_text;
            public String rating_color;
            public String votes;
        }

        public class Rest {
            public float res_id;
        }
    }
}
