import React, { PureComponent } from 'react'
import { CanvasOverlay } from 'react-map-gl'
export default function Overlay() {
    mapboxgl.accessToken = 'pk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3ZvYnVlN20wbzdrMnZxaDIxY3FtazJkIn0.wK7GJFWgdHCFN9HIWKxjOw';
    // A GeoJSON object with a LineString route from the White House to Capitol Hill
    var coord = [
      [4.77152, 51.59152],
      [4.77142, 51.5916]
    ];
    const geojson = {
      'type': 'FeatureCollection',
      'features': [
        {
          'type': 'Feature',
          'geometry': {
            'type': 'LineString',
            'properties': {},
            'coordinates': coord
          }
        }
      ]
    };

    const map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/mapbox/light-v10',
      center: [4.77152, 51.59152],
      zoom: 12
    });

    map.on('load', () => {
      map.addSource('LineString', {
        'type': 'geojson',
        'data': geojson
      });
      map.addLayer({
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

      document.getElementById('zoomto').addEventListener('click', () => {
        // Geographic coordinates of the LineString
        const coordinates = geojson.features[0].geometry.coordinates;

        // Create a 'LngLatBounds' with both corners at the first coordinate.
        const bounds = new mapboxgl.LngLatBounds(
          coordinates[0],
          coordinates[0]
        );

        // Extend the 'LngLatBounds' to include every coordinate in the bounds result.
        for (const coord of coordinates) {
          bounds.extend(coord);
        }

        map.fitBounds(bounds, {
          padding: 20
        });
      });
    });
}
ReactDOM.render(e(Overlay), domContainer);
