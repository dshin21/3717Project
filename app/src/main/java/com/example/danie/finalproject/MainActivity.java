package com.example.danie.finalproject;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.danie.finalproject.Database.DB;
import com.example.danie.finalproject.Database.Entities.BusStop;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteOpenHelper helper = new DB(this);


    }
}
