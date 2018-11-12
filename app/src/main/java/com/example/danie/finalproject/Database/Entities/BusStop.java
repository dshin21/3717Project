package com.example.danie.finalproject.Database.Entities;

import java.util.ArrayList;

public class BusStop {
    public static ArrayList<BusStop> busStops = new ArrayList<>();

    private String name;
    private double lat;
    private double lng;

    public BusStop(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
