package co.udea.ssmu.api.model.jpa.model.service;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name= "details")
    private String details;

    @NotNull
    @Column(name= "state")
    private String state;

    @NotNull
    @Column(name= "coste")
    private Integer coste;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

}
