package com.example.generalaeronotics;

import com.google.gson.annotations.SerializedName;

public class NestedLong {
    @SerializedName("lat")
    private String latitude;
    @SerializedName("lng")
    private String Longitude;


    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public NestedLong(String lat, String lng) {
        this.latitude = lat;
        this.Longitude = lng;
    }
}
