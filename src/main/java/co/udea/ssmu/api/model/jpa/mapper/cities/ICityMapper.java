package co.udea.ssmu.api.model.jpa.mapper.cities;

import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.cities.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICityMapper extends EntityMapper<CityDTO, City> {
}
