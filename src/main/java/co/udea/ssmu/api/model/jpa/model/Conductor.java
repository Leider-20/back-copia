package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@SuppressWarnings("ALL")
@Data
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conductor_id")
    private Long conductorId;

    @Column(length = 55)
    private String nombre;

    @Column(length = 55)
    private String apellido;

    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String celular;

    @Min(value = 18)
    private int edad;

    @Column(length = 120)
    private String direccion;

    @Column(length = 45)
    private String contrasena;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_Vencimiento_Licencia")
    private Date fechaVencimientoLicencia;

    @Pattern(regexp = "[MF]")
    private char genero;

    @Column(length = 30, nullable = true, name = "estado_actividad")
    private String estadoActividad;

    @Column(precision = 2, scale = 1, nullable = true, name = "calificacion_conductor")
    @Digits(integer = 2, fraction = 1)
    private BigDecimal calificacionConductor;

    @Column(nullable = true, name = "numero_Servicios")
    private int numeroServicios;

    @Column(length = 45, nullable = true)
    private String clasificacion;

    @Column(length = 45)
    private String ciudad;

    @Column(nullable = true)
    private int strikes;

    @Column(length = 7)
    private String placa;

    @Column(length = 25)
    private String marca;

    @Column(length = 25)
    private String modelo;

    @Column(length = 255, name = "descripcion_Vehiculo")
    private String descripcionVehiculo;

    @Column(name = "anio_Vehiculo")
    private int anioVehiculo;

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
