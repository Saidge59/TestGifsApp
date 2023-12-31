package com.example.testgifsapp.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Data data model.
 *
 * @author Shesternyak Denis
 * @version 0.0.1
 */

public class Data {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("images")
    @Expose
    private Images images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
