package com.example.danie.finalproject.Database.Threads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.danie.finalproject.Database.DB;
import com.example.danie.finalproject.Database.Utils.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetSkytrainStationPts extends AsyncTask<Void, Void, Void> {
    private SQLiteDatabase db;

    public GetSkytrainStationPts(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        HttpHandler sh = new HttpHandler();
        String jsonStr;
        jsonStr = sh.makeServiceCall("https://api.mlab.com/api/1/databases/comp3717/collections/SKYTRAIN_STATIONS_PTS?apiKey=Q3kcLrAb4liR46OZJ46LzwhScsXPYvLn");

        if (jsonStr != null) {
            try {
                JSONArray countriesJSONArray = new JSONArray(jsonStr);
                for (int i = 0; i < countriesJSONArray.length(); i++) {
                    JSONObject c = countriesJSONArray.getJSONObject(i);
                    ContentValues values = new ContentValues();
                    values.put("NAME", c.getString("name"));
                    values.put("LAT", c.getString("lat"));
                    values.put("LNG", c.getString("lng"));
                    long id = db.insert("SKYTRAIN_STATIONS_PTS", null, values);
                }
            } catch (final JSONException e) {
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // make objects?
        super.onPostExecute(result);
        db.execSQL("DROP TABLE IF EXISTS SPORTS_FIELDS");
        db.execSQL(DB.createTableSPORTS_FIELDS());
        new GetSportsFields(db).execute();
    }
}