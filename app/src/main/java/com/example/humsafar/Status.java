package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.humsafar.Models.personalinfo;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.ArrayList;

public class Status extends AppCompatActivity {

    ListView listview;
    protected static ArrayList<personalinfo> farmers = personalinfo.getList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Intent intent = getIntent();
        String destination = intent.getStringExtra("Destination");

        listview = (ListView) findViewById(R.id.listview);
        ArrayList<personalinfo> list = new ArrayList<>();
        for(personalinfo farmer : farmers){
            if(farmer.hasCarriage() && farmer.getCarriage().getDestination().equals(destination)){
                list.add(farmer);
            }
        }
        CustomAdapter adapter = new CustomAdapter(list, getApplicationContext());

        listview.setAdapter(adapter);

    }
}
