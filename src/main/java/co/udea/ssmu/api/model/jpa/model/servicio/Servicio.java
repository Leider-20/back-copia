package co.udea.ssmu.api.model.jpa.model.servicio;

import co.udea.ssmu.api.model.jpa.model.conductor.Conductor;
import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import co.udea.ssmu.api.model.jpa.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_conductor")
    private Conductor conductor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ubicacion_origen")
    private Ubicacion ubicacionOrigen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ubicacion_destino")
    private Ubicacion ubicacionDestino;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "id_tipo_servicio")      // Cambiar cuando tenga la tabla TipoServicio
    private Integer idTipoServicio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "detalles")
    private String detalles;

    @Column(name = "id_categoria")      // Cambiar cuando tenga la tabla Categoria
    private Integer idCategoria;

    @Column(name = "estado_pago")
    private String estadoPago;

    @Column(name = "calificacion_conductor")
    private String calificacionConductor;

    @Column(name = "calificacion_usuario")
    private String calificacionUsuario;

    @Column(name = "id_estrategia")     // Cambiar cuando tenga la tabla Estrategia
    private Integer idEstrategia;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "costo")
    private Double costo;
}
