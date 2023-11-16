package co.udea.ssmu.api.model.jpa.repository.paymentMethod;

import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<Trip, Integer> {
}
