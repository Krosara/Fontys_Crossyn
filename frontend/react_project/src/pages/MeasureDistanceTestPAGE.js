import React from 'react';
import MeasureDistance from '../services/MeasureDistances'

const MeasureDistanceTestPAGE = () => {

  const coordinates = {start: [4.899834, 52.378481], end: [23.317887,42.698438]}

  return <div>
    <MeasureDistance coordinates={coordinates}/>

  </div>;
};

export default MeasureDistanceTestPAGE;
