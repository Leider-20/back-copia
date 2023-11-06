package co.udea.ssmu.api.services.solicitud;

import co.udea.ssmu.api.model.jpa.model.Solicitud;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISolicitudServicio {
    //GET
    @Transactional(readOnly = true)
    List<Solicitud> findAllSolicitud();

    //POST
    @Transactional
    Solicitud saveSolicitud(Solicitud solicitud);

    //GET ID
    @Transactional(readOnly = true)
    Solicitud findSolicitud(Long id);

    //DELETE
    @Transactional
    void deleteSolicitud(Long id);
}
