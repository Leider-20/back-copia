package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private Long solicitudId;
    private ConductorDTO conductor;
    private ManagerDTO manager;
    private String cedula;
    private String estadoSolicitud;
    private Date fechaEnvio;
    private Date fechaConfirmacion;
}
