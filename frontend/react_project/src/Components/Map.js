import React, { useRef, useEffect, useState } from 'react';
import axios from 'axios';
import mapboxgl from 'mapbox-gl';
import './Map.css'

mapboxgl.accessToken = 'pk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3ZvYnVlN20wbzdrMnZxaDIxY3FtazJkIn0.wK7GJFWgdHCFN9HIWKxjOw';

const baseURL = 'http://localhost:8080/api/trips/GetAll';

function Map() {

  const [tripId, setTripId] = React.useState([]);
  var tripLoc = [];

  //const [tripId, setTripId] = React.useState([]);




  const geojson = {
    'type': 'FeatureCollection',
    'features': [
      {
        'type': 'Feature',
        'geometry': {
          'type': 'LineString',
          'properties': {},
          'coordinates':
            tripLoc
        }
      }
    ]
  };


  const mapContainer = useRef(null);
  const map = useRef(null);
  const [lng, setLng] = useState(-70.9);
  const [lat, setLat] = useState(42.35);
  const [zoom, setZoom] = useState(9);

  React.useEffect(() => {
    axios.get(baseURL).then((response) => {
      //for (var i = 0; i < response.data.length; i++) {
        const data = response.data[4];
        data.packets.forEach((element) => tripLoc.push([element.location.lon, element.location.lat]));
        console.log(tripLoc);
      //}

    })
  }, [])

  useEffect(() => {
    if (map.current) return;
    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [5.6, 52],
      zoom: 7.65
    });

    if (!map.current) return;
    map.current.on('move', () => {
      setLng(map.current.getCenter().lng.toFixed(4));
      setLat(map.current.getCenter().lat.toFixed(4));
      setZoom(map.current.getZoom().toFixed(2));


    });

    if (!map.current) return;
    map.current.on('load', () => {
      map.current.addSource('LineString', {
        'type': 'geojson',
        'data': geojson
      });
      map.current.addLayer({
        'id': 'LineString',
        'type': 'line',
        'source': 'LineString',
        'layout': {
          'line-join': 'round',
          'line-cap': 'round'
        },
        'paint': {
          'line-color': '#BF93E4',
          'line-width': 5
        }
      });
    });
  });
  return (
    <div>
      <div className="sidebar">
        Longitude: {lng} | Latitude: {lat} | Zoom: {zoom}
      </div>
      <div ref={mapContainer} className="map-container" />
    </div>
  );


  /* useEffect(() => {
     if (map.current) return; // initialize map only once
     map.current = new mapboxgl.Map({
       container: mapContainer.current,
       style: 'mapbox://styles/mapbox/streets-v11',
       center: [lng, lat],
       zoom: zoom
     });
   });*/

}

export default Map