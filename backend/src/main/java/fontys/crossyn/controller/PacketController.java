package fontys.crossyn.controller;


import fontys.crossyn.model.Packet;
import fontys.crossyn.service.PacketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/packet")
public class PacketController {

    private PacketService packetService;

    public PacketController(PacketService packetService) {
        this.packetService = packetService;
    }

    @GetMapping("/all")
    public Iterable<Packet> list(){
        return packetService.list();
    }
}
