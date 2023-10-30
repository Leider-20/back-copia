package co.udea.ssmu.api.controller.trips;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.dto.trips.TripDTO;
import co.udea.ssmu.api.services.trips.facade.TripFacade;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripFacade tripFacade;

    @Autowired
    public TripController(TripFacade tripFacade) {
        this.tripFacade = tripFacade;
    }

    @GetMapping("/list")
    public List<TripDTO> getTripNames() {
        List<TripDTO> tripNames = tripFacade.getAllTrips();
        tripNames.sort(Comparator.comparing(TripDTO::getId));
        return tripNames;
    }
}
