package co.udea.ssmu.api.model.jpa.mapper.rates;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.rates.Rate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRateMapper extends EntityMapper<RateDTO, Rate> {
}
