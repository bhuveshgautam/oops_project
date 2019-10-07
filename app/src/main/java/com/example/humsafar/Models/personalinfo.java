package com.example.humsafar.Models;

public class personalinfo {
    protected String name;
    protected String phoneno;
    protected String address;
    protected String password;

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
}
