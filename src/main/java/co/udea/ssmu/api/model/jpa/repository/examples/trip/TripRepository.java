package co.udea.ssmu.api.model.jpa.repository.examples.trip;

import co.udea.ssmu.api.model.jpa.model.examples.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
