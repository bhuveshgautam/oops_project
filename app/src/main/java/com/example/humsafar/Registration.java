package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.humsafar.Models.personalinfo;

import java.util.ArrayList;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void Register(View view){

        EditText txtname = findViewById(R.id.editText2);
        EditText txtpwd = findViewById(R.id.editText7);
        EditText txtadd = findViewById(R.id.editText5);
        EditText txtphone = findViewById(R.id.editText6);

        String name = txtname.getText().toString();
        String pwd = txtpwd.getText().toString();
        String add = txtadd.getText().toString();
        String phone = txtphone.getText().toString();

        personalinfo farmer = new personalinfo(name, phone, add, pwd);
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Registered", Toast.LENGTH_SHORT);
        toast.show();

        personalinfo.registerUser(farmer);
    }

}
