package co.udea.ssmu.api.services.documentos;

import co.udea.ssmu.api.model.jpa.model.Documentos;
import co.udea.ssmu.api.model.jpa.repository.DocumentosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentosImplementacion{

    private final DocumentosRepositorio documentosRepositorio;

    @Autowired
    public DocumentosImplementacion(DocumentosRepositorio documentosRepositorio) {
        this.documentosRepositorio = documentosRepositorio;
    }

    //GET
    @Transactional(readOnly = true)
    public List<Documentos> findAllDocumentos() { return documentosRepositorio.findAll();}

    //POST
    public Documentos saveDocumento(Documentos documentos) {return documentosRepositorio.save(documentos);}

    //GET ID
    @Transactional(readOnly = true)
    public Documentos findDocumento(Long id) {return documentosRepositorio.findById(id).orElse(null);}

    //DELETE
    public void deleteDocumento(Long id) {documentosRepositorio.deleteById(id);}

}
