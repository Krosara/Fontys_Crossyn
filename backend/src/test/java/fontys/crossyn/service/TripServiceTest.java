package fontys.crossyn.service;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Location;
import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import fontys.crossyn.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {

    @Mock
    private TripRepository tripRepository;
    private TripService _ts;

    @BeforeEach
    void setUp(){
        _ts = new TripService(tripRepository);
    }


    @Test
    void getTrips() {


        List<Trip> trips = _ts.GetTrips();

        verify(tripRepository).findAll();
    }

    @Test
    void createTrips() {



        Packet packet1 = new Packet(
                null,
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                7,
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
                7,
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
                7,
                50,
                3,
                IgnitionStates.FALSE,
                null
        );

        ArrayList<Packet> packets = new ArrayList<>();
        packets.add(packet1);
        packets.add(packet2);
        packets.add(packet3);


        _ts.CreateTrips(packets);

        ArgumentCaptor<Trip> tripArgumentCaptor = ArgumentCaptor.forClass(Trip.class);
        verify(tripRepository).insert(tripArgumentCaptor.capture());



    }

    @Test
    void deleteTrip() {

        Packet packet1 = new Packet(
                "1",
                "00A1",
                new Location(51.55546, 5.10577, 62),
                ZonedDateTime.now(),
                7,
                50,
                3,
                IgnitionStates.TRUE,
                null
        );

        _ts.DeleteTrip("1");
        List<Trip> trips = _ts.GetTrips();
        verify(tripRepository).deleteById("1");

    }
}