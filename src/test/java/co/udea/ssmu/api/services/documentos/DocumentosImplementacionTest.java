package co.udea.ssmu.api.services.documentos;

import co.udea.ssmu.api.model.jpa.model.Documentos;
import co.udea.ssmu.api.model.jpa.repository.DocumentosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class DocumentosImplementacionTest {

    @Mock
    private DocumentosRepositorio documentosRepositorio;

    @InjectMocks
    private DocumentosImplementacion documentosImplementacion;

    private Documentos documentos;
    @BeforeEach
    void setUp() {

    }

    @Test
    void findAllDocumentos() {
    }

    @Test
    void saveDocumento() {
    }

    @Test
    void findDocumento() {
    }

    @Test
    void deleteDocumento() {
    }
}