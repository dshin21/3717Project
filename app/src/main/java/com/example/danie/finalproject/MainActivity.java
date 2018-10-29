package com.example.danie.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.danie.finalproject.Database.BusStop;
import com.example.danie.finalproject.Database.BusStops;
import com.example.danie.finalproject.Database.DB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DB();

        while (BusStops.isReady) {
            for (BusStop i : BusStops.busStops) System.out.println(i.getName());
            break;
        }
    }
}
