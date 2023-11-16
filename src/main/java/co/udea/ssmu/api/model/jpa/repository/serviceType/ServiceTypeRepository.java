package co.udea.ssmu.api.model.jpa.repository.serviceType;

import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<Trip, Integer> {
}
