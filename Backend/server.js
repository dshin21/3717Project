//npm modules
const fs = require("fs");
const MongoClient = require('mongodb').MongoClient;
//

const url = "mongodb://root:root123@ds223343.mlab.com:23343/comp3717";

// let BUS_STOPS = fs.readFileSync('JSONs/BUS_STOPS.json');
// var rawData = JSON.parse(BUS_STOPS);
// var myobj = [];
// console.log(rawData.features.length);
// for (let i = 0; i < rawData.features.length; i++) {
//     const coordinates = rawData.features[i].geometry.coordinates;
//     const stopName = rawData.features[i].properties.stop_name;
//     myobj[i] = {"name": stopName, "lat": coordinates[0], "lng": coordinates[1]};
// }
//
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("BUS_STOPS").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });


// let FIBER_NETWORK_LOCATIONS = fs.readFileSync('JSONs/FIBER_NETWORK_LOCATIONS.json');
// var rawData = JSON.parse(FIBER_NETWORK_LOCATIONS);
// var myobj = [];
// console.log(rawData.features.length);
// for (let i = 0; i < rawData.features.length; i++) {
//     const coordinates = rawData.features[i].geometry.coordinates;
//     const name = rawData.features[i].properties.NAME;
//     myobj[i] = {"name": name, "lat": coordinates[0], "lng": coordinates[1]};
// }
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("FIBER_NETWORK_LOCATIONS").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });

// let MAJOR_SHOPPING = fs.readFileSync('JSONs/MAJOR_SHOPPING.json');
// var rawData = JSON.parse(MAJOR_SHOPPING);
// var myobj = [];
//
// for (let i = 0; i < rawData.length; i++) {
//     const coordinates = rawData[i].json_geometry.coordinates[0][0];
//     const name = rawData[i].BLDGNAM;
//     myobj[i] = {"name": name, "lat": coordinates[0], "lng": coordinates[1]};
// }
// console.log(myobj);
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("MAJOR_SHOPPING").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });

// let PARKS = fs.readFileSync('JSONs/PARKS.json');
// var rawData = JSON.parse(PARKS);
// var myobj = [];
//
// for (let i = 0; i < rawData.features.length; i++) {
//     const coordinates = rawData.features[i].geometry.coordinates[0][0];
//     const name = rawData.features[i].properties.StrName;
//     myobj[i] = {"name": name, "lat": coordinates[0], "lng": coordinates[1]};
// }
//
// console.log(myobj);
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("PARKS").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });
//

// let RAILWAYS = fs.readFileSync('JSONs/RAILWAYS.json');
// var rawData = JSON.parse(RAILWAYS);
// var myobj = [];
// console.log(rawData.features[0].geometry.coordinates[0]);
//
// for (let i = 0; i < rawData.features.length; i++) {
//     if (rawData.features[i].geometry != null && rawData.features[i].geometry.coordinates[0]) {
//         let coordinates = rawData.features[i].geometry.coordinates[0];
//         myobj[i] = {"lat": coordinates[0], "lng": coordinates[1]};
//     }
// }
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("RAILWAYS").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });

// let SKYTRAIN_STATIONS_PTS = fs.readFileSync('JSONs/SKYTRAIN_STATIONS_PTS.json');
// var rawData = JSON.parse(SKYTRAIN_STATIONS_PTS);
// var myobj = [];
// console.log(rawData.features.length);
// for (let i = 0; i < rawData.features.length; i++) {
//     const coordinates = rawData.features[i].geometry.coordinates;
//     const stopName = rawData.features[i].properties.NAME;
//     myobj[i] = {"name": stopName, "lat": coordinates[0], "lng": coordinates[1]};
// }
//
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("SKYTRAIN_STATIONS_PTS").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });

// let SPORTS_FIELDS = fs.readFileSync('JSONs/SPORTS_FIELDS.json');
// var rawData = JSON.parse(SPORTS_FIELDS);
// var myobj = [];
// console.log(rawData.features.length);
// for (let i = 0; i < rawData.features.length; i++) {
//     const coordinates = rawData.features[i].geometry.coordinates;
//     const stopName = rawData.features[i].properties.PARK;
//     myobj[i] = {"name": stopName, "lat": coordinates[0], "lng": coordinates[1]};
// }
//
//
// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     let dbo = db.db("comp3717");
//
//     dbo.collection("SPORTS_FIELDS").insertMany(myobj, function (err, res) {
//         if (err) throw err;
//         db.close();
//     });
// });