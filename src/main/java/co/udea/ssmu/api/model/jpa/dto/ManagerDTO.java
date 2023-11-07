package co.udea.ssmu.api.model.jpa.dto;

public class ManagerDTO {
    private Long managerId;
    private String nombre;
    private String email;
    private String cedula;
    private String rol;
    private String numeroServicios;
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
