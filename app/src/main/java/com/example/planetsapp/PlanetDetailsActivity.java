package com.example.planetsapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlanetDetailsActivity extends AppCompatActivity {
    TextView planetInfo;
    TextView planetTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_desciption_layout);

        String planetName = getIntent().getStringExtra("planetName");
        String extraDescription = getIntent().getStringExtra("planetDescription");

        //Initialize views in the planet_description_layout
        planetTitle= findViewById(R.id.planet_title);
        planetInfo= findViewById(R.id.planet_text);

        //Set the data to the views
        planetTitle.setText(planetName);
        planetInfo.setText(extraDescription);


    }
}
