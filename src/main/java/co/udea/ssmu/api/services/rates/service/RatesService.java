package co.udea.ssmu.api.services.rates.service;

import co.udea.ssmu.api.model.jpa.model.rates.RatesByCity;
import co.udea.ssmu.api.model.jpa.repository.rates.IRatesByCityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RatesService {

    private final IRatesByCityRepository iRatesByCityRepository;

    public RatesService(IRatesByCityRepository iRatesByCityRepository) {
        this.iRatesByCityRepository = iRatesByCityRepository;
    }

    public List<RatesByCity> findAll() {
        return iRatesByCityRepository.findAll();
    }

    public RatesByCity save(RatesByCity ratesByCity){
        //Validar que por codigo que  la ciudad si exista.
        // Validar que se ingrese un porcentaje correcto
        //En caso no funcione saltar una excepcion
        System.out.println("######id ciudad a guardar"+ratesByCity.getCity().getId());
        return iRatesByCityRepository.save(ratesByCity);
    }

}
