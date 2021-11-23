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
        axios.get('http://localhost:3000/api/vehicles')
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
                    {/* <h3>Week 22 Avg: {marsInfo.temperature}°C</h3> */}
                    <h2>Location: 5761BW Bakel, Van de Poelstraat<br/> Last Used: 24/11/2021<br/><br/>Average Score: 🌟🌟🌟🌟⭐ <br/> Distance Driven: 1102.2 km <br/></h2>
                    {/* {tripInfo.map(info => <h2>SOL {info.dayID}<br/>{info.time }<br/><br/>{info.temperature}°C <br/> Humidity: {info.humidity}% <br/></h2>)} */}
            </div>      
        )
    }
}
export default TripCon;