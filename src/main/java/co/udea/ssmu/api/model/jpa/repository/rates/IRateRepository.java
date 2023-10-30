package co.udea.ssmu.api.model.jpa.repository.rates;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.udea.ssmu.api.model.jpa.model.rates.Rate;

public interface IRateRepository extends JpaRepository<Rate, Integer> {
        @Query("SELECT r FROM Rate r " +
                        "WHERE ((:beginDate BETWEEN r.begin_date AND r.end_date) " +
                        "OR (:endDate BETWEEN r.begin_date AND r.end_date))")
        List<Rate> findOverlappingRates(
                        @Param("beginDate") LocalDate beginDate,
                        @Param("endDate") LocalDate endDate);

}
