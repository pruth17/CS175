package edu.sjsu.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryItem> countryList;
    ListView mListView;
    String[] countryNames = {"Australia", "Germany", "France", "Italy", "USA", "Spain", "Russia"};
    String[] AustraliaCity = {"Brisbane", "Melbourne", "Sydney"};
    String[] GermanyCity = {"Berlin", "Munich", "Frankfurt"};
    String[] FranceCity = {"Monaco", "Paris"};
    String[] ItalyCity = {"Naples", "Milan", "Rome"};
    String[] USACity = {"Miami", "Los Angeles", "New York", "San Francisco"};
    String[] SpainCity = {"Barcelona", "Madrid", "Seville"};
    String[] RussiaCity = {"Moscow", "St. Petersburg"};
    String[][] cities = {AustraliaCity, GermanyCity, FranceCity, ItalyCity,
            USACity, SpainCity, RussiaCity };
    int[] countryFlags = {
            R.drawable.flag_australia,
            R.drawable.flag_germany ,
            R.drawable.flag_france,
            R.drawable.flag_italy,
            R.drawable.flag_us,
            R.drawable.flag_spain,
            R.drawable.flag_russia
    };
    int[] australiaCityImages = {
            R.drawable.brisbane,
            R.drawable.melbourne,
            R.drawable.sydndey};
    int[] germanyCityImages = {
            R.drawable.berlin,
            R.drawable.munich,
            R.drawable.frankfurt
    };
    int[] franceCityImages = {
            R.drawable.monaco,
            R.drawable.paris
    };
    int[] italyCityImages = {
            R.drawable.naples,
            R.drawable.milan,
            R.drawable.rome
    };
    int[] USACityImage = {
            R.drawable.miami,
            R.drawable.la,
            R.drawable.nyc,
            R.drawable.sfo
    };
    int[] spainCityImage = {
            R.drawable.barcelona,
            R.drawable.madrid,
            R.drawable.seville
    };
    int[] russiaCityImage = {
            R.drawable.moscow,
            R.drawable.petersburg
    };

    int[][] cityImages = {
            australiaCityImages,
            germanyCityImages,
            franceCityImages,
            italyCityImages,
            USACityImage,
            spainCityImage,
            russiaCityImage
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);

        fillCountryList();

        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("countryName", countryNames[i]);
                mIntent.putExtra("countryFlag", countryFlags[i]);
                mIntent.putExtra("cityImage", cityImages[i]);
                mIntent.putExtra("Cities", cities[i]);
                startActivity(mIntent);
            }
        });
    }

    private void fillCountryList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Australia", R.drawable.flag_australia));
        countryList.add(new CountryItem("Germany", R.drawable.flag_germany));
        countryList.add(new CountryItem("France", R.drawable.flag_france));
        countryList.add(new CountryItem("Italy", R.drawable.flag_italy));
        countryList.add(new CountryItem("USA", R.drawable.flag_us));
        countryList.add(new CountryItem("Spain", R.drawable.flag_spain));
        countryList.add(new CountryItem("Russia", R.drawable.flag_russia));

    }
}