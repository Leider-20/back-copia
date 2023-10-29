package co.udea.ssmu.api.services.rates.service;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import co.udea.ssmu.api.model.jpa.repository.rates.IRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
@Transactional
public class RateService {

    private final IRateRepository iRateRepository;

    public RateService(IRateRepository iRateRepository) {
        this.iRateRepository = iRateRepository;
    }

    public List<Rate> findAll() {
        return iRateRepository.findAll();
    }

    public Rate save(Rate rateToSave) {
        LocalDate beginDate = rateToSave.getBegin_date();
        LocalDate endDate = rateToSave.getEnd_date();

        System.out.println("###########Fecha de inicio: " + beginDate.toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Configura la zona horaria en UTC
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        // Realiza una consulta para verificar si ya existe una política activa para la
        // misma ciudad y rango de fechas
        List<Rate> overlappingRates = iRateRepository.findOverlappingRates(beginDate, endDate);

        if (!overlappingRates.isEmpty()) {
            // Crear una lista de fechas de solapamiento
            List<String> overlappingDates = new ArrayList<>();
            for (Rate overlappingRate : overlappingRates) {
                LocalDate overlappingBegin = overlappingRate.getBegin_date();
                LocalDate overlappingEnd = overlappingRate.getEnd_date();
                String overlappingRange = overlappingBegin + " - " + overlappingEnd;
                overlappingDates.add(overlappingRange);
            }

            // Convertir la lista de fechas de solapamiento a una representación legible en
            // formato JSON
            ObjectMapper mapper = new ObjectMapper();
            String overlappingDatesJson;
            try {
                overlappingDatesJson = mapper.writeValueAsString(overlappingDates);
            } catch (Exception e) {
                // Manejar cualquier error de conversión JSON
                throw new IllegalArgumentException("Error al convertir la lista de fechas de solapamiento a JSON.", e);
            }

            // Devolver las fechas de solapamiento en formato JSON
            throw new IllegalArgumentException("Hay solapamiento de fechas: " + overlappingDatesJson);
        } else {
            // No hay solapamiento, guardar la nueva política
            return iRateRepository.save(rateToSave);
        }

    }

    public List<Rate> getAllRates() {
        return iRateRepository.findAll();
    }

    public Optional<Rate> getRateById(Integer id) {
        return iRateRepository.findById(id);
    }

}
