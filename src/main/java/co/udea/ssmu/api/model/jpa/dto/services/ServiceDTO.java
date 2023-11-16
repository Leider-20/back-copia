package co.udea.ssmu.api.model.jpa.dto.services;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.dto.paymentMethod.PaymentMethodDTO;
import co.udea.ssmu.api.model.jpa.dto.serviceType.ServiceTypeDTO;
import co.udea.ssmu.api.model.jpa.dto.users.UsersDTO;
import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.model.jpa.model.paymentMethod.PaymentMethod;
import co.udea.ssmu.api.model.jpa.model.serviceType.ServiceType;
import co.udea.ssmu.api.model.jpa.model.users.User;
import jakarta.persistence.Column;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ServiceDTO {
    private Integer id;
    private UsersDTO user;
    private DriverDTO driver;
    private Integer ubicacionOrigen;
    private Integer ubicacionDestino;
    private LocalDateTime fecha;
    private ServiceTypeDTO serviceType;
    private String estado;
    private String detalles;
    private String estadoPago;
    private String calificacionConductor;
    private String calificacionUsuario;
    private String motivo;
    private PaymentMethodDTO paymentMethod;
    //private Tarifa tarifa;
    private Double costo;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public ServiceTypeDTO getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeDTO serviceType) {
        this.serviceType = serviceType;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
