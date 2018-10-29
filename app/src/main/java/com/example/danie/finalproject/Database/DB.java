package com.example.danie.finalproject.Database;

import com.example.danie.finalproject.Database.Threads.BusStopThread;

public class DB {

    public DB() {
        BusStopThread busStopThread = new BusStopThread();
        busStopThread.new GetBusStops().execute();
    }
}
