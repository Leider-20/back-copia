package co.udea.ssmu.api.services.manager;

import co.udea.ssmu.api.model.jpa.model.Manager;
import co.udea.ssmu.api.model.jpa.repository.ManagerRepositorio;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ManagerImplementacionTest {

    @Mock
    private ManagerRepositorio managerRepositorio;

    @InjectMocks
    private ManagerImplementacion managerImplementacion;

    private Manager manager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        manager = new Manager();
        manager.setManagerId(Long.valueOf(711L));
        manager.setNombre("Cortina Oswald");
        manager.setEmail("daniel@udea.edu.co");
        manager.setCedula("10003719");
        manager.setRol("Lider");
        manager.setNumeroServicios("1000");

    }

    @Test
    void findAllManager() {
        when(managerRepositorio.findAll()).thenReturn(Arrays.asList(manager));
        assertNotNull(managerImplementacion.findAllManager());
        System.out.println(manager);
    }

    @Test
    void saveManager() {

        when(managerRepositorio.save(any(Manager.class))).thenReturn(manager);

        Manager savedManager = managerImplementacion.saveManager(manager);

        assertNotNull(savedManager, "El contacto guardado no puede ser nulo");
        assertEquals("Cortina Oswald", savedManager.getNombre(), "el nombre del contaco guardado no coince");

        verify(managerRepositorio, times(1)).save(eq(manager));
        System.out.println("El manager registrado es: "+manager);
    }

    @Test
    void findManager() {
        when(managerRepositorio.findById(eq(711L))).thenReturn(Optional.of(manager));
        Manager managerObtenido = managerImplementacion.findManager(711L);

        verify(managerRepositorio, times(1)).findById(eq(711L));
        assertNotNull(managerObtenido);
        assertEquals("Cortina Oswald", managerObtenido.getNombre());

        System.out.println(manager);
    }

    @Test
    void deleteManager() {
        Long managerId = 714L;

        when(managerRepositorio.findById(eq(managerId))).thenReturn(Optional.of(new Manager()));
        managerImplementacion.deleteManager(managerId);

        verify(managerRepositorio, times(1)).deleteById(eq(managerId));
        verify(managerRepositorio, never()).findById(eq(managerId));
        verify(managerRepositorio, times(1)).deleteById(eq(managerId));
        System.out.println("Id del manager eliminado es:"+managerId);
    }
}