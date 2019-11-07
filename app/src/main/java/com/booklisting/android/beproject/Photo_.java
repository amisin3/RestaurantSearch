package com.booklisting.android.beproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo_ {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumb_url")
    @Expose
    private String thumbUrl;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("md5sum")
    @Expose
    private String md5sum;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("photo_id")
    @Expose
    private Integer photoId;
    @SerializedName("uuid")
    @Expose
    private Double uuid;
    @SerializedName("type")
    @Expose
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Double getUuid() {
        return uuid;
    }

    public void setUuid(Double uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}