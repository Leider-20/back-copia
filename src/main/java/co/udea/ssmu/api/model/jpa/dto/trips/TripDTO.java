package co.udea.ssmu.api.model.jpa.dto.trips;

import java.sql.Time;
import java.time.LocalDate;

public class TripDTO {
    private Integer id;
    private String user;
    private LocalDate date;
    private Time time;
    private Double distance;
    private String city;

    public TripDTO(Integer id, String user, LocalDate date, Time time, Double distance, String city) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.city = city;
    }

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
