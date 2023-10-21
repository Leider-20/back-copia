package co.udea.ssmu.api.model.jpa.mapper.rates;

import co.udea.ssmu.api.model.jpa.dto.rates.RatesByCityDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.rates.RatesByCity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRatesByCity extends EntityMapper<RatesByCityDTO, RatesByCity> {
}
