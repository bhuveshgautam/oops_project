package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.humsafar.Models.personalinfo;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import org.w3c.dom.Text;

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
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                personalinfo user = farmers.get(i);
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, user.getCarriage().getFreeSpace() + " Kgs left!", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(Status.this, Crops.class);
                intent.putExtra("Key", i);
                startActivity(intent);
            }
        });

        TextView textView = (TextView) findViewById(R.id.place);
        textView.append(destination);
    }
}
