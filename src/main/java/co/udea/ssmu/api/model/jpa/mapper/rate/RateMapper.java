package co.udea.ssmu.api.model.jpa.mapper.rate;

import co.udea.ssmu.api.model.jpa.dto.rate.RateDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateMapper extends EntityMapper<RateDTO, Rate> {
}
