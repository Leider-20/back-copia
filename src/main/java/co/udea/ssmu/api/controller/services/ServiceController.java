package co.udea.ssmu.api.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.udea.ssmu.api.model.jpa.model.services.Service;
import co.udea.ssmu.api.model.jpa.repository.services.ServiceRepository;

@RestController
@RequestMapping("/servicio")
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @GetMapping("/consultar")
    public List<Service> findAll(){
        return repository.findAll();
    }

    @PostMapping("/guardar")
    public void save(){
    }
}

