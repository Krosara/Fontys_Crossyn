package fontys.crossyn.controller;


import com.google.gson.JsonArray;
import fontys.crossyn.dto.TripDTO;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.JSONReader;
import fontys.crossyn.service.TripCreator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin("http://localhost:3000/")
public class TripController {

    @Autowired
    private ModelMapper modelMapper;

    private final TripCreator tripCreator;

    public TripController(TripCreator tripCreator) {
        this.tripCreator = tripCreator;
    }

    @GetMapping
    public List<TripDTO> getAllTrips(){
        //return tripCreator.GetTrips().stream().map(trip -> modelMapper.map(trip, TripDTO.class)).toList();
        return null;
    }

    @PostMapping
    public void CreateTrips(@RequestBody JsonArray jsonArray){

        JSONReader reader = new JSONReader();

        ArrayList<Packet> packetList = reader.readJson(jsonArray);
        tripCreator.createTrips(packetList);
    }


}
