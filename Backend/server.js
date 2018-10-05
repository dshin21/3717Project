//npm modules
const fs = require("fs");
const MongoClient = require('mongodb').MongoClient;
//

// const url = "mongodb://localhost:27017/";
const url = "mongodb://admin:admin123@ds223343.mlab.com:23343/comp3717";


let BUS_STOPS = fs.readFileSync('JSONs/BUS_STOPS.json');
let rawData = JSON.parse(BUS_STOPS);
let myobj = [];

for (let i = 0; i < rawData.features.length; i++) {
    const coordinates = rawData.features[i].geometry.coordinates;
    const stopName = rawData.features[i].properties.stop_name;
    myobj[i] = {"stopName": stopName, "lat": coordinates[0], "lng": coordinates[1]};
}

let data = JSON.stringify(myobj);
fs.writeFileSync('bus_stops.json', data);


// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("Bus_Stops").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });

//TODO: do the rest of the API calls