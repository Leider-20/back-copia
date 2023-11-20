package co.udea.ssmu.api.model.jpa.model.services;

import java.time.LocalDateTime;
import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.model.jpa.model.paymentMethod.PaymentMethod;
import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import co.udea.ssmu.api.model.jpa.model.serviceType.ServiceType;
import co.udea.ssmu.api.model.jpa.model.users.User;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn (name = "driverId")
    private Driver driver;

    @NotNull
    @Column(name = "ubicacionOrigen")
    private Integer ubicacionOrigen;

    @NotNull
    @Column(name = "ubicacionDestino")
    private Integer ubicacionDestino;

    @NotNull
    @Column(name = "fecha")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn (name = "serviceType")
    private ServiceType serviceType;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @NotNull
    @Column(name = "detalles")
    private String detalles;

    @NotNull
    @Column(name = "estadoPago")
    private String estadoPago;

    @NotNull
    @Column(name = "calificacionServicio")
    private String calificacionServicio;

    @NotNull
    @Column(name = "calificacionUsuario")
    private String calificacionUsuario;

    @NotNull
    @Column(name = "calificacionConductor")
    private String calificacionConductor;

    @NotNull
    @Column(name = "motivo")
    private String motivo;

    @ManyToOne
    @JoinColumn (name = "paymentMethod")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn (name = "rate")
    private Rate rate;

    @NotNull
    @Column(name = "costo")
    private Double costo;

    @NotNull
    @Column(name = "ability")
    private String ability;

    @NotNull
    @Column(name = "allowsPets")
    private Boolean allowsPets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Integer getIdService() {
        return id;
    }

    public void setIdService(Integer id) {
        this.id = id;
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

    public String getCalificacionServicio() {
        return calificacionUsuario;
    }

    public void setCalificacionServicio(String calificacionServicio) {
        this.calificacionServicio = calificacionServicio;
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

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public Boolean getAllowsPets() {
        return allowsPets;
    }

    public void setAllowsPets(Boolean allowsPets) {
        this.allowsPets = allowsPets;
    }
}
