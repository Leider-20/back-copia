package co.udea.ssmu.api.model.jpa.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ConductorDTO {
    private Long conductorId;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private Integer edad;
    private String direccion;
    private String contrasena;
    private Date fechaVencimientoLicencia;
    private String estadoActividad;
    private BigDecimal calificacionConductor;
    private String clasificacion;
    private String ciudad;
    private Integer strikes;
    private String placa;
    private String marca;
    private String modelo;
    private String descripcionVehiculo;
    private Integer anioVehiculo;
    private String numeroRegistroVehiculo;
    private String color;
    private Date fechaVencimientoTecno;
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
