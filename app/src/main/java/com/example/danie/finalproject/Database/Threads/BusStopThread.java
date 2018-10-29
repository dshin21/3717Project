package com.example.danie.finalproject.Database.Threads;

import android.os.AsyncTask;

import com.example.danie.finalproject.Database.BusStop;
import com.example.danie.finalproject.Database.BusStops;
import com.example.danie.finalproject.Database.Utils.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusStopThread {

    public class GetBusStops extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr;
            jsonStr = sh.makeServiceCall("https://api.mlab.com/api/1/databases/comp3717/collections/BUS_STOPS?apiKey=Q3kcLrAb4liR46OZJ46LzwhScsXPYvLn");

            if (jsonStr != null) {
                try {
                    JSONArray countriesJSONArray = new JSONArray(jsonStr);
                    for (int i = 0; i < countriesJSONArray.length(); i++) {
                        JSONObject c = countriesJSONArray.getJSONObject(i);
                        String name = c.getString("name");
                        String lat = c.getString("lat");
                        String lng = c.getString("lng");
                        BusStop busStop = new BusStop(name, Double.parseDouble(lat), Double.parseDouble(lng));
                        BusStops.busStops.add(busStop);
                    }
                } catch (final JSONException e) {
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            BusStops.isReady = true;
        }
    }
}
