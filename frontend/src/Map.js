import React from 'react';
import 'mapbox-gl/dist/mapbox-gl.css';

<link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />


function MyComponent() {
    var mapboxgl = require('mapbox-gl/dist/mapbox-gl.js');

    mapboxgl.accessToken = 'pk.eyJ1Ijoia2Fsb3ByZXNsaSIsImEiOiJja3ZvYnVlN20wbzdrMnZxaDIxY3FtazJkIn0.wK7GJFWgdHCFN9HIWKxjOw';
    var map = new mapboxgl.Map({
      style: 'mapbox://styles/mapbox/streets-v11'
    })}
    
export default React.memo(MyComponent)