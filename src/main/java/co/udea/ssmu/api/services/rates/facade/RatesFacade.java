package co.udea.ssmu.api.services.rates.facade;

import co.udea.ssmu.api.model.jpa.dto.rates.RatesByCityDTO;
import co.udea.ssmu.api.model.jpa.mapper.rates.IRatesByCityMapper;
import co.udea.ssmu.api.services.rates.service.RatesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RatesFacade {

    private final RatesService ratesService;
    private final IRatesByCityMapper iRatesByCityMapper;

    public RatesFacade(RatesService ratesService, IRatesByCityMapper iRatesByCityMapper) {
        this.ratesService = ratesService;
        this.iRatesByCityMapper = iRatesByCityMapper;
    }
    public RatesByCityDTO save(RatesByCityDTO ratesByCityDTO) {
        System.out.println("#########nombre ciudad a guardar"+ ratesByCityDTO.getCity().getName());
        return iRatesByCityMapper.toDto(ratesService.save(iRatesByCityMapper.toEntity(ratesByCityDTO)));
    }


}
