package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {
    private Long managerId;
    private String nombre;
    private String email;
    private String cedula;
    private String rol;
    private String numeroServicios;
    private Long idTipoManager;
}
