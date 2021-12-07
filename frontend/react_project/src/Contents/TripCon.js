import React from 'react';
import axios from 'axios';

class TripCon extends React.Component
{


    constructor(props){
        super(props)

        this.state = {
            tripInfo: []
        }
    }
    

    componentDidMount(){
        axios.get('http://localhost:8080/api/trips/GetAll')
        .then(response => {
            this.setState({
                tripInfo: response.data
            })
            console.log(response.data)
        })
    }

    render()
    {
        const tripInfo = this.state.tripInfo
        return(
            <div className="VehicleInfo">
                    <h1>Trip Info</h1>
                    {tripInfo.map(info => <h2>Vehicle ID: {info.vehicleID}<br/><br/>Start Time: {info.startTime} <br/>End Time: {info.endTime}<br/><br/>ID: {info._id}</h2>)}
            </div>      
        )
    }
}
export default TripCon;