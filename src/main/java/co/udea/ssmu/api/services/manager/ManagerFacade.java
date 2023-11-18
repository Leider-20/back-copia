package co.udea.ssmu.api.services.manager;

import co.udea.ssmu.api.model.jpa.dto.ManagerDTO;
import co.udea.ssmu.api.model.jpa.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerFacade {
    private final ManagerImplementacion managerImplementacion;
    private final ManagerMapper managerMapper;

    public ManagerFacade(ManagerImplementacion managerImplementacion, ManagerMapper managerMapper) {
        this.managerImplementacion = managerImplementacion;
        this.managerMapper = managerMapper;
    }

    public List<ManagerDTO> findAll(){return managerMapper.toDto(managerImplementacion.findAllManager());}

    public ManagerDTO save(ManagerDTO manager){
        return managerMapper.toDto(managerImplementacion.saveManager(managerMapper.toEntity(manager)));
    }

    public ManagerDTO get(Long id){
        return managerMapper.toDto(managerImplementacion.findManager(id));
    }

    public void delete(Long id){managerImplementacion.deleteManager(id);}
}
