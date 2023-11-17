package co.udea.ssmu.api.model.jpa.dto.ubicacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbicacionDTO {
    private Integer idUbicacion;
    private Double latitud;
    private Double longitud;
    private String direccion;
}
