package com.example.danie.finalproject.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import com.example.danie.finalproject.Database.Threads.GetBusStops;
import com.example.danie.finalproject.Database.Threads.GetParks;

public class DB extends SQLiteOpenHelper {
    private static final String DB_NAME = "COMP3717.sqlite";
    private static final int DB_VERSION = 1;
    private Context context;
    private SQLiteDatabase db;

    public DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        new initDB().execute();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static String createTableBUS_STOPS() {
        String sql = "";
        sql += "CREATE TABLE BUS_STOPS (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "NAME TEXT, ";
        sql += "LAT TEXT, ";
        sql += "LNG TEXT ";
        sql += ");";

        return sql;
    }

    public static String createTableFIBER_NETWORK() {
        String sql = "";
        sql += "CREATE TABLE FIBER_NETWORK (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "NAME TEXT, ";
        sql += "LAT TEXT, ";
        sql += "LNG TEXT ";
        sql += ");";

        return sql;
    }

    public static String createTableMAJOR_SHOPPING() {
        String sql = "";
        sql += "CREATE TABLE MAJOR_SHOPPING (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "NAME TEXT, ";
        sql += "LAT TEXT, ";
        sql += "LNG TEXT ";
        sql += ");";

        return sql;
    }

    public static String createTablePARKS() {
        String sql = "";
        sql += "CREATE TABLE PARKS (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "NAME TEXT, ";
        sql += "LAT TEXT, ";
        sql += "LNG TEXT ";
        sql += ");";

        return sql;
    }

    public static String createTableSKYTRAIN_STATIONS_PTS() {
        String sql = "";
        sql += "CREATE TABLE SKYTRAIN_STATIONS_PTS (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "NAME TEXT, ";
        sql += "LAT TEXT, ";
        sql += "LNG TEXT ";
        sql += ");";

        return sql;
    }

    public static String createTableSPORTS_FIELDS() {
        String sql = "";
        sql += "CREATE TABLE SPORTS_FIELDS (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "NAME TEXT, ";
        sql += "LAT TEXT, ";
        sql += "LNG TEXT ";
        sql += ");";

        return sql;
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
            //BUS_STOPS -> FIBER_NETWORK -> MAJOR_SHOPPING
            //PARKS -> SKYTRAIN_STATIONS_PTS -> SPORTS_FIELDS

            db.execSQL("DROP TABLE IF EXISTS BUS_STOPS");
            db.execSQL(createTableBUS_STOPS());
            new GetBusStops(db).execute();

            db.execSQL("DROP TABLE IF EXISTS PARKS");
            db.execSQL(DB.createTablePARKS());
            new GetParks(db).execute();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}
