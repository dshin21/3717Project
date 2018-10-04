const fs = require("fs");
const MongoClient = require('mongodb').MongoClient;


let BUS_STOPS = fs.readFileSync('JSONs/BUS_STOPS.json');
let rawData = JSON.parse(BUS_STOPS);

let myobj = [];

for (let i = 0; i < rawData.features.length; i++) {
    const coordinates = rawData.features[i].geometry.coordinates;
    const stopName = rawData.features[i].properties.stop_name;
    myobj[i] = {"stopName": stopName, "lat": coordinates[0], "lng": coordinates[1]};
}


const url = "mongodb://localhost:27017/";

MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("test");

    dbo.collection("Bus_Stops").insertMany(myobj, function (err, res) {
        if (err) throw err;
        db.close();
    });
});