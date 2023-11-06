package co.udea.ssmu.api.model.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] licencia;

    @Lob
    @Column(columnDefinition = "BLOB", name = "doc_cedula")
    private byte[] docCedula;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] soat;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] tecnomecanica;

    @Lob
    @Column(columnDefinition = "BLOB", name = "tarjeta_propiedad")
    private byte[] tarjetaPropiedad;

    @Lob
    @Column(columnDefinition = "BLOB", name = "foto_conductor")
    private byte[] fotoConductor;

    @Lob
    @Column(columnDefinition = "BLOB", name = "foto_vehiculo")
    private byte[] fotoVehiculo;
}
