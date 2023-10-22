package co.udea.ssmu.api.model.jpa.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String password;
    private String nroDocumento;
    private String rol;
    private String nroServicios;
}
