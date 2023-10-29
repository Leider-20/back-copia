package co.udea.ssmu.api.model.jpa.repository.rates;

import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IRateRepository extends JpaRepository<Rate, Integer> {
        @Query("SELECT r FROM Rate r " +
                        "WHERE ((:beginDate BETWEEN r.begin_date AND r.end_date) " +
                        "OR (:endDate BETWEEN r.begin_date AND r.end_date))")
        List<Rate> findOverlappingRates(
                        @Param("beginDate") LocalDate beginDate,
                        @Param("endDate") LocalDate endDate);

}
