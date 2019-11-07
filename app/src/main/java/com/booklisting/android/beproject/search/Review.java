
package com.booklisting.android.beproject.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("review")
    @Expose
    private Review_ review;

    public Review_ getReview() {
        return review;
    }

    public void setReview(Review_ review) {
        this.review = review;
    }

}
