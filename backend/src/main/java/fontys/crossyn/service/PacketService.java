package fontys.crossyn.service;

import fontys.crossyn.model.Packet;
import fontys.crossyn.repository.PacketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacketService {

    private final PacketRepository packetRepository;

    public PacketService(PacketRepository packetRepository){
        this.packetRepository = packetRepository;
    }

    public Iterable<Packet> list() {
        return packetRepository.findAll();
    }

    public Packet save(Packet packet) {
        return packetRepository.save(packet);
    }

    public boolean readDataset(){

        return false;
    }

}
