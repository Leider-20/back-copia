package co.udea.ssmu.api.services.cities.facade;

import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;
import co.udea.ssmu.api.model.jpa.mapper.cities.ICityMapper;
import co.udea.ssmu.api.services.cities.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityFacade {
    private final CityService cityService;

    @Autowired
    public CityFacade(CityService cityService) {
        this.cityService = cityService;
    }

    public List<CityDTO> getAllCityNames() {
        return cityService.getAllCityNames();
    }

    public void updateCityPercentage(Integer cityId, Integer newPercentage) {
        cityService.updateCityPercentage(cityId, newPercentage);
    }
}
