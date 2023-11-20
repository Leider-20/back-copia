package co.udea.ssmu.api.services.rate.service;

import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import co.udea.ssmu.api.model.jpa.repository.rate.RateRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RateService {

    private final RateRepository rateRepository;

    private final Messages messages;

    public RateService(RateRepository rateRepository, Messages messages){
        this.rateRepository = rateRepository;
        this.messages = messages;
    }

    public Rate save(Rate rate){
        return rateRepository.save(rate);
    }

    public Rate update(Rate rate) {
        Optional<Rate> rateOptional = rateRepository.findById(rate.getId());
        if (rateOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("rate.update.does.not.exist")));
        }
        return rateRepository.save(rate);
    }

    public List<Rate> findByAll() {
        return rateRepository.findAll();
    }

    public Rate updateMultFactor(Double mulFactor, Integer id) {
        Optional<Rate> rateOptional = rateRepository.findById(id);
        if (rateOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("rate.update.does.not.exist")));
        }
        Rate rate = rateOptional.get();
        rate.setMultiplierFactor(mulFactor);
        return rateRepository.save(rate);
    }

    public Rate updateBaseRate(Double base, Integer id) {
        Optional<Rate> rateOptional = rateRepository.findById(id);
        if (rateOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("rate.update.does.not.exist")));
        }
        Rate rate = rateOptional.get();
        rate.setBaseRate(base);
        return rateRepository.save(rate);
    }
}
