package com.bebektakvimi.ahmetmatematikci.adaptersnflar;

import android.app.ListActivity;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spnCountries;
    private ListView lstCities;


    private void init() {
        spnCountries = (Spinner)findViewById(R.id.spnCountries);
        lstCities = (ListView)findViewById(R.id.lstCities);

    }

    private void SpnCountries_Selection() {
        spnCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = spnCountries.getItemAtPosition(position).toString();
                MainActivity.this.setTitle(selection);
               Binding(getCities(selection), lstCities);
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private ArrayList<String> getCities(String country) {
        ArrayList<String> cities  = new ArrayList<>();
        switch (country) {
            case "Türkiye":
                cities.add("Ankara");
                cities.add("izimir");
                cities.add("istanbul");
                break;
            case "KKTC":
                cities.add("a");
                cities.add("ab");
                cities.add("acf");
                break;
            case "Almanya":
                cities.add("ww");
                cities.add("wwwww");
                cities.add("wwwwwww");
                break;
        }
        return cities;

    }

    private void Binding(ArrayList<String> data, ListView lst) {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, data);

        lst.setAdapter(adp);
    }

    private void registerHandlers() {
        SpnCountries_Selection();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerHandlers();
    }
}
