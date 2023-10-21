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

    @NotNull
    @Column(name = "idciudad")
    private Integer idciudad;
    @OneToOne(mappedBy = "id")
    private City city;
    
    @NotNull
    @Column(name = "percentage")
    private Integer percentage;


}
