package co.udea.ssmu.api.services.manager;

import co.udea.ssmu.api.model.jpa.model.Manager;
import co.udea.ssmu.api.model.jpa.repository.ManagerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerImplementacion implements  IManagerServicio{

    @Autowired
    private ManagerRepositorio managerRepositorio;

    //GET
    @Override
    @Transactional(readOnly = true)
    public List<Manager> findAllManager() { return managerRepositorio.findAll();}

    //POST
    @Override
    @Transactional
    public Manager saveManager(Manager manager) {return managerRepositorio.save(manager);}

    //GET ID
    @Override
    @Transactional(readOnly = true)
    public Manager findManager (Long id) {return managerRepositorio.findById(id).orElse(null);}

    @Override
    @Transactional
    public void deleteManager (Long id) {managerRepositorio.deleteById(id);}

}
