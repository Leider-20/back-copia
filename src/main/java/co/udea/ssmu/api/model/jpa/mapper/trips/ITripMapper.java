package co.udea.ssmu.api.model.jpa.mapper.trips;

import co.udea.ssmu.api.model.jpa.dto.trips.TripDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.trips.Trip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITripMapper extends EntityMapper<TripDTO, Trip> {
}
