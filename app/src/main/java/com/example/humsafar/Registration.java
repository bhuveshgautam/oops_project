package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.humsafar.Models.personalinfo;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    protected static ArrayList<personalinfo> farmers = personalinfo.getList();

    public void Register(View view){

        EditText txtname = findViewById(R.id.editText2);
        EditText txtpwd = findViewById(R.id.editText6);
        EditText txtadd = findViewById(R.id.editText5);
        EditText txtphone = findViewById(R.id.editText8);

        String name = txtname.getText().toString();
        String pwd = txtpwd.getText().toString();
        String add = txtadd.getText().toString();
        String phone = txtphone.getText().toString();

        int flag = 0;
        for(personalinfo farmer: farmers){
            if(farmer.getPhoneno().equals(phone)){
                flag++;
                break;
            }
        }
        if(flag == 0){
            personalinfo farmer = new personalinfo(name, phone, add, pwd);
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Registered", Toast.LENGTH_SHORT);
            toast.show();

            personalinfo.registerUser(farmer);

            updatefile("farmers", farmers);
            Intent intent = new Intent(Registration.this, Info.class);
            intent.putExtra("User", farmer.getKey());
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Duplicte", Toast.LENGTH_SHORT).show();
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
