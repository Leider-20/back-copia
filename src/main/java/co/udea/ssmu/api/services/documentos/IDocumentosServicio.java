package co.udea.ssmu.api.services.documentos;

import co.udea.ssmu.api.model.jpa.model.Documentos;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDocumentosServicio {
    //GET
    @Transactional(readOnly = true)
    List<Documentos> findAllDocumentos();

    //POST
    @Transactional
    Documentos saveDocumento (Documentos documentos);

    //GET ID
    @Transactional(readOnly = true)
    Documentos findDocumento(Long id);

    //DELETE
    @Transactional
    void deleteDocumento(Long id);
}
