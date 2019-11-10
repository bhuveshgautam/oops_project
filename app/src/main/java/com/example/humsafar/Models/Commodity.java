package com.example.humsafar.Models;

public class Commodity{
    protected String name;
    protected float Quantity;

    public Commodity() {}

    public Commodity(String name, float size){
        this.name = name;
        this.Quantity = size;
    }

    public String getName() { return this.name; }

    public float getQuantity() { return this.Quantity; }
}

