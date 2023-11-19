package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactoDTO {
    private Long contactoId;
    private String nombre;
    private String apellido;
    private String celular;
    private String tipoRelacion;
    private String direccion;
}
