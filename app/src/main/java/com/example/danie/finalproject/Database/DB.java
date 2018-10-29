package com.example.danie.finalproject.Database;

import android.os.AsyncTask;

public class DB {
    public BusStops BUSSTOPS;

    public DB() {
        new getJSONObject().execute();
    }

    public class getJSONObject extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr;
            jsonStr = sh.makeServiceCall("https://api.mlab.com/api/1/databases/comp3717/collections/Bus_Stops?apiKey=Q3kcLrAb4liR46OZJ46LzwhScsXPYvLn");


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}
