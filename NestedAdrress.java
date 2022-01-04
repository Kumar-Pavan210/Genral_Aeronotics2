package com.example.generalaeronotics;

import com.google.gson.annotations.SerializedName;

public class NestedAdrress {
    @SerializedName("street")
    private String Area;
    @SerializedName("suite")
    private String Door_No;
    private String city;
    @SerializedName("geo")
    private NestedLong Lati_Long;

    public NestedAdrress(String area, String door_No, String city, NestedLong lati_Long) {
        Area = area;
        Door_No = door_No;
        this.city = city;
        Lati_Long = lati_Long;
    }

    public String getArea() {
        return Area;
    }

    public String getDoor_No() {
        return Door_No;
    }

    public String getCity() {
        return city;
    }

    public NestedLong getLati_Long() {
        return Lati_Long;
    }
}
