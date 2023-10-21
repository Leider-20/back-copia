package co.udea.ssmu.api.model.jpa.repository.rates;

import co.udea.ssmu.api.model.jpa.model.rates.RatesByCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatesByCity extends JpaRepository<RatesByCity,Integer> {
}
