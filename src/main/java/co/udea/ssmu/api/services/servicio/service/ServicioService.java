package co.udea.ssmu.api.services.servicio.service;

import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import co.udea.ssmu.api.model.jpa.repository.servicio.IServicioRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import jakarta.transaction.Transactional;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioService {

    private final IServicioRepository servicioRepository;
    private final Messages messages;

    public ServicioService(IServicioRepository servicioRepository, Messages messages) {
        this.servicioRepository = servicioRepository;
        this.messages = messages;
    }

    public Servicio create(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio aceptar(Integer id) {
        Optional<Servicio> servicioAux = servicioRepository.findById(id);

        Servicio servicio = servicioAux.orElseThrow(() -> new BusinessException(messages.get("servicio.does.not.exist")));

        servicio.setEstado("Aceptado");
        return servicioRepository.save(servicio);
    }

    public void rechazar(Integer id) {
        servicioRepository.findById(id)
                .orElseThrow(() -> new BusinessException(String.format(messages.get("servicio.delete.find.error"), id)));
        servicioRepository.deleteById(id);
    }

    //Bad optimization. It would be better to create a method at servicioRepository that returns Costo directly
    public Double getCostoById(Integer id){
        Optional<Servicio> servicioAux = servicioRepository.findById(id);

        Servicio servicio = servicioAux.orElseThrow(() -> new BusinessException(messages.get("servicio.does.not.exist")));

        return servicio.getCosto();
    }

    public Servicio getServicioById(Integer id){
        Optional<Servicio> servicioAux = servicioRepository.findById(id);

        return servicioAux.orElseThrow(() -> new BusinessException(messages.get("servicio.does.not.exist")));
    }
}