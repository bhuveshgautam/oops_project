package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Azadpur", "Mehrauli", "Okhla", "Arya Pura", "Ghanta Ghar", "Manda wali", "Shahdra"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Switch sw = (Switch) findViewById(R.id.switch1);
        final EditText e = (EditText) findViewById(R.id.editText5);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    e.setVisibility(View.VISIBLE);
                }else
                    e.setVisibility(View.GONE);
            }
        });
    }


}
