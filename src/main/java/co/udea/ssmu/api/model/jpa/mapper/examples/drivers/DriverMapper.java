package co.udea.ssmu.api.model.jpa.mapper.examples.drivers;

import co.udea.ssmu.api.model.jpa.dto.examples.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.model.examples.drivers.Driver;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends EntityMapper<DriverDTO, Driver> {
}
