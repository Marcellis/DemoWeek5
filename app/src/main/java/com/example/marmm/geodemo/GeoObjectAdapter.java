package com.example.marmm.geodemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by marmm on 3/6/17.
 */

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectAdapter.ViewHolder> {


    private GeoObjectCellSelected mGeoObjectCellSelected;
    private ArrayList<GeoObject> mGeoObject;
    private Context mContext;

    public GeoObjectAdapter(Context mContext, ArrayList<GeoObject> mGeoObjects) {
        this.mGeoObject = mGeoObjects;
        this.mContext = mContext;
    }

    @Override
    public GeoObjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

// Inflate the custom layout
        View geoObjectView = inflater.inflate(R.layout.grid_cell, parent, false);

// Return a new holder instance
        GeoObjectAdapter.ViewHolder viewHolder = new GeoObjectAdapter.ViewHolder(geoObjectView);
        return viewHolder;


    }






    @Override
    public void onBindViewHolder(GeoObjectAdapter.ViewHolder holder, final int position) {
        holder.tv.setText(mGeoObject.get(position).getmGeoName());
        holder.img.setImageResource(mGeoObject.get(position).getmGeoImageName());

        mGeoObjectCellSelected = (GeoObjectCellSelected) mContext;

//Set onClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtain the geo object
                GeoObject clickedGeoObject = mGeoObject.get(position);

                //We have to create the DetailFragment through MainActivity
                //Call the ReminderRowSelected function in MainActivity
                mGeoObjectCellSelected.GeoObjectCellSelected(
                        clickedGeoObject.getmGeoImageName());
            }
        });



    }

    @Override
    public int getItemCount() {
        return mGeoObject.size();
    }


    public interface GeoObjectCellSelected {
        void GeoObjectCellSelected( int geoOjectImageID);
    }

    //Data class containing one 'window' of the grid
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView img;

        //Constructor
        public ViewHolder(View v) {
            super(v);

            tv =(TextView)  v.findViewById(R.id.geoName);
            img=(ImageView) v.findViewById(R.id.geoImageView);
        }
    }

}
