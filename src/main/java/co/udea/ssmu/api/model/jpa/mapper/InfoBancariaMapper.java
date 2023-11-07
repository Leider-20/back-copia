package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.InfoBancariaDTO;
import co.udea.ssmu.api.model.jpa.model.InfoBancaria;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfoBancariaMapper extends EntityMapper<InfoBancariaDTO, InfoBancaria>{
}
