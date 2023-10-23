package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacto_id")
    private Long contactoId;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String apellido;

    @Column(length = 10)
    private String celular;

    @Column(length = 20, name = "tipo_Relacion")
    private String tipoRelacion;

}
