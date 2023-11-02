package co.udea.ssmu.api.model.jpa.model.rates;

import jakarta.persistence.*;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "base_rate")
    private Integer base_rate;

    @NotNull
    @Column(name = "multiplier")
    private BigDecimal multiplier;

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
