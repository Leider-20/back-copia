package co.udea.ssmu.api.services.conductor;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.repository.ConductorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConductorImplementacion{

    private ConductorRepositorio conductorRepositorio;

    @Autowired
    public ConductorImplementacion(ConductorRepositorio conductorRepositorio) {
        this.conductorRepositorio = conductorRepositorio;
    }

    @Transactional(readOnly = true)
    public List<Conductor> findAllConductor(){
        return conductorRepositorio.findAll();
    }

    public Conductor saveConductor(Conductor conductor){
        return conductorRepositorio.save(conductor);
    }

    @Transactional(readOnly = true)
    public Conductor getConductor(Long id){
        return conductorRepositorio.findById(id).orElse(null);
    }

    public void deleteConductor(Long id){
        conductorRepositorio.deleteById(id);
    }

}
