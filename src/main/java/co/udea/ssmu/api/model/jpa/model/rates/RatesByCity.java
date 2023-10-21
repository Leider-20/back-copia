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

    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    private City city;
    @NotNull
    @Column(name = "percentage")
    private Integer percentage;


}
