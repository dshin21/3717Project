package com.example.danie.finalproject.Database;

import com.example.danie.finalproject.Database.Threads.BusStopThread;
import com.example.danie.finalproject.Database.Threads.FiberNetworkLocationThread;


public class DB {

    public DB() {
        BusStopThread busStopThread = new BusStopThread();
        busStopThread.new GetBusStops().execute();

        FiberNetworkLocationThread fiberNetworkLocationThread = new FiberNetworkLocationThread();
        fiberNetworkLocationThread.new GetFiberNetWorkLocations().execute();
    }

}
