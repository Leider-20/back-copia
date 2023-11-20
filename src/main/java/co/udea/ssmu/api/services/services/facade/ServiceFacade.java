package co.udea.ssmu.api.services.services.facade;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.dto.services.ServiceDTO;
import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;
import co.udea.ssmu.api.model.jpa.mapper.drivers.DriverMapper;
import co.udea.ssmu.api.model.jpa.mapper.services.ServiceMapper;
import co.udea.ssmu.api.model.jpa.mapper.vehicles.VehicleMapper;
import co.udea.ssmu.api.services.drivers.service.DriverService;
import co.udea.ssmu.api.services.services.service.ServiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceFacade {
    private final ServiceService serviceService;

    private final ServiceMapper serviceMapper;

    private final DriverService driverService;

    private final DriverMapper driverMapper;

    private final VehicleMapper vehicleMapper;

    public ServiceFacade(ServiceService serviceService, ServiceMapper serviceMapper,
                         DriverService driverService, DriverMapper driverMapper, VehicleMapper vehicleMapper){
        this.serviceService = serviceService;
        this.serviceMapper = serviceMapper;
        this.driverService = driverService;
        this.driverMapper = driverMapper;
        this.vehicleMapper = vehicleMapper;
    }

    public List<ServiceDTO> findByDriver(Integer driverId) {
        DriverDTO driverDTO = driverMapper.toDto(driverService.findById(driverId));
        VehicleDTO vehicle = driverDTO.getVehicle();

        return serviceMapper.toDto(serviceService.findByDriver(vehicleMapper.toEntity(vehicle)));
    }

    public ServiceDTO save(ServiceDTO service) {
        return serviceMapper.toDto(serviceService.save(serviceMapper.toEntity(service)));
    }

    public ServiceDTO acceptService(Integer serviceId, Integer driverId) {
        ServiceDTO service = serviceMapper.toDto(serviceService.findById(serviceId));
        DriverDTO driver = driverMapper.toDto(driverService.findById(driverId));

        service.setDriver(driver);
        service.setEstado("activo");

        return serviceMapper.toDto(serviceService.update(serviceMapper.toEntity(service)));
    }
}
