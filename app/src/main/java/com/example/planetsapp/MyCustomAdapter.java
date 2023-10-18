package com.example.planetsapp;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //Using custom layouts -> MyCustomAdapter
    //Using custom objects -> extends ArrayAdapter<Planet>

    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.list_item_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    public static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImage;
    }

    //getView() -> used to create and return a view for a specific item in the list.

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //1 - Get the planet object for the current position
        Planet planet = getItem(position);

        //2 - Inflate layout
        MyViewHolder myViewHolder = new MyViewHolder();
        final View result;

        if(convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.list_item_layout,
                    parent,
                    false
            );


            //Finding Views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.no_of_moons);
            myViewHolder.planetImage = (ImageView) convertView.findViewById(R.id.image_view);

            result = convertView;

            convertView.setTag(myViewHolder);
        }else{
            // The view is already present and recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result= convertView;
        }

        //Getting the data from model class(Planet)
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }
}
