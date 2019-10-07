package com.example.humsafar.Models;

public class personalinfo {
    public String name;
    protected long phoneno;
    protected String address;
    public String password;

    public personalinfo(String name, long phoneno, String address, String pwd){
        this.name = name;
        this.phoneno = phoneno;
        this.address = address;
        this.password = pwd;
    }
}
