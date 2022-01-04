package com.example.generalaeronotics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private List<Model_class> user_data;
    private List<Image_Model> image_url;
    private Context con;



    public Adapter(List<Model_class> users, List<Image_Model> image_url, Context con) {
        this.user_data = users;
        this.image_url = image_url;
        this.con = con;
    }

    public Adapter(){}




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(con).inflate(R.layout.recycer_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder view, int position) {
        SetDataIntoRecyclerView sd=new SetDataIntoRecyclerView( view,position,view.photo, view.user_name,
                 view.user_address,view.user_id,view.SingleView,
                 view.longitude_value,  view.latitude_value, user_data,image_url);
        sd.Set_Data();


        //Glide is Taking too much time to load the images ,so I've used Piccasso
        /*Glide.with(con)
                .load(url)
                .dontTransform()
                .placeholder(R.drawable.error_image)
                .fitCenter()
                .dontAnimate()
                .into(holder.image);*/
        Picasso.get()
                .load(sd.getUrl())
                .placeholder(R.drawable.error_image)
                .fit()
                .error(R.drawable.error_image)
                .into(view.photo);
        view.SingleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alt=new AlertDialog.Builder(con);
                alt.setTitle("Select an option to naviagte.")
                        .setCancelable(true)
                        .setPositiveButton("Google Maps", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f",
                                        Double.parseDouble(sd.getLatitude_value_from_rt()),
                                        Double.parseDouble(sd.getLongitude_value_from_rt()));
                                Intent maps=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                maps.setPackage("com.google.android.apps.maps");
                                con.startActivity(maps);
                            }
                        }).setNegativeButton("Local Map", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(con,MapsActivity.class);
                        intent.putExtra("latitude",
                                Float.parseFloat(sd.getLatitude_value_from_rt()));
                        intent.putExtra("longitude",
                                Float.parseFloat(sd.getLongitude_value_from_rt()));
                        con.startActivity(intent);
                    }
                });
                alt.create();
                alt.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return user_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         ImageView photo;
         TextView user_name;
         TextView user_address;
         TextView user_id;
         RelativeLayout SingleView;
         TextView longitude_value;
         TextView latitude_value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_name=itemView.findViewById(R.id.user_name);
            photo=itemView.findViewById(R.id.user_image);
            longitude_value=itemView.findViewById(R.id.lati);
            user_address=itemView.findViewById(R.id.user_address);
            SingleView=itemView.findViewById(R.id.single_item);
            user_id=itemView.findViewById(R.id.id);
            latitude_value=itemView.findViewById(R.id.longi);
        }


    }


}
