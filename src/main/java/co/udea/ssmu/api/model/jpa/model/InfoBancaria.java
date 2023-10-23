package co.udea.ssmu.api.model.jpa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class InfoBancaria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bancario_id")
    private Long idBancario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @Column(length = 20, name = "numero_cuenta")
    private String numeroCuenta;

    @Column(length = 20, name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(length = 40, name = "entidad_Bancaria")
    private String entidadBancariaa;

    @Digits(integer = 3, fraction = 1)
    private BigDecimal tarifa;

}
