package co.udea.ssmu.api.services.documentos;

import co.udea.ssmu.api.model.jpa.model.Documentos;
import co.udea.ssmu.api.model.jpa.repository.DocumentosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentosImplementacion implements IDocumentosServicio{

    @Autowired
    private DocumentosRepositorio documentosRepositorio;

    //GET
    @Override
    @Transactional(readOnly = true)
    public List<Documentos> findAllDocumentos() { return documentosRepositorio.findAll();}

    //POST
    @Override
    @Transactional
    public Documentos saveDocumento(Documentos documentos) {return documentosRepositorio.save(documentos);}

    //GET ID
    @Override
    @Transactional(readOnly = true)
    public Documentos findDocumento(Long id) {return documentosRepositorio.findById(id).orElse(null);}

    //DELETE
    @Override
    @Transactional
    public void deleteDocumento(Long id) {documentosRepositorio.deleteById(id);}

}
