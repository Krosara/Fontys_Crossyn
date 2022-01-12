package fontys.crossyn.controller;


import com.google.gson.JsonArray;
import fontys.crossyn.dto.TripDTO;
import fontys.crossyn.exception.ApiRequestException;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.JSONReader;
import fontys.crossyn.service.TripCreator;
import fontys.crossyn.service.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin("http://localhost:3000/")
public class TripController {

    @Autowired
    private ModelMapper modelMapper;

    private final TripService tripService;

    public TripController(TripService tripCreator) {
        this.tripService = tripCreator;
    }


    @GetMapping("/GetAll")
    public ResponseEntity<List<TripDTO>>  getAllTrips(){
        try{
            List<TripDTO> trips = tripService.GetTrips().stream().map(trip -> modelMapper.map(trip, TripDTO.class)).collect(Collectors.toList());

            return new ResponseEntity<>(trips, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ApiRequestException("Cant get all Trips");
        }


    }

    @PostMapping("/CreateTrips")
    public void CreateTrips(){

        try{
            JSONReader reader = new JSONReader();

            ArrayList<Packet> packetList = reader.readJsonFile();

            tripService.CreateTrips(packetList);
        }
        catch (Exception e){
            throw new ApiRequestException("Cant create trips");
        }


    }

    @DeleteMapping("/Delete")
    public void DeleteTrip(@RequestBody String tripId){

        try{
            throw new ApiRequestException("Cant create trips");

        }
        catch (Exception e){
            throw new ApiRequestException("Cant create trips");
            //tripService.DeleteTrip(tripId);
        }


    }
}
