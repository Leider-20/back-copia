package co.udea.ssmu.api.model.jpa.mapper.services;

import co.udea.ssmu.api.model.jpa.dto.services.ServiceDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.services.Service;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper extends EntityMapper<ServiceDTO, Service> {
}
