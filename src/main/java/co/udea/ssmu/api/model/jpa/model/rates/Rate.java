package co.udea.ssmu.api.model.jpa.model.rates;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @Column(name = "surcharge")
    private Integer surcharge;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "begin_date")
    private LocalDate begin_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDate end_date;

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

    public Integer getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Integer surcharge) {
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
