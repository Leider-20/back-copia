package co.udea.ssmu.api.services.trips.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.trips.TripDTO;
import co.udea.ssmu.api.model.jpa.model.trips.Trip;
import co.udea.ssmu.api.model.jpa.repository.trips.ITripRepository;

@Service
public class TripService {
    private final ITripRepository tripRepository;

    @Autowired
    public TripService(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<TripDTO> getAllTrips() {
        List<Trip> trips = tripRepository.findAll();
        List<TripDTO> tripDTOs = trips.stream()
                .map(trip -> new TripDTO(trip.getId(), trip.getUser(), trip.getDate(), trip.getTime(),
                        trip.getDistance(),
                        trip.getCity()))
                .collect(Collectors.toList());
        return tripDTOs;
    }
}
