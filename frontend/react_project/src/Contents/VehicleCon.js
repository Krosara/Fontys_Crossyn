import React from 'react';
import axios from 'axios';

class VehicleCon extends React.Component
{
    constructor(props)
    {
        super(props)

        this.state = {
            vehicleInfo: []
        }
    }


    
    componentDidMount()
    {
        axios.get('http://localhost:3000/api/vehicles')
        .then(response => {
            this.setState({
                vehicleInfo: response.data
            })
            console.log(response.data)  
        })   

    }

    render()
    {
        const {vehicleInfo} = this.state.vehicleInfo
        
        return(    
            <div class="NeoInfo">
                <h1>Vehicle(s) Info</h1>
                <h2>Owner: AJW Rutjens<br/> Driven: 50210 km<br/><br/>Average Performance Score: 🌟🌟🌟⭐⭐ <br/> Last Seen: 5761BW Bakel, Van de Poelstraat <br/></h2>

                    {/* {vehicleInfo.map(info => <h2>Name: {info.name} <br/> Orbiting: {info.close_approach_data.orbiting_body} <br/><br/> Observation Date: {info.orbital_data.first_observation_date} 
                    <br/>Diameter Min: {info.estimated_diameter.meters.estimated_diameter_min} meters <br/>Diamter Max: {info.estimated_diameter.meters.estimated_diameter_max} meters
                    <br/> Hazardous?: {info.is_potentially_hazardous_asteroid.toString()}  <br/><br/> Close approach date: {info.close_approach_data.close_approach_date_full} 
                    <br/><br/><div className="ClickBox"><a href={info.nasa_jpl_url}>NASA Lookup</a><br/><a href="/findobject">Detailed Report</a><br/><a href="">Track Object</a></div></h2>)} */}
            </div>
        )
    }
}
export default VehicleCon;