package com.example.danie.finalproject;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.danie.finalproject.Database.DB;
import com.example.danie.finalproject.Database.Entities.BusStop;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new initDB().execute();
    }

    public class initDB extends AsyncTask<Void, Void, Void> {
        public initDB() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            SQLiteOpenHelper helper = new DB(MainActivity.this);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            makeBusStops();
        }

        void makeBusStops() {
            DB db = new DB(MainActivity.this);
            List<String> name = db.getName("BUS_STOPS");
            List<String> lat = db.getLat("BUS_STOPS");
            List<String> lng = db.getLng("BUS_STOPS");
            for (int i = 0; i < name.size(); ++i) {
                BusStop.busStops.add(new BusStop(name.get(i),
                        Double.parseDouble(lat.get(i)),
                        Double.parseDouble(lng.get(i))));
            }
        }
    }
}
