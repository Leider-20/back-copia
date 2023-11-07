package co.udea.ssmu.api.model.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;



@Data
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conductor_id")
    private Long conductorId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Column(length = 55)
    private String nombre;

    @Column(length = 55)
    private String apellido;

    @Email
    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String celular;

    @Min(value = 18)
    private Integer edad;

    @Column(length = 120)
    private String direccion;

    @Column(length = 45)
    private String contrasena;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Licencia")
    private Date fechaVencimientoLicencia;

    @Column(length = 30, name = "estado_actividad")
    private String estadoActividad;

    @Column(precision = 2, scale = 1, name = "calificacion_conductor")
    @Digits(integer = 2, fraction = 1)
    private BigDecimal calificacionConductor;

    @Column(length = 45)
    private String clasificacion;

    @Column(length = 45)
    private String ciudad;

    @Column()
    private Integer strikes;

    @Column(length = 7)
    private String placa;

    @Column(length = 25)
    private String marca;

    @Column(length = 25)
    private String modelo;

    @Column(name = "descripcion_Vehiculo")
    private String descripcionVehiculo;

    @Column(name = "anio_Vehiculo")
    private Integer anioVehiculo;

    @Column(length = 17, name = "numero_registro_vehiculo")
    private String numeroRegistroVehiculo;

    @Column(length = 20)
    private String color;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Tecno")
    private Date fechaVencimientoTecno;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Soat")
    private Date fechaVencimientoSoat;

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(Date fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public String getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(String estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public BigDecimal getCalificacionConductor() {
        return calificacionConductor;
    }

    public void setCalificacionConductor(BigDecimal calificacionConductor) {
        this.calificacionConductor = calificacionConductor;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getStrikes() {
        return strikes;
    }

    public void setStrikes(Integer strikes) {
        this.strikes = strikes;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcionVehiculo() {
        return descripcionVehiculo;
    }

    public void setDescripcionVehiculo(String descripcionVehiculo) {
        this.descripcionVehiculo = descripcionVehiculo;
    }

    public Integer getAnioVehiculo() {
        return anioVehiculo;
    }

    public void setAnioVehiculo(Integer anioVehiculo) {
        this.anioVehiculo = anioVehiculo;
    }

    public String getNumeroRegistroVehiculo() {
        return numeroRegistroVehiculo;
    }

    public void setNumeroRegistroVehiculo(String numeroRegistroVehiculo) {
        this.numeroRegistroVehiculo = numeroRegistroVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaVencimientoTecno() {
        return fechaVencimientoTecno;
    }

    public void setFechaVencimientoTecno(Date fechaVencimientoTecno) {
        this.fechaVencimientoTecno = fechaVencimientoTecno;
    }

    public Date getFechaVencimientoSoat() {
        return fechaVencimientoSoat;
    }

    public void setFechaVencimientoSoat(Date fechaVencimientoSoat) {
        this.fechaVencimientoSoat = fechaVencimientoSoat;
    }
}
