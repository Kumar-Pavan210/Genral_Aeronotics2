package com.example.generalaeronotics;

import com.google.gson.annotations.SerializedName;

public class Image_Model {
    @SerializedName("thumbnailUrl")
    private String ImageUrl;

    public Image_Model(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }
}
