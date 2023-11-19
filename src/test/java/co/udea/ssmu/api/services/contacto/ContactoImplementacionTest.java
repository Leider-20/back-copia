package co.udea.ssmu.api.services.contacto;

import co.udea.ssmu.api.model.jpa.model.Contacto;
import co.udea.ssmu.api.model.jpa.repository.ContactoRepositorio;
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

class ContactoImplementacionTest {

    @Mock
    private ContactoRepositorio contactoRepositorio;

    @InjectMocks
    private ContactoImplementacion contactoImplementacion;

    private Contacto contacto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contacto = new Contacto();
        contacto.setContactoId(Long.valueOf(1001L));
        contacto.setNombre("Gutierrez Oswald");
        contacto.setApellido("Cortina");
        contacto.setCelular("3102580351");
        contacto.setTipoRelacion("Hermano");
        contacto.setDireccion("Udea");

    }
    @Test
    void findAllContacto() {
        when(contactoRepositorio.findAll()).thenReturn(Arrays.asList(contacto));
        assertNotNull(contactoImplementacion.findAllContacto());
        System.out.println(contacto);
    }

    @Test
    void saveContacto() {

        when(contactoRepositorio.save(any(Contacto.class))).thenReturn(contacto);

        Contacto savedContacto = contactoImplementacion.saveContacto(contacto);

        assertNotNull(savedContacto, "El contacto guardado no puede ser nulo");
        assertEquals("Gutierrez Oswald", savedContacto.getNombre(), "el nombre del contaco guardado no coince");

        verify(contactoRepositorio, times(1)).save(eq(contacto));
        System.out.println("El conductor registrado es: "+contacto);

    }

    @Test
    void findContacto() {
        when(contactoRepositorio.findById(eq(1001L))).thenReturn(Optional.of(contacto));
        Contacto contactoObtenido = contactoImplementacion.findContacto(1001L);

        verify(contactoRepositorio, times(1)).findById(eq(1001L));
        assertNotNull(contactoObtenido);
        assertEquals("Gutierrez Oswald", contactoObtenido.getNombre());

        System.out.println(contacto);
    }

    @Test
    void deleteContacto() {

        when(contactoRepositorio.findById(eq(1001L))).thenReturn(Optional.of(new Contacto()));
        contactoImplementacion.deleteContacto(1001L);

        verify(contactoRepositorio, times(1)).deleteById(eq(1001L));
        verify(contactoRepositorio, never()).findById(eq(1001L));
        verify(contactoRepositorio, times(1)).deleteById(eq(1001L));
        System.out.println("Id del contacto eliminado es:"+1001L);
    }
}