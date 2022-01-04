package com.example.generalaeronotics;

import androidx.fragment.app.FragmentActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap Map_instance;
    private Float Lat_Cordinates;
    private Float Long_cordinates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Window window=this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(this.getResources().getColor(R.color.sea));
        }
        Lat_Cordinates=getIntent().getExtras().getFloat("latitude");
        Long_cordinates=getIntent().getExtras().getFloat("longitude");
    }
    @Override
    public void onMapReady(GoogleMap Map) {
        Map_instance = Map;
        LatLng place = new LatLng(Lat_Cordinates,Long_cordinates);
        Adapter adapter=new Adapter();
        Map_instance.addMarker(new MarkerOptions().position(place).title("Lat:"+String.valueOf(Lat_Cordinates)+" "+"Long:"+String.valueOf(Long_cordinates)));
        Map_instance.moveCamera(CameraUpdateFactory.newLatLng(place));
    }
}