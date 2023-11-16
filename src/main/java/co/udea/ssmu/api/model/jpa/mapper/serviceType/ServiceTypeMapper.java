package co.udea.ssmu.api.model.jpa.mapper.serviceType;

import co.udea.ssmu.api.model.jpa.dto.serviceType.ServiceTypeDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.serviceType.ServiceType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapper extends EntityMapper<ServiceTypeDTO, ServiceType> {
}
