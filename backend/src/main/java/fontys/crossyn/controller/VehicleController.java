package fontys.crossyn.controller;


import fontys.crossyn.dto.*;
import fontys.crossyn.model.*;
import fontys.crossyn.service.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;


@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin("http://localhost:3000/")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

//    public PacketController(PacketService packetService) {
//        this.packetService = packetService;
//    }

    @GetMapping("/getfromfleetid/{fleetID}")
    public List<Vehicle> getAllVehiclesByFleetID(@RequestBody int fleetID){
        return vehicleService.getAllVehiclesByFleetID(fleetID);
    }
}
