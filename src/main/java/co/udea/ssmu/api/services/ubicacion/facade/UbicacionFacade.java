package co.udea.ssmu.api.services.ubicacion.facade;

import co.udea.ssmu.api.model.jpa.dto.ubicacion.UbicacionDTO;
import co.udea.ssmu.api.model.jpa.mapper.ubicacion.UbicacionMapper;
import co.udea.ssmu.api.services.ubicacion.service.UbicacionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UbicacionFacade {

    private final UbicacionService ubicacionService;
    private final UbicacionMapper ubicacionMapper;

    public UbicacionFacade(UbicacionService ubicacionService, UbicacionMapper ubicacionMapper){
        this.ubicacionService = ubicacionService;
        this.ubicacionMapper = ubicacionMapper;
    }

    public UbicacionDTO create(UbicacionDTO ubicacionDTO){
        return ubicacionMapper.toDto(ubicacionService.create(ubicacionMapper.toEntity(ubicacionDTO))) ;
    }

    public UbicacionDTO update(Integer id){
        return ubicacionMapper.toDto(ubicacionService.update(id));
    }

    public List<UbicacionDTO> findAll(){
        return ubicacionMapper.toDto(ubicacionService.findAll());
    }

    public UbicacionDTO findByDireccion(String direccion){
        return ubicacionMapper.toDto(ubicacionService.findByDireccion(direccion));
    }

    public void delete(Integer id){
        ubicacionService.delete(id);
    }
}
