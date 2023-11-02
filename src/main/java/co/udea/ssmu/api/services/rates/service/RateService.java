package co.udea.ssmu.api.services.rates.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import co.udea.ssmu.api.model.jpa.repository.rates.IRateRepository;

@Service
public class RateService {
    private final IRateRepository rateRepository;

    @Autowired
    public RateService(IRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate createRate(Rate rateToSave) {
        return rateRepository.save(rateToSave);
    }

    public List<RateDTO> getAllRates() {
        List<Rate> rates = rateRepository.findAll();
        List<RateDTO> rateDTOs = rates.stream()
                .map(rate -> new RateDTO(rate.getId(), rate.getBase_rate(), rate.getMultiplier()))
                .collect(Collectors.toList());
        return rateDTOs;
    }
}
