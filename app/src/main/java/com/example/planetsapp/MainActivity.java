package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ListView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static MyCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 - AdapterView: a listview
        listView= findViewById(R.id.listView);

        //2 - Data Source: ArrayList<Planet>
        planetArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Earth","1 Moon" ,R.drawable.earth,"Earth is the densest planet in the Solar System. Of the four rocky planets, it is the largest and most massive. Earth is about eight light-minutes away from the Sun and orbits it, taking a year (about 365.25 days) to complete one revolution.");
        Planet planet2 = new Planet("Mercury","0 Moons",R.drawable.mercury,"Mercury is the smallest planet of the solar system. It is less than half the size of Earth. Mercury's diameter, or distance through its center, is about 3,030 miles (4,900 kilometers).");
        Planet planet3 = new Planet("Venus","0 Moons",R.drawable.venus,"Venus is a near twin of Earth in size and mass but is completely enveloped by thick clouds of concentrated sulfuric acid droplets. Its surface gravity is about 90% that of Earth. Its atmosphere is over 96% carbon dioxide, with a pressure about 95 times Earth's.");
        Planet planet4 = new Planet("Mars","2 Moons",R.drawable.mars,"Mars is no place for the faint-hearted. It's dry, rocky, and bitter cold. The fourth planet from the Sun, Mars is one of Earth's two closest planetary neighbors (Venus is the other). Mars is one of the easiest planets to spot in the night sky – it looks like a bright red point of light.");
        Planet planet5 = new Planet("Jupiter","79 Moons",R.drawable.jupiter,"Jupiter is the fifth planet from our Sun and is, by far, the largest planet in the solar system – more than twice as massive as all the other planets combined. Jupiter's stripes and swirls are actually cold, windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium.");
        Planet planet6 = new Planet("Saturn","83 Moons",R.drawable.saturn,"Saturn is the sixth planet from the Sun and the second-largest planet in our solar system. Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium. Saturn is not the only planet to have rings, but none are as spectacular or as complex as Saturn's.");
        Planet planet7 = new Planet("Uranus","27 Moons",R.drawable.uranus,"Uranus is one of two ice giants in the outer solar system (the other is Neptune). Most (80% or more) of the planet's mass is made up of a hot dense fluid of \"icy\" materials – water, methane, and ammonia – above a small rocky core. ");
        Planet planet8 = new Planet("Neptune","14 Moons",R.drawable.neptune,"Dark, cold, and whipped by supersonic winds, ice giant Neptune is the eighth and most distant planet in our solar system. More than 30 times as far from the Sun as Earth, Neptune is the only planet in our solar system not visible to the naked eye.");

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);

        //Adapter:
        adapter = new MyCustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);

        //Action Click listener
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(MainActivity.this,
                    "Planet Name: "+ Objects.requireNonNull(adapter.getItem(i)).getPlanetName()+"\nNumber of Moons: "+adapter.getItem(i).getMoonCount(),
                    Toast.LENGTH_LONG).show();

            //Getting the selected planet
            Planet selectedPlanet = adapter.getItem(i);

            //Creating an intent
            Intent intent = new Intent(MainActivity.this, PlanetDetailsActivity.class);

            //Passing the data to other activity
            assert selectedPlanet != null;
            intent.putExtra("planetName",selectedPlanet.getPlanetName());
            intent.putExtra("planetDescription",selectedPlanet.getExtraDescription());

            startActivity(intent);

        });

    }
}