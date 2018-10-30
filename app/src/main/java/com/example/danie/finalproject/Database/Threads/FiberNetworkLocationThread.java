package com.example.danie.finalproject.Database.Threads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;

import com.example.danie.finalproject.Database.Entities.FiberNetworkLocation;
import com.example.danie.finalproject.Database.Entities.FiberNetworkLocations;
import com.example.danie.finalproject.Database.Utils.HttpHandler;
import com.example.danie.finalproject.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FiberNetworkLocationThread {
    public class GetFiberNetWorkLocations extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr;
            jsonStr = sh.makeServiceCall("https://api.mlab.com/api/1/databases/comp3717/collections/FIBER_NETWORK_LOCATIONS ?apiKey=Q3kcLrAb4liR46OZJ46LzwhScsXPYvLn");

            if (jsonStr != null) {
                try {
                    JSONArray countriesJSONArray = new JSONArray(jsonStr);
                    for (int i = 0; i < countriesJSONArray.length(); i++) {
                        JSONObject c = countriesJSONArray.getJSONObject(i);
                        String name = c.getString("name");
                        String lat = c.getString("lat");
                        String lng = c.getString("lng");
                        FiberNetworkLocation fiberNetworkLocations = new FiberNetworkLocation(name, Double.parseDouble(lat), Double.parseDouble(lng));
                        FiberNetworkLocations.fiberNetworkLocations.add(fiberNetworkLocations);
                    }
                } catch (final JSONException e) {
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Message msg = MainActivity.myHandler.obtainMessage();
            Bundle bundle = new Bundle();

            bundle.putInt("STATUS", 2);
            msg.setData(bundle);
            MainActivity.myHandler.sendMessage(msg);
        }
    }
}
