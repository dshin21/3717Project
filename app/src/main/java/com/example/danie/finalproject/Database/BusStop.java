package com.example.danie.finalproject.Database;

import java.util.ArrayList;
import java.util.List;

public class BusStop {
    private String busStopName;
    private double lat;
    private double lng;

    public BusStop( String busStopName, double lat, double lng ) {
        this.busStopName = busStopName;
        this.lat = lat;
        this.lng = lng;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName( String busStopName ) {
        this.busStopName = busStopName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat( double lat ) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng( double lng ) {
        this.lng = lng;
    }
}