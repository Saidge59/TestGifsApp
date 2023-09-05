package com.example.testgifsapp.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {
    @SerializedName("downsized_medium")
    @Expose
    private UrlImg urlImg;

    public UrlImg getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(UrlImg urlImg) {
        this.urlImg = urlImg;
    }
}
