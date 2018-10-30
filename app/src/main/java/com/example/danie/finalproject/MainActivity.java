package com.example.danie.finalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.danie.finalproject.Database.Entities.BusStops;
import com.example.danie.finalproject.Database.DB;
import com.example.danie.finalproject.Database.Entities.FiberNetworkLocations;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DB();
    }

    @SuppressLint("HandlerLeak")
    public static Handler myHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.getData().getInt("STATUS")) {
                case 1:
                    Log.e("BusStop", "DONE");
                    BusStops.isReady = true;
                    break;
                case 2:
                    Log.e("FiberNetworkLocation", "DONE");
                    FiberNetworkLocations.isReady = true;
                    break;
            }
        }
    };
}
