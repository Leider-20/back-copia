package co.udea.ssmu.api.services.services.service;

import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.model.jpa.model.services.Service;
import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import co.udea.ssmu.api.model.jpa.repository.services.ServiceRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final Messages messages;

    public ServiceService(ServiceRepository serviceRepository, Messages messages) {
        this.serviceRepository = serviceRepository;
        this.messages = messages;
    }

    public List<co.udea.ssmu.api.model.jpa.model.services.Service> findByDriver(Vehicle vehicle) {
        return serviceRepository.findByAbilityAndAllowsPets(vehicle.getAbility(), vehicle.getAllowsPets());
    }

    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    public Service findById(Integer id) {
        Optional<Service> serviceOptional = serviceRepository.findById(id);
        if (serviceOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("service.get.does.not.exist")));
        }
        return serviceOptional.get();
    }

    public Service update(Service service) {
        Optional<Service> serviceOptional = serviceRepository.findById(service.getId());
        if (serviceOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("service.get.does.not.exist")));
        }
        return serviceRepository.save(service);
    }

}
