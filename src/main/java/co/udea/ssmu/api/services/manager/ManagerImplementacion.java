package co.udea.ssmu.api.services.manager;

import co.udea.ssmu.api.model.jpa.model.Manager;
import co.udea.ssmu.api.model.jpa.repository.ManagerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManagerImplementacion{

    private final ManagerRepositorio managerRepositorio;

    @Autowired
    public ManagerImplementacion(ManagerRepositorio managerRepositorio) {
        this.managerRepositorio = managerRepositorio;
    }

    //GET
    @Transactional(readOnly = true)
    public List<Manager> findAllManager() { return managerRepositorio.findAll();}

    //POST
    public Manager saveManager(Manager manager) {return managerRepositorio.save(manager);}

    //GET ID
    @Transactional(readOnly = true)
    public Manager findManager (Long id) {return managerRepositorio.findById(id).orElse(null);}

    public void deleteManager (Long id) {managerRepositorio.deleteById(id);}

}
