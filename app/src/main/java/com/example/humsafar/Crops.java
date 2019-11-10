package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.humsafar.Models.Commodity;
import com.example.humsafar.Models.personalinfo;

import java.util.ArrayList;
import java.util.HashMap;

public class Crops extends AppCompatActivity {

    static ArrayList<personalinfo> farmers = personalinfo.getList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops);

        ListView listView = (ListView) findViewById(R.id.listview2);

        Intent intent = getIntent();
        int key = intent.getIntExtra("Key", -1);

        ArrayList<Commodity> crops = farmers.get(key).getCarriage().getList();

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for(Commodity c : crops ){
            HashMap<String, String> map = new HashMap<>();
            map.put("Name", c.getName());
            map.put("Quantity", Float.toString(c.getQuantity()) + " Kgs");
            list.add(map);
        }
        String[] from = {"Name", "Quantity"};
        int[] to = {R.id.cropname, R.id.cropqty};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.crop_list, from, to);
        listView.setAdapter(simpleAdapter);

        TextView textView = (TextView) findViewById(R.id.place);
        textView.append(farmers.get(key).getCarriage().getFreeSpace() + " Kgs left");

    }
}
