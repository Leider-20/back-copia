package co.udea.ssmu.api.model.jpa.mapper.ubicacion;

import co.udea.ssmu.api.model.jpa.dto.ubicacion.UbicacionDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UbicacionMapper extends EntityMapper<UbicacionDTO, Ubicacion> {
}
