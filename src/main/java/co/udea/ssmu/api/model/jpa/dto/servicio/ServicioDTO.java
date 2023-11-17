package co.udea.ssmu.api.model.jpa.dto.servicio;

import co.udea.ssmu.api.model.jpa.dto.conductor.ConductorDTO;
import co.udea.ssmu.api.model.jpa.dto.ubicacion.UbicacionDTO;
import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {
    private Integer idServicio;
    private UsuarioDTO usuario;
    private ConductorDTO conductor;
    private UbicacionDTO ubicacionOrigen;
    private UbicacionDTO ubicacionDestino;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer idTipoServicio;
    private String estado;
    private String detalles;
    private Integer idCategoria;
    private String estadoPago;
    private String calificacionConductor;
    private String calificacionUsuario;
    private Integer idEstrategia;
    private String motivo;
    private Double costo;
}
