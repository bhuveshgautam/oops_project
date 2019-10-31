package com.example.humsafar.Models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class personalinfo {
    protected int key;
    protected String name;
    protected String phoneno;
    protected String address;
    protected String password;
    protected Truckinfo carriage;

    protected static ArrayList<personalinfo> farmers = new ArrayList<>();

    public static int objectno = 0;

    public personalinfo(String name, String phoneno, String address, String pwd){
        this.name = name;
        this.phoneno = phoneno;
        this.address = address;
        this.password = pwd;
        this.key = objectno;
        this.objectno++;
    }

    public void setCarriage(float capacity, String destination){
        Truckinfo truck = new Truckinfo(capacity, destination);
        this.carriage = truck;
    }

    public String getname(){
        return this.name;
    }

    public String getpassword(){
        return this.password;
    }

    public String getPhoneno() { return this.phoneno; }

    public int getKey() { return this.key; }

    public float getCapacity() { return this.carriage.capacity; }

    public static ArrayList<personalinfo> getList() { return personalinfo.farmers; }

    public boolean hasCarriage() {
        if(this.carriage != null)
            return true;
        else
            return false;
    }

    public Truckinfo getCarriage() { return this.carriage; }

    public String fillCarriage(Commodity c) {
        return this.carriage.fill(c);
    }

    public void deleteCariage() { this.carriage = null; }

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
