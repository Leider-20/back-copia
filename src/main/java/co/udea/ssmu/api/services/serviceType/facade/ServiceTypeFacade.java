package co.udea.ssmu.api.services.serviceType.facade;

import co.udea.ssmu.api.model.jpa.dto.serviceType.ServiceTypeDTO;
import co.udea.ssmu.api.model.jpa.mapper.serviceType.ServiceTypeMapper;
import co.udea.ssmu.api.services.serviceType.service.ServiceTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceTypeFacade {
    private final ServiceTypeService serviceTypeService;
    private final ServiceTypeMapper serviceTypeMapper;

    public ServiceTypeFacade(ServiceTypeService serviceTypeService, ServiceTypeMapper serviceTypeMapper) {
        this.serviceTypeService = serviceTypeService;
        this.serviceTypeMapper = serviceTypeMapper;
    }

    public ServiceTypeDTO save(ServiceTypeDTO serviceType) {
        System.out.println(serviceTypeMapper.toEntity(serviceType));
        return serviceTypeMapper.toDto(serviceTypeService.save(serviceTypeMapper.toEntity(serviceType)));
    }
}
