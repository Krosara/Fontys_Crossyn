import React from 'react';
import { ContentPasteSearchOutlined } from '@mui/icons-material';
import * as turf from '@turf/turf';

const MeasureDistances = (start, end) => {
  const geojson = {
    type: 'FeatureCollection',
    features: [
      {
        type: 'Feature',
        geometry: {
          type: 'LineString',
          properties: {},
          coordinates: {
            start: { start },
            end: { end },
          },
        },
      },
    ],
  };
  // var tempS = typeof JSON.stringify(start[0]);
  var from = turf.point([parseFloat(start[0]), parseFloat(start[1])]);
  var to = turf.point([parseFloat(end[0]), parseFloat(end[1])]);
  var options = { units: 'kilometers' };
  var distance = turf.distance(from, to, options).toFixed(1);
  // console.log(distance);
  return distance;
};

export { MeasureDistances };
