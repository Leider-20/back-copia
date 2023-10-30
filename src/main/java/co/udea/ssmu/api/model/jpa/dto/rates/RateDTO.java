package co.udea.ssmu.api.model.jpa.dto.rates;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RateDTO {

    private Integer id;
    private Integer price;
    private BigDecimal surcharge;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate begin_date;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate end_date;

    @Override
    public String toString() {
        return "RateDTO{" +
                "id=" + id +
                ", price=" + price +
                ", surcharge=" + surcharge +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                '}';
    }

    public RateDTO(Integer id, Integer price, BigDecimal surcharge, LocalDate begin_date, LocalDate end_date) {
        this.id = id;
        this.price = price;
        this.surcharge = surcharge;
        this.begin_date = begin_date;
        this.end_date = end_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }

    public LocalDate getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(LocalDate begin_date) {
        this.begin_date = begin_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
