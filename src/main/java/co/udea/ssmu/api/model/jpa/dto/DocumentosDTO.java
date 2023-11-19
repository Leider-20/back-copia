package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentosDTO {
    private Long documentosId;
    private ConductorDTO conductor;
    private String licencia;
    private String docCedula;
    private String soat;
    private String tecnomecanica;
    private String tarjetaPropiedad;
    private String fotoConductor;
    private String fotoVehiculo;
}
