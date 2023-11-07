package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.ContactoDTO;
import co.udea.ssmu.api.model.jpa.model.Contacto;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactoMapper extends EntityMapper<ContactoDTO, Contacto>{
}