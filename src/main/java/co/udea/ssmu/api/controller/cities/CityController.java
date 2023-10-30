package co.udea.ssmu.api.controller.cities;

import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;
import co.udea.ssmu.api.services.cities.facade.CityFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityFacade cityFacade;

    @Autowired
    public CityController(CityFacade cityFacade) {
        this.cityFacade = cityFacade;
    }

    @GetMapping("/names")
    public List<CityDTO> getCityNames() {
        List<CityDTO> cityNames = cityFacade.getAllCityNames();
        cityNames.sort(Comparator.comparing(CityDTO::getId));
        return cityNames;
    }

    @PutMapping("/{cityId}/percentage")
    public void updateCityPercentage(
            @PathVariable Integer cityId,
            @RequestBody Map<String, BigDecimal> requestBody) {
        BigDecimal newPercentage = requestBody.get("newPercentage");
        cityFacade.updateCityPercentage(cityId, newPercentage);
    }

}
