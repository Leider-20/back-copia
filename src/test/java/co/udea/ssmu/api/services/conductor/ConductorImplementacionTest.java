package co.udea.ssmu.api.services.conductor;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.repository.ConductorRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ConductorImplementacionTest {

    @Mock
    private ConductorRepositorio conductorRepositorio;
    @InjectMocks
    private ConductorImplementacion conductorImplementacion;

    private Conductor conductor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        conductor = new Conductor();
        conductor.setConductorId(Long.valueOf(10L));
        conductor.setNombre("Oswald Gutierrez");
        conductor.setApellido("Cortina");
        conductor.setEmail("odaniel@gmail.com");
        conductor.setCelular("3102580351");
        conductor.setEdad(2);
        conductor.setDireccion("Udea");
        conductor.setContrasena("Segura123");
        conductor.setEstadoActividad("Suspendido");
        conductor.setClasificacion("top");
        conductor.setCiudad("Medellin");
        conductor.setStrikes(3);
        conductor.setPlaca("abc123");
        conductor.setMarca("Lamborghini");
        conductor.setModelo("Urus");
        conductor.setDescripcionVehiculo("Soy veloz, mas que veloz, soy un rayo");
        conductor.setAnioVehiculo(2022);
        conductor.setNumeroRegistroVehiculo("199991919191");
        conductor.setColor("amarillo");
    }

    @Test
    void findAllConductor() {
        when(conductorRepositorio.findAll()).thenReturn(Arrays.asList(conductor));
        assertNotNull(conductorImplementacion.findAllConductor()); //Traerá los valores que no sean nulos
        System.out.println(conductor);
    }

    @Test
    void saveConductor() {

        when(conductorRepositorio.save(any(Conductor.class))).thenReturn(conductor);

        Conductor savedConductor = conductorImplementacion.saveConductor(conductor);

        assertNotNull(savedConductor, "El conductor guardado no debería ser nulo");
        assertEquals("Oswald Gutierrez", savedConductor.getNombre(), "El nombre del conductor guardado no coincide");

        verify(conductorRepositorio, times(1)).save(eq(conductor));
        System.out.println("El conductor registrado es: "+conductor);
    }

    @Test
    void getConductor() {
        when(conductorRepositorio.findById(eq(10L))).thenReturn(Optional.of(conductor));
        Conductor conductorObtenido = conductorImplementacion.getConductor(10L);

        verify(conductorRepositorio, times(1)).findById(eq(10L));
        assertNotNull(conductorObtenido);
        assertEquals("Oswald Gutierrez", conductorObtenido.getNombre());

        System.out.println(conductor);
    }

    @Test
    void deleteConductor() {

        when(conductorRepositorio.findById(eq(10L))).thenReturn(Optional.of(new Conductor()));
        conductorImplementacion.deleteConductor(10L);

        verify(conductorRepositorio, times(1)).deleteById(eq(10L));
        verify(conductorRepositorio, never()).findById(eq(10L));
        verify(conductorRepositorio, times(1)).deleteById(eq(10L));
        System.out.println("Id del conductor eliminado es:"+10L);

    }
}