package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addData(){

    }

    public void getData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        long phoneno = intent.getLongExtra("phoneno", 0);
        String ans = intent.getStringExtra("address");
    }
}
