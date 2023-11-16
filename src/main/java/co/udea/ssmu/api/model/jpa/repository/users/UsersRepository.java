package co.udea.ssmu.api.model.jpa.repository.users;

import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Trip, Integer> {
}
