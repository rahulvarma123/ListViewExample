package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ListView listView;
    RecyclerView recyclerView;

    String[] countries = {"India", "Bangladesh", "Srilanka", "Australia", "Russia"}; // Data Source
    String[] capitals = {"New Delhi", "Dhaka", "Jayawardhanepura", "Cannebara", "Moscow"};
    int[] imageIds = {R.drawable.india, R.drawable.bangladesh, R.drawable.srilanka, R.drawable.countryone, R.drawable.countrytwo};
    CountryAdapter adapter;

    ArrayList<Country> countriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView = findViewById(R.id.listView);
        recyclerView = findViewById(R.id.rv_countries);

        // setting the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        populateData();

        adapter = new CountryAdapter(this, countriesList);

        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);
        //listView.setOnItemClickListener(this);

    }

   /* @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String selectedCountry = countries[position];
        Toast.makeText(this, selectedCountry, Toast.LENGTH_SHORT).show();
    }*/

    public List<Country> populateData() {

        for (int i = 0; i < 5; i++) {
            Country country = new Country();
            country.setCountryName(countries[i]);
            country.setCapitalName(capitals[i]);
            country.setFlagId(imageIds[i]);
            countriesList.add(country);
        }

        return countriesList;

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Country Clicked", Toast.LENGTH_LONG).show();
    }
}
