package com.example.humsafar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.humsafar.Models.Commodity;
import com.example.humsafar.Models.Truckinfo;
import com.example.humsafar.Models.personalinfo;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Info extends AppCompatActivity {

    protected static int key;
    protected static ArrayList<personalinfo> farmers = personalinfo.getList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        key = intent.getIntExtra("User", 0);
        final personalinfo farmer = farmers.get(key);
        Context context = getApplicationContext();

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Azadpur", "Mehrauli", "Okhla", "Arya Pura", "Ghanta Ghar", "Manda wali", "Shahdra"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        if(farmer.hasCarriage()){
            EditText txt = (EditText) findViewById(R.id.editText5);
            txt.setFocusable(false);
            txt.setEnabled(false);
            txt.setCursorVisible(false);
            txt.setKeyListener(null);
            txt.setText(Float.toString(farmer.getCapacity()));
            txt.setBackgroundColor(Color.TRANSPARENT);
        }

        TextView textview = (TextView) findViewById(R.id.textView6);
        textview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                farmer.deleteCariage();
                Intent i = new Intent(Info.this, MainActivity.class);
                startActivity(i);
                updatefile("farmers", farmers);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_status){
            Intent intent = new Intent(Info.this, Status.class);
            if(farmers.get(key).hasCarriage())
                intent.putExtra("Destination", farmers.get(key).getCarriage().getDestination());
            startActivity(intent);
        }
        return true;
    }

    public void Submit(View v){
        personalinfo farmer = farmers.get(key);

        EditText txtcrop = (EditText) findViewById(R.id.editText4);
        String cropname = txtcrop.getText().toString();
        EditText txtquantity = (EditText) findViewById(R.id.editText10);
        float quantity = Float.parseFloat(txtquantity.getText().toString());

        Commodity crop = new Commodity(cropname, quantity);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        String destination = spinner.getSelectedItem().toString();

        if(!farmer.hasCarriage()) {
            EditText txtcapacity = (EditText) findViewById(R.id.editText5);
            float capacity = Float.parseFloat(txtcapacity.getText().toString());
            farmer.setCarriage(capacity, destination);
            String s = farmer.fillCarriage(crop);
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, s , Toast.LENGTH_SHORT);
            toast.show();

            txtcapacity.setFocusable(false);
            txtcapacity.setEnabled(false);
            txtcapacity.setCursorVisible(false);
            txtcapacity.setKeyListener(null);
            txtcapacity.setText(Float.toString(farmer.getCapacity()));
            txtcapacity.setBackgroundColor(Color.TRANSPARENT);

            updatefile("farmers", farmers);
        }
        else{
            String s = farmer.fillCarriage(crop);
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, s , Toast.LENGTH_SHORT);
            toast.show();
            updatefile("farmers", farmers);
        }
    }

    public void updatefile(String key, ArrayList<personalinfo> list){
        SharedPreferences sharedpreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

}
