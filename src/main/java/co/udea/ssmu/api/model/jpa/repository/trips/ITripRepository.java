package co.udea.ssmu.api.model.jpa.repository.trips;

import co.udea.ssmu.api.model.jpa.model.trips.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends JpaRepository<Trip, Integer> {
}
