package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactoConductorDTO {
    private Long id;
    private ConductorDTO conductor;
    private ContactoDTO contacto;
}
