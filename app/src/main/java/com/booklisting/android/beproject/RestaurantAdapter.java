package com.booklisting.android.beproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.http.Url;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private Context mContext;
    private List<RestaurantCard> restaurantCardList;
    private String TAG = RestaurantAdapter.class.getSimpleName();

    public RestaurantAdapter(Context mContext, List<RestaurantCard> restaurantCardList) {
        this.mContext = mContext;
        this.restaurantCardList = restaurantCardList;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_products, null);
        RestaurantViewHolder restaurantViewHolder = new RestaurantViewHolder(view);
        return restaurantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int position) {
        //getting the product of the specified position
        final RestaurantCard restaurantCard = restaurantCardList.get(position);

        //binding the data with the viewholder views
        restaurantViewHolder.textViewTitle.setText(restaurantCard.getTitle());
        restaurantViewHolder.textViewShortDesc.setText(restaurantCard.getShortdesc());
        restaurantViewHolder.textViewRating.setText(String.valueOf(restaurantCard.getRating()));
        restaurantViewHolder.textViewPrice.setText("Average Cost For Two"+String.valueOf(restaurantCard.getPrice()));
        if(!restaurantCard.getFeaturedImageUrl().isEmpty())
            Picasso.get().load(restaurantCard.getFeaturedImageUrl()).into(restaurantViewHolder.imageView);


        restaurantViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restaurantDetail = new Intent(mContext, RestaurantDeatilActivity.class);
                restaurantDetail.putExtra("res_id", restaurantCard.getId());
                mContext.startActivity(restaurantDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantCardList.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
