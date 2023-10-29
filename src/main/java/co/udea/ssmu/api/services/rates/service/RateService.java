package co.udea.ssmu.api.services.rates.service;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import co.udea.ssmu.api.model.jpa.repository.rates.IRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Date beginDate = rateToSave.getBegin_date();
        Date endDate = rateToSave.getEnd_date();
        System.out.println("################" + rateToSave.getPrice());
        System.out.println("Conversión de RateDTO a Rate: " + rateToSave.toString());



        // Realiza una consulta para verificar si ya existe una política activa para la misma ciudad y rango de fechas
        List<Rate> overlappingRates = iRateRepository.findOverlappingRates(beginDate, endDate);

        if (!overlappingRates.isEmpty()) {
            // Convertir la lista de políticas conflictivas a una representación legible en formato JSON
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
            String conflictingRatesJson;
            try {
                conflictingRatesJson = writer.writeValueAsString(overlappingRates);
            } catch (Exception e) {
                // Manejar cualquier error de conversión JSON
                throw new IllegalArgumentException("Error al convertir la lista de políticas conflictivas a JSON.", e);
            }

            // Devolver las políticas conflictivas en formato JSON
            throw new IllegalArgumentException("Ya existe una política activa para las mismas fechas en esta ciudad: " + conflictingRatesJson);
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



