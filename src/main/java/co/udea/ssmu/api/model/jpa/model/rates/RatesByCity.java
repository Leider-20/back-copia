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

    @OneToOne
    @JoinColumn(name = "idcity")
    private City idcity;

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
        return idcity;
    }

    public void setCity(City city) {
        this.idcity = city;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
