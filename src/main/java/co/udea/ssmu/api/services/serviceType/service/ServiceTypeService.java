package co.udea.ssmu.api.services.serviceType.service;

import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.model.jpa.model.serviceType.ServiceType;
import co.udea.ssmu.api.model.jpa.repository.drivers.DriverRepository;
import co.udea.ssmu.api.model.jpa.repository.serviceType.ServiceTypeRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;
    private final Messages messages;

    public ServiceTypeService(ServiceTypeRepository serviceTypeRepository, Messages messages) {
        this.serviceTypeRepository = serviceTypeRepository;
        this.messages = messages;
    }

    public ServiceType save(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }
}
