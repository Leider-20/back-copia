package co.udea.ssmu.api.model.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conductor_id")
    private Long conductorId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Column(length = 55)
    private String nombre;

    @Column(length = 55)
    private String apellido;

    @Email
    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String celular;

    @Min(value = 18)
    private Integer edad;

    @Column(length = 120)
    private String direccion;

    @Column(length = 45)
    private String contrasena;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Licencia")
    private Date fechaVencimientoLicencia;

    @Column(length = 30, name = "estado_actividad")
    private String estadoActividad;

    @Column(precision = 2, scale = 1, name = "calificacion_conductor")
    @Digits(integer = 2, fraction = 1)
    private BigDecimal calificacionConductor;

    @Column(length = 45)
    private String clasificacion;

    @Column(length = 45)
    private String ciudad;

    @Column()
    private Integer strikes;

    @Column(length = 7)
    private String placa;

    @Column(length = 25)
    private String marca;

    @Column(length = 25)
    private String modelo;

    @Column(name = "descripcion_Vehiculo")
    private String descripcionVehiculo;

    @Column(name = "anio_Vehiculo")
    private Integer anioVehiculo;

    @Column(length = 17, name = "numero_registro_vehiculo")
    private String numeroRegistroVehiculo;

    @Column(length = 20)
    private String color;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Tecno")
    private Date fechaVencimientoTecno;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Soat")
    private Date fechaVencimientoSoat;
}
