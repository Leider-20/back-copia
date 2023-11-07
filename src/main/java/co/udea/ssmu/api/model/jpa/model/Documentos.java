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

    public Long getDocumentosId() {
        return documentosId;
    }

    public void setDocumentosId(Long documentosId) {
        this.documentosId = documentosId;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getDocCedula() {
        return docCedula;
    }

    public void setDocCedula(String docCedula) {
        this.docCedula = docCedula;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public String getTecnomecanica() {
        return tecnomecanica;
    }

    public void setTecnomecanica(String tecnomecanica) {
        this.tecnomecanica = tecnomecanica;
    }

    public String getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(String tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public String getFotoConductor() {
        return fotoConductor;
    }

    public void setFotoConductor(String fotoConductor) {
        this.fotoConductor = fotoConductor;
    }

    public String getFotoVehiculo() {
        return fotoVehiculo;
    }

    public void setFotoVehiculo(String fotoVehiculo) {
        this.fotoVehiculo = fotoVehiculo;
    }
}
