package co.udea.ssmu.api.services.documentos;

import co.udea.ssmu.api.model.jpa.dto.DocumentosDTO;
import co.udea.ssmu.api.model.jpa.mapper.DocumentosMapper;

import java.util.List;

public class DocumentosFacade {
    private final DocumentosImplementacion documentosImplementacion;
    private final DocumentosMapper documentosMapper;

    public DocumentosFacade(DocumentosImplementacion documentosImplementacion, DocumentosMapper documentosMapper) {
        this.documentosImplementacion = documentosImplementacion;
        this.documentosMapper = documentosMapper;
    }

    public List<DocumentosDTO> findAll(){ return documentosMapper.toDto(documentosImplementacion.findAllDocumentos());}

    public DocumentosDTO save(DocumentosDTO documentos){
        return documentosMapper.toDto(documentosImplementacion.saveDocumento(documentosMapper.toEntity(documentos)));
    }

    public DocumentosDTO get(Long id){ return documentosMapper.toDto(documentosImplementacion.findDocumento(id));}

    public void delete(Long id){documentosImplementacion.deleteDocumento(id);}
}
