package co.udea.ssmu.api.model.jpa.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class InfoBancaria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bancario_id")
    private Long idBancario;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @Column(length = 20, name = "numero_cuenta")
    private String numeroCuenta;

    @Column(length = 20, name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(length = 40, name = "entidad_Bancaria")
    private String entidadBancaria;

    public Long getIdBancario() {
        return idBancario;
    }

    public void setIdBancario(Long idBancario) {
        this.idBancario = idBancario;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
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
