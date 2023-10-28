package co.udea.ssmu.api.model.jpa.model.cities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "percentage")
    private Integer percentage;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
