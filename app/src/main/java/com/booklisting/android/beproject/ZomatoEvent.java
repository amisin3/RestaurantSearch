package com.booklisting.android.beproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZomatoEvent {

    @SerializedName("event")
    @Expose
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}