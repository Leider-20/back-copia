package co.udea.ssmu.api.services.infoBancaria;

import co.udea.ssmu.api.model.jpa.model.InfoBancaria;
import co.udea.ssmu.api.model.jpa.repository.InfoBancariaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class InfoBancariaImplementacionTest {

    @Mock
    private InfoBancariaRepositorio infoBancariaRepositorio;

    @InjectMocks
    private InfoBancariaImplementacion infoBancariaImplementacion;

    private InfoBancaria infoBancaria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        infoBancaria = new InfoBancaria();
        infoBancaria.setIdBancario(Long.valueOf(999L));
        infoBancaria.setNumeroCuenta("100000");
        infoBancaria.setTipoCuenta("Ahorros");
        infoBancaria.setEntidadBancaria("Bancolombia");
    }

    @Test
    void findAllInfoBancaria() {
        when(infoBancariaRepositorio.findAll()).thenReturn(Arrays.asList(infoBancaria));
        assertNotNull(infoBancariaImplementacion.findAllInfoBancaria());
        System.out.println(infoBancaria);
    }

    @Test
    void saveInfoBancaria() {
        when(infoBancariaRepositorio.save(any(InfoBancaria.class))).thenReturn(infoBancaria);

        InfoBancaria savedInfo = infoBancariaImplementacion.saveInfoBancaria(infoBancaria);

        assertNotNull(savedInfo, "La info guardada no puede  ser nulo");
        verify(infoBancariaRepositorio, times(1)).save(eq(infoBancaria));
        System.out.println("La información bancaria registrada es: "+infoBancaria);
    }

    @Test
    void findInfoBancaria() {
        when(infoBancariaRepositorio.findById(eq(999L))).thenReturn(Optional.of(infoBancaria));
        InfoBancaria infoObtenida = infoBancariaImplementacion.findInfoBancaria(999L);

        verify(infoBancariaRepositorio, times(1)).findById(eq(999L));
        assertNotNull(infoObtenida);

        System.out.println(infoBancaria);
    }

    @Test
    void deleteInfoBancaria() {
        when(infoBancariaRepositorio.findById(eq(999L))).thenReturn(Optional.of(new InfoBancaria()));
        infoBancariaImplementacion.deleteInfoBancaria(999L);

        verify(infoBancariaRepositorio, times(1)).deleteById(eq(999L));
        verify(infoBancariaRepositorio, never()).findById(eq(999L));
        verify(infoBancariaRepositorio, times(1)).deleteById(eq(999L));
        System.out.println("Id de la información bancaria eliminada es:"+999L);
    }
}