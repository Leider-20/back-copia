package co.udea.ssmu.api.services.cities.facade;


import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;
import co.udea.ssmu.api.model.jpa.mapper.cities.ICityMapper;
import co.udea.ssmu.api.services.cities.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityFacade {

    private final CityService cityService;
    private final ICityMapper cityMapper;

    public CityFacade(CityService cityService, ICityMapper iCityMapper) {
        this.cityService = cityService;
        this.cityMapper = iCityMapper;
    }

    public List<CityDTO> findAll(){
        return cityMapper.toDto(cityService.findAll());
    }


}
