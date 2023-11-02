package co.udea.ssmu.api.model.jpa.repository.rates;

import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRateRepository extends JpaRepository<Rate, Integer> {
}
