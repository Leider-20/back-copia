package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacto_id")
    private Long contactoId;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String apellido;

    @Column(length = 10)
    private String celular;

    @Column(length = 20, name = "tipo_Relacion")
    private String tipoRelacion;

    @Column(length = 10)
    private String direccion;

    public Long getContactoId() {
        return contactoId;
    }

    public void setContactoId(Long contactoId) {
        this.contactoId = contactoId;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
