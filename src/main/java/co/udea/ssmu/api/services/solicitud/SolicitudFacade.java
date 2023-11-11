package co.udea.ssmu.api.services.solicitud;

import co.udea.ssmu.api.model.jpa.dto.SolicitudDTO;
import co.udea.ssmu.api.model.jpa.mapper.SolicitudMapper;

import java.util.List;

public class SolicitudFacade {
    private final SolicitudImplementacion solicitudImplementacion;
    private final SolicitudMapper solicitudMapper;

    public SolicitudFacade(SolicitudImplementacion solicitudImplementacion, SolicitudMapper solicitudMapper) {
        this.solicitudImplementacion = solicitudImplementacion;
        this.solicitudMapper = solicitudMapper;
    }

    public List<SolicitudDTO> findAll(){return solicitudMapper.toDto(solicitudImplementacion.findAllSolicitud());}

    public SolicitudDTO save(SolicitudDTO solicitud){
        return solicitudMapper.toDto(solicitudImplementacion.saveSolicitud(solicitudMapper.toEntity(solicitud)));
    }

    public SolicitudDTO get(Long id){return solicitudMapper.toDto(solicitudImplementacion.findSolicitud(id));}

    public void delete(Long id){solicitudImplementacion.deleteSolicitud(id);}
}
