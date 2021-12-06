package fontys.crossyn.repository;

import fontys.crossyn.model.Packet;
import fontys.crossyn.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {

}
