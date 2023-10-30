package co.udea.ssmu.api.services.trips.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.trips.TripDTO;
import co.udea.ssmu.api.services.trips.service.TripService;

@Service
@Transactional
public class TripFacade {
    private final TripService tripService;

    @Autowired
    public TripFacade(TripService tripService) {
        this.tripService = tripService;
    }

    public List<TripDTO> getAllTrips() {
        return tripService.getAllTrips();
    }
}
