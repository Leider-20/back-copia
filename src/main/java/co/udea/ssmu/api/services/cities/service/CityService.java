package co.udea.ssmu.api.services.cities.service;

import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;
import co.udea.ssmu.api.model.jpa.model.cities.City;
import co.udea.ssmu.api.model.jpa.repository.cities.ICityRepository;
import co.udea.ssmu.api.utils.exception.CityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final ICityRepository cityRepository;

    @Autowired
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> getAllCityNames() {
        List<City> cities = cityRepository.findAll();
        List<CityDTO> cityDTOs = cities.stream()
                .map(city -> new CityDTO(city.getId(), city.getName(), city.getPercentage()))
                .collect(Collectors.toList());
        return cityDTOs;
    }

    public void updateCityPercentage(Integer cityId, Integer newPercentage) {
        City city = cityRepository.findById(cityId).orElse(null);
        if (city != null) {
            city.setPercentage(newPercentage);
            cityRepository.save(city);
        } else {
            throw new CityNotFoundException("La ciudad con el ID proporcionado no existe.");
        }
    }
}
