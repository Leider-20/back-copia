package co.udea.ssmu.api.model.jpa.dto.conductor;

public class ConductorDTO {
    private Integer idConductor;
    private String nombre;
    private String celular;
    private String email;
    private String cedula;
    private String rol;
    private Integer idTipoUsuario;
    private Integer nroServicios;
    private String placa;

    public ConductorDTO() {
    }

    public ConductorDTO(Integer idConductor, String nombre, String celular, String email, String cedula, String rol, Integer idTipoUsuario, Integer nroServicios, String placa) {
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
        this.cedula = cedula;
        this.rol = rol;
        this.idTipoUsuario = idTipoUsuario;
        this.nroServicios = nroServicios;
        this.placa = placa;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getNroServicios() {
        return nroServicios;
    }

    public void setNroServicios(Integer nroServicios) {
        this.nroServicios = nroServicios;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
