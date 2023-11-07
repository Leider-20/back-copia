package co.udea.ssmu.api.model.jpa.mapper.examples.vehicles;

import co.udea.ssmu.api.model.jpa.dto.examples.vehicles.VehicleDTO;
import co.udea.ssmu.api.model.jpa.mapper.examples.drivers.DriverMapper;
import co.udea.ssmu.api.model.jpa.model.examples.vehicles.Vehicle;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DriverMapper.class})
public interface VehicleMapper extends EntityMapper<VehicleDTO, Vehicle> {
}
