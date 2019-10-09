package com.example.humsafar.Models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class personalinfo {
    protected String name;
    protected String phoneno;
    protected String address;
    protected String password;

    public static ArrayList<personalinfo> farmers = new ArrayList<>();

    public personalinfo(String name, String phoneno, String address, String pwd){
        this.name = name;
        this.phoneno = phoneno;
        this.address = address;
        this.password = pwd;
    }

    public String getname(){
        return this.name;
    }

    public String getpassword(){
        return this.password;
    }

    public static void registerUser(personalinfo user){
        farmers.add(user);
    }

    public static void loadData(Context context, String key){
        SharedPreferences sharedpreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedpreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<personalinfo>>(){}.getType();
        farmers = gson.fromJson(json, type);
        if(farmers == null)
            farmers = new ArrayList<>();
    }
}
