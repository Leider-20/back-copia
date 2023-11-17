package co.udea.ssmu.api.model.jpa.mapper.servicio;

import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.mapper.conductor.ConductorMapper;
import co.udea.ssmu.api.model.jpa.mapper.ubicacion.UbicacionMapper;
import co.udea.ssmu.api.model.jpa.mapper.usuario.UsuarioMapper;
import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, ConductorMapper.class, UbicacionMapper.class})
public interface ServicioMapper extends EntityMapper<ServicioDTO, Servicio> {
}
