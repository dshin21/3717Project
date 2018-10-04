package com.example.danie.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.danie.finalproject.Database.DB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        DB db = new DB();
        for ( int i = 0; i < db.BUSSTOPS.busStops.size(); i++ ) {
            System.out.println( db.BUSSTOPS.busStops.get( i ).getBusStopName() );
            System.out.println( db.BUSSTOPS.busStops.get( i ).getLat() );
            System.out.println( db.BUSSTOPS.busStops.get( i ).getLng() );
        }
    }
}
