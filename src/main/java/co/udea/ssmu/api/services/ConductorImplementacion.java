package co.udea.ssmu.api.services;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.repository.ConductorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConductorImplementacion implements IConductorServicio{

    @Autowired
    private ConductorRepositorio conductorRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Conductor> findAllConductor(){
        return conductorRepositorio.findAll();
    }

    @Override
    @Transactional
    public Conductor saveConductor(Conductor conductor){
        return conductorRepositorio.save(conductor);
    }

    @Override
    @Transactional(readOnly = true)
    public Conductor getConductor(Long id){
        return conductorRepositorio.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void deleteConductor(Long id){
        conductorRepositorio.deleteById(id);
    }

}
