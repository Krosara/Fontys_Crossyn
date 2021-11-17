package fontys.crossyn.repository;

import fontys.crossyn.model.Packet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacketRepository extends MongoRepository<Packet, Long> {

}
