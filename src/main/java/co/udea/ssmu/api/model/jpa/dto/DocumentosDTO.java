package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;

public class DocumentosDTO {
    private Long documentosId;
    private ConductorDTO conductor;
    private String licencia;
    private String docCedula;
    private String soat;
    private String tecnomecanica;
    private String tarjetaPropiedad;
    private String fotoConductor;
    private String fotoVehiculo;

    public Long getDocumentosId() {
        return documentosId;
    }

    public void setDocumentosId(Long documentosId) {
        this.documentosId = documentosId;
    }

    public ConductorDTO getConductor() {
        return conductor;
    }

    public void setConductor(ConductorDTO conductor) {
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
