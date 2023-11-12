package co.udea.ssmu.api.services.solicitud;

import co.udea.ssmu.api.model.jpa.model.Solicitud;
import co.udea.ssmu.api.model.jpa.repository.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SolicitudImplementacion{

    @Autowired
    private SolicitudRepositorio solicitudRepositorio;

    //GET
    @Transactional(readOnly = true)
    public List<Solicitud> findAllSolicitud() {return solicitudRepositorio.findAll();}

    //POST
    public Solicitud saveSolicitud(Solicitud solicitud) {return  solicitudRepositorio.save(solicitud);}

    //GET ID
    @Transactional(readOnly = true)
    public Solicitud findSolicitud(Long id) {return solicitudRepositorio.findById(id).orElse(null);}

    //DELETE
    public void deleteSolicitud(Long id) { solicitudRepositorio.deleteById(id);}
}
