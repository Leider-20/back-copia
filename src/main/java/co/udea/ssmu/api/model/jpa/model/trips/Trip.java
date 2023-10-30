package co.udea.ssmu.api.model.jpa.model.trips;

import java.sql.Time;
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
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "user")
    private String user;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "time")
    private Time time;

    @NotNull
    @Column(name = "distance")
    private Double distance;

    @NotNull
    @Column(name = "city")
    private String city;

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public Double getDistance() {
        return distance;
    }

    public String getCity() {
        return city;
    }
}
