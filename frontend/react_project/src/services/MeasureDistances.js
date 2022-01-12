import React from 'react';
import { ContentPasteSearchOutlined } from "@mui/icons-material";
import { length } from "@turf/turf";

const MeasureDistances = (props) => {

var distance = 0

    

        const geojson = {
            'type': 'FeatureCollection',
            'features': [
              {
                'type': 'Feature',
                'geometry': {
                  'type': 'LineString',
                  'properties': {},
                  'coordinates':
                    [props.coordinates.start, props.coordinates.end]
                }
              }
            ]
          };
          var line = geojson;
          distance = length(line).toFixed(1);
 


  
    
    return (distance);
  };
  
  export default MeasureDistances;
  