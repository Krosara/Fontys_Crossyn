import React, { useRef, useEffect, useState } from 'react';
import { CanvasOverlay } from 'react-map-gl';
import mapboxgl from '!mapbox-gl'; // eslint-disable-line import/no-webpack-loader-syntax
import geojson from 'react-geojson';

//mapboxgl.accessToken = 'pk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3ZvYnVlN20wbzdrMnZxaDIxY3FtazJkIn0.wK7GJFWgdHCFN9HIWKxjOw';

mapboxgl.accessToken =
  'pk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3ZvYnVlN20wbzdrMnZxaDIxY3FtazJkIn0.wK7GJFWgdHCFN9HIWKxjOw';

function Overlay() {
  const geojson = {
    type: 'FeatureCollection',
    features: [
      {
        type: 'Feature',
        geometry: {
          type: 'LineString',
          properties: {},
          coordinates: [
            [-77.0366048812866, 38.89873175227713],
            [-77.03364372253417, 38.89876515143842],
            [-77.03364372253417, 38.89549195896866],
            [-77.02982425689697, 38.89549195896866],
            [-77.02400922775269, 38.89387200688839],
            [-77.01519012451172, 38.891416957534204],
            [-77.01521158218382, 38.892068305429156],
            [-77.00813055038452, 38.892051604275686],
            [-77.00832366943358, 38.89143365883688],
            [-77.00818419456482, 38.89082405874451],
            [-77.00815200805664, 38.88989712255097],
          ],
        },
      },
    ],
  };

  const mapContainer = useRef(null);
  const map = useRef(null);
  const [lng, setLng] = useState(-70.9);
  const [lat, setLat] = useState(42.35);
  const [zoom, setZoom] = useState(9);

  useEffect(() => {
    if (map.current) return; // initialize map only once
    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [-77.01521158218382, 38.892068305429156],
      zoom: zoom,
    });
  });

  useEffect(() => {
    if (!map.current) return; // wait for map to initialize
    map.current.on('move', () => {
      setLng(map.current.getCenter().lng.toFixed(4));
      setLat(map.current.getCenter().lat.toFixed(4));
      setZoom(map.current.getZoom().toFixed(2));
    });
  });

  useEffect(() => {
    if (!map.current) return;
    map.current.on('load', () => {
      map.current.addSource('LineString', {
        type: 'geojson',
        data: geojson,
      });
      map.current.addLayer({
        id: 'LineString',
        type: 'line',
        source: 'LineString',
        layout: {
          'line-join': 'round',
          'line-cap': 'round',
        },
        paint: {
          'line-color': '#BF93E4',
          'line-width': 5,
        },
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

export default Overlay;
