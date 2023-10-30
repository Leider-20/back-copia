package co.udea.ssmu.api.model.jpa.dto.cities;

import java.math.BigDecimal;

public class CityDTO {
    private Integer id;
    private String name;
    private BigDecimal percentage;

    public CityDTO(Integer id, String name, BigDecimal percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
