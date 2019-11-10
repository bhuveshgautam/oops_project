package com.example.humsafar.Models;

import java.util.ArrayList;

public class Truckinfo {
    protected float capacity;
    protected float freespace;
    protected ArrayList<Commodity> data;
    protected String destination;

    public Truckinfo() {
        this.data = new ArrayList<Commodity>();
    }

    public Truckinfo(float capacity, String destination){
        this.capacity = capacity;
        this.freespace = capacity;
        this.destination = destination;
        this.data = new ArrayList<Commodity>();
    }

    public String fill(Commodity c){
        if(c.Quantity <= freespace){
            freespace = freespace - c.Quantity;
            data.add(c);
            return "Data added";
        }else
            return "Sorry! Not enough space";
    }

    public String getDestination() { return this.destination; }

    public ArrayList<Commodity> getList() { return this.data; }

    public String getFreeSpace() { return Float.toString(this.freespace); }
}
