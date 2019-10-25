package com.booklisting.android.beproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareData {

    @SerializedName("should_show")
    @Expose
    private Integer shouldShow;

    public Integer getShouldShow() {
        return shouldShow;
    }

    public void setShouldShow(Integer shouldShow) {
        this.shouldShow = shouldShow;
    }

}