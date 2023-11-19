package co.udea.ssmu.api.services.solicitud;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.model.Solicitud;
import co.udea.ssmu.api.model.jpa.repository.SolicitudRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class SolicitudImplementacionTest {

    @Mock
    private SolicitudRepositorio solicitudRepositorio;

    @InjectMocks
    private SolicitudImplementacion solicitudImplementacion;

    private Solicitud solicitud;
    private Conductor conductor;
    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        solicitud = new Solicitud();
        conductor = new Conductor();
        solicitud.setSolicitudId(Long.valueOf(777L));
        solicitud.setCedula("99999");
        solicitud.setEstadoSolicitud("Pendiente");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate fechaEnvio = LocalDate.parse("12-01-12", formatter);
        solicitud.setFechaEnvio(java.sql.Date.valueOf(fechaEnvio));
        solicitud.setFechaConfirmacion(java.sql.Date.valueOf(fechaEnvio));
    }

    @Test
    void findAllSolicitud() {
        when(solicitudRepositorio.findAll()).thenReturn(Arrays.asList(solicitud));
        assertNotNull(solicitudImplementacion.findAllSolicitud());
        System.out.println(solicitud);
    }

    @Test
    void saveSolicitud() {
        when(solicitudRepositorio.save(any(Solicitud.class))).thenReturn(solicitud);

        Solicitud saveSolicitud = solicitudImplementacion.saveSolicitud(solicitud);

        assertNotNull(saveSolicitud, "La solicitud guardada no puede ser nulo");

        verify(solicitudRepositorio, times(1)).save(eq(solicitud));
        System.out.println("La solicitud registrada es: "+solicitud);
    }

    @Test
    void findSolicitud() {
        when(solicitudRepositorio.findById(eq(777L))).thenReturn(Optional.of(solicitud));
        Solicitud solicitudObtenida = solicitudImplementacion.findSolicitud(777L);

        verify(solicitudRepositorio, times(1)).findById(eq(777L));
        assertNotNull(solicitudObtenida);
        assertEquals("99999", solicitudObtenida.getCedula());

        System.out.println(solicitud);
    }

    @Test
    void deleteSolicitud() {
        when(solicitudRepositorio.findById(eq(777L))).thenReturn(Optional.of(new Solicitud()));
        solicitudImplementacion.deleteSolicitud(777L);

        verify(solicitudRepositorio, times(1)).deleteById(eq(777L));
        verify(solicitudRepositorio, never()).findById(eq(777L));
        verify(solicitudRepositorio, times(1)).deleteById(eq(777L));
        System.out.println("Id del contacto eliminado es:"+777L);
    }
}