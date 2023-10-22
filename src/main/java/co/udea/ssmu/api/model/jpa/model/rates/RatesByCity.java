package co.udea.ssmu.api.model.jpa.model.rates;

import co.udea.ssmu.api.model.jpa.model.cities.City;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RatesByCity")

public class RatesByCity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", insertable = true, updatable = true)
    private City city;

    @NotNull
    @Column(name = "percentage")
    private Integer percentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
