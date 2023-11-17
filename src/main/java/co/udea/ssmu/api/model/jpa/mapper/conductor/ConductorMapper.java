package co.udea.ssmu.api.model.jpa.mapper.conductor;

import co.udea.ssmu.api.model.jpa.dto.conductor.ConductorDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.conductor.Conductor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConductorMapper extends EntityMapper<ConductorDTO, Conductor> {
}
