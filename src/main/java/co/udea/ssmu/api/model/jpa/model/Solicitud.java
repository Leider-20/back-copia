package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id")
    private Long solicitudId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Solicitud solicitud;

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
