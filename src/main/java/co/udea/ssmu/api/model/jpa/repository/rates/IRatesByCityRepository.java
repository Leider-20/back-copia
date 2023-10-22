package co.udea.ssmu.api.model.jpa.repository.rates;

import co.udea.ssmu.api.model.jpa.model.rates.RatesByCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatesByCityRepository extends JpaRepository<RatesByCity,Integer> {
}
