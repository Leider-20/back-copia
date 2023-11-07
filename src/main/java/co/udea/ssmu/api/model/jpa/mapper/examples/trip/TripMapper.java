package co.udea.ssmu.api.model.jpa.mapper.examples.trip;

import co.udea.ssmu.api.model.jpa.dto.examples.trip.TripDTO;
import co.udea.ssmu.api.model.jpa.model.examples.trip.Trip;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
}
