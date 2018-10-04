package com.example.danie.finalproject.Database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public BusStops BUSSTOPS;

    public DB() {
        MongoClient mongoClient = MongoClients.create( "mongodb://localhost:27017" );
        MongoDatabase db = mongoClient.getDatabase( "test" );
        MongoCollection<Document> collection = db.getCollection( "Bus_Stops" );
        List<Document> documents = collection.find().into( new ArrayList<Document>() );

        BUSSTOPS = new BusStops( new ArrayList<BusStop>() );
        makeObjects( documents, BUSSTOPS.busStops );
    }

    private <T> void makeObjects( List<Document> documents, ArrayList<T> list ) {
        for ( Document document : documents ) {
            list.add( (T) convertBusStop( document ) );
        }
    }

    private BusStop convertBusStop( Document document ) {
        String busStopName = document.get( "stopName" ).toString();
        double lat = Double.parseDouble( document.get( "lat" ).toString() );
        double lng = Double.parseDouble( document.get( "lng" ).toString() );
        return new BusStop( busStopName, lat, lng );
    }

    public static void main( String[] args ) {
        DB db = new DB();
        for ( int i = 0; i < db.BUSSTOPS.busStops.size(); i++ ) {
            System.out.println( db.BUSSTOPS.busStops.get( i ).getBusStopName() );
            System.out.println( db.BUSSTOPS.busStops.get( i ).getLat() );
            System.out.println( db.BUSSTOPS.busStops.get( i ).getLng() );
        }


    }
}
