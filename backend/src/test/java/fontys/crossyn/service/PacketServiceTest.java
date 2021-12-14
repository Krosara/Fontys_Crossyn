package fontys.crossyn.service;

import fontys.crossyn.model.IgnitionStates;
import fontys.crossyn.model.Packet;
import fontys.crossyn.repository.PacketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PacketServiceTest {

    @Mock
    private PacketRepository packetRepository;
    private PacketService _ps;

    @BeforeEach
    void setUp()
    {
        _ps = new PacketService(packetRepository);
    }

    @Test
    void canListAllPackets() {
        //Act
        _ps.list();
        //Assert
        verify(packetRepository).findAll();
    }

    @Test
    void canSavePacket() {
        //Arrange
        ZonedDateTime dateTime = ZonedDateTime.now();
        Packet p1 = new Packet(
                "v1",
                1.11,
                1.11,
                1,
                dateTime,
                30,
                30,
                3,
                IgnitionStates.FALSE
        );
        //Act
        _ps.save(p1);
        //Assert
        ArgumentCaptor<Packet> packetArgumentCaptor = ArgumentCaptor.forClass(Packet.class);
        verify(packetRepository).insert(packetArgumentCaptor.capture());
        Packet capturedPacket = packetArgumentCaptor.getValue();
        assertThat(capturedPacket).isEqualTo(p1);
    }

}