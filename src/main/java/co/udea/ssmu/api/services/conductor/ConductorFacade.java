package co.udea.ssmu.api.services.conductor;

import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;
import co.udea.ssmu.api.model.jpa.mapper.ConductorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConductorFacade {
    private final ConductorImplementacion conductorImplementacion;
    private final ConductorMapper conductorMapper;

    public ConductorFacade(ConductorImplementacion conductorImplementacion, ConductorMapper conductorMapper) {
        this.conductorImplementacion = conductorImplementacion;
        this.conductorMapper = conductorMapper;
    }

    public ConductorDTO save(ConductorDTO conductor){
        return conductorMapper.toDto(conductorImplementacion.saveConductor(conductorMapper.toEntity(conductor)));
    }

    public List<ConductorDTO> findAll() {
        return conductorMapper.toDto(conductorImplementacion.findAllConductor());
    }

    public ConductorDTO get(Long id){ return conductorMapper.toDto(conductorImplementacion.getConductor(id));}

    public void delete(Long id) {
        conductorImplementacion.deleteConductor(id);
    }

}
