package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;
import co.udea.ssmu.api.model.jpa.dto.ManagerDTO;

import java.util.Date;

public class SolicitudDTO {
    private Long solicitudId;
    private ConductorDTO conductor;
    private ManagerDTO manager;
    private String cedula;
    private String estadoSolicitud;
    private Date fechaEnvio;
    private Date fechaConfirmacion;

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public ConductorDTO getConductor() {
        return conductor;
    }

    public void setConductor(ConductorDTO conductor) {
        this.conductor = conductor;
    }

    public ManagerDTO getManager() {
        return manager;
    }

    public void setManager(ManagerDTO manager) {
        this.manager = manager;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

}
