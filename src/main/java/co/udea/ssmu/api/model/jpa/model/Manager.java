package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long managerId;

    @Column(length = 45)
    private String nombre;

    @Column(length = 50)
    private String email;

    @Column(length = 10)
    private String cedula;

    @Column(length = 10)
    private String rol;

    @Column(length = 10, name = "numero_Servicios")
    private String numeroServicios;

    @Column(length = 50, name = "id_tipo_manager")
    private Long idTipoManager;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNumeroServicios() {
        return numeroServicios;
    }

    public void setNumeroServicios(String numeroServicios) {
        this.numeroServicios = numeroServicios;
    }

    public Long getIdTipoManager() {
        return idTipoManager;
    }

    public void setIdTipoManager(Long idTipoManager) {
        this.idTipoManager = idTipoManager;
    }
}
