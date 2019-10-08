package com.example.humsafar.Models;

import java.util.ArrayList;

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
}
