package co.udea.ssmu.api.model.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Lob;
import lombok.Data;


@Entity
@Data
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentos_Id")
    private Long documentosId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @Column(length = 200)
    private String licencia;

    @Column(length = 200, name = "doc_cedula")
    private String docCedula;

    @Column(length = 200, name = "seguro")
    private String soat;

    @Column(length = 200)
    private String tecnomecanica;

    @Column(length = 200, name = "tarjeta_propiedad")
    private String tarjetaPropiedad;

    @Column(length = 200, name = "foto_conductor")
    private String fotoConductor;

    @Column(length = 200, name = "foto_vehiculo")
    private String fotoVehiculo;
}
