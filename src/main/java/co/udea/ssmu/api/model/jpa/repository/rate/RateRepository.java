package co.udea.ssmu.api.model.jpa.repository.rate;

import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Integer> {
}
