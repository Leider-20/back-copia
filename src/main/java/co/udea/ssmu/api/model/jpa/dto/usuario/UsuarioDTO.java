package co.udea.ssmu.api.model.jpa.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private Integer idGrupo;
    private String nombre;
    private String celular;
    private String email;
    private String cedula;
    private String rol;
    private Integer idTipoUsuario;
    private Integer nroServicios;
}
