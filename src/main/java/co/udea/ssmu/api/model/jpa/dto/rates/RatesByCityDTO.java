package co.udea.ssmu.api.model.jpa.dto.rates;

import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;

public class RatesByCityDTO {

    private Integer id;
    private CityDTO ciudad;
    private Integer percentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityDTO getCiudad() {
        return ciudad;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void setCiudad(CityDTO ciudad) {
        this.ciudad = ciudad;
    }


}
