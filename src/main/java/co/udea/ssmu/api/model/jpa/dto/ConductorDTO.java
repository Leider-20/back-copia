package co.udea.ssmu.api.model.jpa.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConductorDTO {
    private Long conductorId;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private Integer edad;
    private String direccion;
    private String contrasena;
    private Date fechaVencimientoLicencia;
    private String estadoActividad;
    private BigDecimal calificacionConductor;
    private String clasificacion;
    private String ciudad;
    private Integer strikes;
    private String placa;
    private String marca;
    private String modelo;
    private String descripcionVehiculo;
    private Integer anioVehiculo;
    private String numeroRegistroVehiculo;
    private String color;
    private Date fechaVencimientoTecno;
    private Date fechaVencimientoSoat;
}
