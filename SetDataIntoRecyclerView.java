package com.example.generalaeronotics;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class SetDataIntoRecyclerView {
    Adapter.ViewHolder view;
    List<Model_class> user_data;
    List<Image_Model> image_url;
    int position;
    ImageView photo;
    TextView user_name;
    TextView user_address;
    TextView user_id;
    RelativeLayout SingleView;
    TextView longitude_value;
    TextView latitude_value;
    String url;
    String longitude_value_from_rt;
    String latitude_value_from_rt;
    public SetDataIntoRecyclerView(Adapter.ViewHolder view, int position, ImageView photo, TextView user_name,
                                   TextView user_address, TextView user_id, RelativeLayout singleView,
                                   TextView longitude_value, TextView latitude_value,List<Model_class> user_data,List<Image_Model> image_url) {
        this.view = view;
        this.position = position;
        this.photo = photo;
        this.user_name = user_name;
        this.user_address = user_address;
        this.user_id = user_id;
        SingleView = singleView;
        this.longitude_value = longitude_value;
        this.latitude_value = latitude_value;
        this.user_data=user_data;
        this.image_url=image_url;
    }

    public void Set_Data(){
        view.user_name.setText(user_data.get(position).getName());
        String user_Area=String.valueOf(user_data.get(position).getAddress().getArea());
        String user_Door_no=String.valueOf(user_data.get(position).getAddress().getDoor_No());
        String user_city=String.valueOf(user_data.get(position).getAddress().getCity());
        String user_address=user_Area+", "+user_Door_no+", "+user_city+".";
        view.user_id.setText(String.valueOf(user_data.get(position).getId()));
        view.user_address.setText(user_address);
        longitude_value_from_rt=user_data.get(position).getAddress().getLati_Long().getLongitude();
        latitude_value_from_rt=user_data.get(position).getAddress().getLati_Long().getLatitude();
        view.longitude_value.setText("Long: "+longitude_value_from_rt);
        view.latitude_value.setText("Lat: "+latitude_value_from_rt);
        url=image_url.get(position).getImageUrl();
    }

    public String getUrl() {
        return url;
    }

    public String getLongitude_value_from_rt() {
        return longitude_value_from_rt;
    }

    public String getLatitude_value_from_rt() {
        return latitude_value_from_rt;
    }
}
