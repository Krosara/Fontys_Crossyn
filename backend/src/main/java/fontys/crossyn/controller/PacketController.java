package fontys.crossyn.controller;


import fontys.crossyn.dto.PacketDTO;
import fontys.crossyn.model.Packet;
import fontys.crossyn.service.PacketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return packetService.list().stream().map(packet -> modelMapper.map(packet, PacketDTO.class)).toList();
    }
}
