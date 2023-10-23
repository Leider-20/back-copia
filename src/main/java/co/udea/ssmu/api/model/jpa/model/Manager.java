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
    private String usuario;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String contrasena;
}
