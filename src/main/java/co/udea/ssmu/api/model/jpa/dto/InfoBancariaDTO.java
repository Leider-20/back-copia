package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;

public class InfoBancariaDTO {
    private Long idBancario;
    private ConductorDTO conductor;
    private String numeroCuenta;
    private String tipoCuenta;
    private String entidadBancaria;

    public Long getIdBancario() {
        return idBancario;
    }

    public void setIdBancario(Long idBancario) {
        this.idBancario = idBancario;
    }

    public ConductorDTO getConductor() {
        return conductor;
    }

    public void setConductor(ConductorDTO conductor) {
        this.conductor = conductor;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(String entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

}
