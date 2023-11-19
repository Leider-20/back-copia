package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoBancariaDTO {
    private Long idBancario;
    private ConductorDTO conductor;
    private String numeroCuenta;
    private String tipoCuenta;
    private String entidadBancaria;
}
