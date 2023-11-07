package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.SolicitudDTO;
import co.udea.ssmu.api.model.jpa.model.Solicitud;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudMapper extends EntityMapper<SolicitudDTO, Solicitud>{
}