package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.ContactoConductorDTO;
import co.udea.ssmu.api.model.jpa.model.ContactoConductor;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactoConductorMapper extends EntityMapper<ContactoConductorDTO, ContactoConductor>{
}
