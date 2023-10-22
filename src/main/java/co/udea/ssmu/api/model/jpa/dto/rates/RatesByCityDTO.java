package co.udea.ssmu.api.model.jpa.dto.rates;

import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;

public class RatesByCityDTO {

    private Integer id;
    private CityDTO city;
    private Integer percentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }



}
