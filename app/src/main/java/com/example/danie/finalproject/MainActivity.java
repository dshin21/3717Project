package com.example.danie.finalproject;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.danie.finalproject.Database.DB;
import com.example.danie.finalproject.Database.Entities.BusStop;
import com.example.danie.finalproject.Database.Entities.FiberNetwork;
import com.example.danie.finalproject.Database.Entities.MajorShopping;
import com.example.danie.finalproject.Database.Entities.Park;
import com.example.danie.finalproject.Database.Entities.SkytrainStationPts;
import com.example.danie.finalproject.Database.Entities.SportsFields;

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
            makeFiberNetwork();
            makeMajorShopping();
            makeParks();
            makeSkytrainStationPts();
            makeSportFields();

//            for (int i = 0; i < FiberNetwork.fiberNetworks.size(); ++i) {
//                Log.e("NAME", FiberNetwork.fiberNetworks.get(i).getName());
//                Log.e("LAT", String.valueOf(FiberNetwork.fiberNetworks.get(i).getLat()));
//                Log.e("LAT", String.valueOf(FiberNetwork.fiberNetworks.get(i).getLng()));
//            }

//            for (int i = 0; i < MajorShopping.majorShoppings.size(); ++i) {
//                Log.e("NAME", MajorShopping.majorShoppings.get(i).getName());
//                Log.e("LAT", String.valueOf(MajorShopping.majorShoppings.get(i).getLat()));
//                Log.e("LAT", String.valueOf(MajorShopping.majorShoppings.get(i).getLng()));
//            }
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

        void makeFiberNetwork() {
            DB db = new DB(MainActivity.this);
            List<String> name = db.getName("FIBER_NETWORK");
            List<String> lat = db.getLat("FIBER_NETWORK");
            List<String> lng = db.getLng("FIBER_NETWORK");
            for (int i = 0; i < name.size(); ++i) {
                FiberNetwork.fiberNetworks.add(new FiberNetwork(name.get(i),
                        Double.parseDouble(lat.get(i)),
                        Double.parseDouble(lng.get(i))));
            }
        }

        void makeMajorShopping() {
            DB db = new DB(MainActivity.this);
            List<String> name = db.getName("MAJOR_SHOPPING");
            List<String> lat = db.getLat("MAJOR_SHOPPING");
            List<String> lng = db.getLng("MAJOR_SHOPPING");
            for (int i = 0; i < name.size(); ++i) {
                MajorShopping.majorShoppings.add(new MajorShopping(name.get(i),
                        Double.parseDouble(lat.get(i)),
                        Double.parseDouble(lng.get(i))));
            }
        }

        void makeParks() {
            DB db = new DB(MainActivity.this);
            List<String> name = db.getName("PARKS");
            List<String> lat = db.getLat("PARKS");
            List<String> lng = db.getLng("PARKS");
            for (int i = 0; i < name.size(); ++i) {
                Park.parks.add(new Park(name.get(i),
                        Double.parseDouble(lat.get(i)),
                        Double.parseDouble(lng.get(i))));
            }
        }

        void makeSkytrainStationPts() {
            DB db = new DB(MainActivity.this);
            List<String> name = db.getName("SKYTRAIN_STATIONS_PTS");
            List<String> lat = db.getLat("SKYTRAIN_STATIONS_PTS");
            List<String> lng = db.getLng("SKYTRAIN_STATIONS_PTS");
            for (int i = 0; i < name.size(); ++i) {
                SkytrainStationPts.skytrainStationPts.add(new SkytrainStationPts(name.get(i),
                        Double.parseDouble(lat.get(i)),
                        Double.parseDouble(lng.get(i))));
            }
        }

        void makeSportFields() {
            DB db = new DB(MainActivity.this);
            List<String> name = db.getName("SPORTS_FIELDS");
            List<String> lat = db.getLat("SPORTS_FIELDS");
            List<String> lng = db.getLng("SPORTS_FIELDS");
            for (int i = 0; i < name.size(); ++i) {
                SportsFields.sportsFields.add(new SportsFields(name.get(i),
                        Double.parseDouble(lat.get(i)),
                        Double.parseDouble(lng.get(i))));
            }
        }
    }
}
