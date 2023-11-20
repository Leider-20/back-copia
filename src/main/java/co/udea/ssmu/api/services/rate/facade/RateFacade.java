package co.udea.ssmu.api.services.rate.facade;

import co.udea.ssmu.api.model.jpa.dto.rate.RateDTO;
import co.udea.ssmu.api.model.jpa.mapper.rate.RateMapper;
import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import co.udea.ssmu.api.services.rate.service.RateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RateFacade {
    private final RateService rateService;
    private final RateMapper rateMapper;

    public RateFacade(RateService rateService, RateMapper rateMapper) {
        this.rateService = rateService;
        this.rateMapper = rateMapper;
    }

    public RateDTO save(RateDTO rate) {
        System.out.println("rateMapper.toEntity(Rate)");

        Rate rate1 = rateMapper.toEntity(rate);
        System.out.println(rate1);
        System.out.println("rateMapper.toEntity(Rate1111)");
        return rateMapper.toDto(rateService.save(rateMapper.toEntity(rate)));
    }

    public RateDTO update(RateDTO Rate) {
        return rateMapper.toDto(rateService.update(rateMapper.toEntity(Rate)));
    }

    public List<RateDTO> findByAll() {
        List<Rate> rate = rateService.findByAll();
        return rateMapper.toDto(rate);
    }

    public Rate updateMultFactor(Double multFactor, Integer id) {
        return rateService.updateMultFactor(multFactor, id);
    }
}
