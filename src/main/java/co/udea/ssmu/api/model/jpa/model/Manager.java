package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long managerId;

    @Column(length = 45)
    private String nombre;

    @Column(length = 50)
    private String email;

    @Column(length = 10)
    private String cedula;

    @Column(length = 10)
    private String rol;

    @Column(length = 10, name = "numero_Servicios")
    private String numeroServicios;

    @Column(length = 50, name = "id_tipo_manager")
    private Long idTipoManager;
}
