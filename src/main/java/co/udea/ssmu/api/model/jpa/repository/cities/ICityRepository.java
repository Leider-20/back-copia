package co.udea.ssmu.api.model.jpa.repository.cities;

import co.udea.ssmu.api.model.jpa.model.cities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Integer> {
}
