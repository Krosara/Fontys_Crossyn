package fontys.crossyn.controller;


import fontys.crossyn.dto.PacketDTO;
import fontys.crossyn.model.Packet;
import fontys.crossyn.service.PacketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/packet")
@CrossOrigin("http://localhost:3000/")
public class PacketController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PacketService packetService;

//    public PacketController(PacketService packetService) {
//        this.packetService = packetService;
//    }

    @GetMapping
    public List<PacketDTO> getAllPackets(){
        return packetService.list().stream().map(packet -> modelMapper.map(packet, PacketDTO.class)).collect(Collectors.toList());
    }
}
