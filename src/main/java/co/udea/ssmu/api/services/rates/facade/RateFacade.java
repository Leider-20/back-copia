package co.udea.ssmu.api.services.rates.facade;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.model.jpa.mapper.rates.IRateMapper;
import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import co.udea.ssmu.api.model.jpa.repository.rates.IRateRepository;
import co.udea.ssmu.api.services.rates.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public RateDTO save(RateDTO rateDTO) {
        return iRateMapper.toDto(rateService.save(iRateMapper.toEntity(rateDTO)));
    }

    public List<RateDTO> getAllRates() {
        List<Rate> rates = rateService.getAllRates();
        return rates.stream()
                .map(iRateMapper::toDto)
                .collect(Collectors.toList());
    }

    public RateDTO getRateById(Integer id) {
        Optional<Rate> rateOptional = rateService.getRateById(id);
        if (rateOptional.isPresent()) {
            Rate rate = rateOptional.get();
            return iRateMapper.toDto(rate);
        } else {
            // Puedes manejar la situación en la que no se encuentra el registro con el id especificado.
            // En este ejemplo, simplemente retornamos null.
            return null;
        }
    }


}



