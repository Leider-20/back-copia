package co.udea.ssmu.api.model.jpa.dto.policies;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyDTO {
    private Integer id;
    private BigDecimal associate;
    private BigDecimal taxes;
    private BigDecimal platform;
    private LocalDate date;

    public PolicyDTO(Integer id, BigDecimal associate, BigDecimal taxes, BigDecimal platform, LocalDate date) {
        this.id = id;
        this.associate = associate;
        this.taxes = taxes;
        this.platform = platform;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getAssociate() {
        return associate;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public BigDecimal getPlatform() {
        return platform;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAssociate(BigDecimal associate) {
        this.associate = associate;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    public void setPlatform(BigDecimal platform) {
        this.platform = platform;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
