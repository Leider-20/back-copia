package co.udea.ssmu.api.model.jpa.model.policies;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "associate")
    private BigDecimal associate;

    @NotNull
    @Column(name = "taxes")
    private BigDecimal taxes;

    @NotNull
    @Column(name = "platform")
    private BigDecimal platform;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private LocalDate date;

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
