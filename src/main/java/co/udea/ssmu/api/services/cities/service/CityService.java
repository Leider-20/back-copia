package co.udea.ssmu.api.services.cities.service;


import co.udea.ssmu.api.model.jpa.model.cities.City;
import co.udea.ssmu.api.model.jpa.repository.cities.ICityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityService {

    private final ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

}
