package co.udea.ssmu.api.model.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id")
    private Long solicitudId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(length = 15)
    private String cedula;

    @Column(length = 10, name = "estado_Solicitud")
    private String estadoSolicitud;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Envio")
    private Date fechaEnvio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Confirmacion")
    private Date fechaConfirmacion;
}
