package co.udea.ssmu.api.model.jpa.repository.rate;

import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Trip, Integer> {
}
