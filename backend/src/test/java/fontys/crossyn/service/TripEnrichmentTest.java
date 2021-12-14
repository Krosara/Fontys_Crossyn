package fontys.crossyn.service;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Location;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TripEnrichmentTest {


    @Test
    void addAvrgSpeedTest(){

        TripEnrichment tripEnrichment = new TripEnrichment();
        Trip trip = new Trip();
        ArrayList<Packet> packets;
        packets = new ArrayList<>();

        Packet packet1 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                30,
                50,
                3,
                IgnitionStates.TRUE,
                null
        );

        Packet packet2 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                70,
                50,
                3,
                IgnitionStates.TRUE,
                null
        );

        Packet packet3 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                80,
                50,
                3,
                IgnitionStates.FALSE,
                null
        );
        packets.add(packet1);
        packets.add(packet2);
        packets.add(packet3);
        trip.setPackets(packets);


        tripEnrichment.addAvrgAndTopSpeed(trip);

        assertEquals(60, trip.getAverageSpeed());

    }

    @Test
    void addTopSpeedTest(){

        TripEnrichment tripEnrichment = new TripEnrichment();
        Trip trip = new Trip();
        ArrayList<Packet> packets;
        packets = new ArrayList<>();

        Packet packet1 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                30,
                50,
                3,
                IgnitionStates.TRUE,
                null
        );

        Packet packet2 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                70,
                50,
                3,
                IgnitionStates.TRUE,
                null
        );

        Packet packet3 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                80,
                50,
                3,
                IgnitionStates.FALSE,
                null
        );
        packets.add(packet1);
        packets.add(packet2);
        packets.add(packet3);
        trip.setPackets(packets);


        tripEnrichment.addAvrgAndTopSpeed(trip);

        assertEquals(80, trip.getTopSpeed());

    }


}
