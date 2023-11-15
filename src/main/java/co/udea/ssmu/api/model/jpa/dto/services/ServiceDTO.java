package co.udea.ssmu.api.model.jpa.dto.services;

import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import jakarta.persistence.Column;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ServiceDTO {
    private Integer idService;
    private Integer idUsurious;
    private Integer idConductor;
    //private Usuario usuario;
    private Driver conductor;
    private Integer ubicacionOrigen;
    private Integer ubicacionDestino;
    private LocalDateTime fecha;
    //private TipoServicio tipoServicio;
    private String estado;
    private String detalles;
    private String estadoPago;
    private String calificacionConductor;
    private String calificacionUsuario;
    private String motivo;
    //private MetodoPago metodoPago;
    //private Tarifa tarifa;
    private Double costo;

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public Integer getIdUsurious() {
        return idUsurious;
    }

    public void setIdUsurious(Integer idUsurious) {
        this.idUsurious = idUsurious;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Driver getConductor() {
        return conductor;
    }

    public void setConductor(Driver conductor) {
        this.conductor = conductor;
    }

    public Integer getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(Integer ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public Integer getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(Integer ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getCalificacionConductor() {
        return calificacionConductor;
    }

    public void setCalificacionConductor(String calificacionConductor) {
        this.calificacionConductor = calificacionConductor;
    }

    public String getCalificacionUsuario() {
        return calificacionUsuario;
    }

    public void setCalificacionUsuario(String calificacionUsuario) {
        this.calificacionUsuario = calificacionUsuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
