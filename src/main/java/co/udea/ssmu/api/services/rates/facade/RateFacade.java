package co.udea.ssmu.api.services.rates.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.model.jpa.mapper.rates.IRateMapper;
import co.udea.ssmu.api.services.rates.service.RateService;

@Service
@Transactional
public class RateFacade {
    private final RateService rateService;
    private final IRateMapper iRateMapper;

    @Autowired
    public RateFacade(RateService rateService, IRateMapper iRateMapper) {
        this.rateService = rateService;
        this.iRateMapper = iRateMapper;
    }

    public RateDTO createRate(RateDTO rateDTO) {
        return iRateMapper.toDto(rateService.createRate(iRateMapper.toEntity(rateDTO)));
    }

    public List<RateDTO> getAllRates() {
        return rateService.getAllRates();
    }
}
