package co.udea.ssmu.api.model.jpa.dto.rates;

import java.math.BigDecimal;

public class RateDTO {
    private Integer id;
    private Integer base_rate;
    private BigDecimal multiplier;

    public RateDTO(Integer id, Integer base_rate, BigDecimal multiplier) {
        this.id = id;
        this.base_rate = base_rate;
        this.multiplier = multiplier;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBase_rate() {
        return base_rate;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBase_rate(Integer base_rate) {
        this.base_rate = base_rate;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }
}
