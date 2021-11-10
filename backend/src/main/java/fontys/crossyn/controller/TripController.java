package fontys.crossyn.controller;


import com.google.gson.JsonArray;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.service.JSONReader;
import fontys.crossyn.service.TripCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    @Autowired
    TripCreator tripCreator;

    @PutMapping("/createtrips")
    public void CreateTrips(@RequestBody JsonArray jsonArray){

        JSONReader reader = new JSONReader();

        ArrayList<Packet> packetList = reader.readJson(jsonArray);
        tripCreator.createTrips(packetList);
    }

    @GetMapping("/gettrips")
    public ResponseEntity<List<Trip>> GetTrips(){
        List<Trip> trips = tripCreator.GetTrips();

       return ResponseEntity.ok().body(trips);
    }
}
