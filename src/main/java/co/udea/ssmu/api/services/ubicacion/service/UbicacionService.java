package co.udea.ssmu.api.services.ubicacion.service;

import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import co.udea.ssmu.api.model.jpa.repository.ubicacion.IUbicacionRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UbicacionService {

    private final IUbicacionRepository ubicacionRepository;
    private final Messages messages;

    public UbicacionService(IUbicacionRepository ubicacionRepository, Messages messages){
        this.ubicacionRepository = ubicacionRepository;
        this.messages = messages;
    }

    public Ubicacion create(Ubicacion ubicacion){
        return ubicacionRepository.save(ubicacion);
    }

    public Ubicacion update(Integer id){
        Optional<Ubicacion> ubicacionAux = ubicacionRepository.findById(id);

        Ubicacion ubicacion = ubicacionAux.orElseThrow(() -> new BusinessException(messages.get("driver.update.does.not.exist")));

        return ubicacionRepository.save(ubicacion);
    }

    public List<Ubicacion> findAll(){
        return ubicacionRepository.findAll();
    }

    public Ubicacion findByDireccion(String direccion){
        Optional<Ubicacion> ubicacionAux = ubicacionRepository.findByDireccion(direccion);

        return ubicacionAux.orElseThrow(() -> new BusinessException(messages.get("driver.update.does.not.exist")));
    }

    public void delete(Integer id){
        ubicacionRepository.findById(id).orElseThrow(() ->
                new BusinessException(String.format(messages.get("location.delete.find.error"), id)));
        this.ubicacionRepository.deleteById(id);
    }
}
