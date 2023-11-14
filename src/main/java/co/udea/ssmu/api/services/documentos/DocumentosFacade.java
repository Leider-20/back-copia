package co.udea.ssmu.api.services.documentos;

import co.udea.ssmu.api.model.jpa.dto.DocumentosDTO;
import co.udea.ssmu.api.model.jpa.mapper.DocumentosMapper;
import co.udea.ssmu.api.services.FileStorageService;
import org.apache.http.entity.ContentType;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.apache.http.entity.ContentType.*;

public class DocumentosFacade {
    private final DocumentosImplementacion documentosImplementacion;
    private final DocumentosMapper documentosMapper;

    private FileStorageService fileStorageService;

    public DocumentosFacade(DocumentosImplementacion documentosImplementacion, DocumentosMapper documentosMapper) {
        this.documentosImplementacion = documentosImplementacion;
        this.documentosMapper = documentosMapper;
    }

    public List<DocumentosDTO> findAll(){ return documentosMapper.toDto(documentosImplementacion.findAllDocumentos());}

    public DocumentosDTO save(DocumentosDTO documentos, List<MultipartFile> files){
        Long conductorId = documentos.getConductor().getConductorId();
        List<String> urls = saveS3Documents(conductorId, files);
        setUrls(urls, documentos);
        return documentosMapper.toDto(documentosImplementacion.saveDocumento(documentosMapper.toEntity(documentos)));
    }

    public DocumentosDTO get(Long id){
        return documentosMapper.toDto(documentosImplementacion.findDocumento(id));
    }

    public void delete(Long id){
        DocumentosDTO documentos = documentosMapper.toDto(documentosImplementacion.findDocumento(id));
        List<String> urls = getUrls(documentos);
        deleteS3Documents(urls, documentos.getConductor().getConductorId());
        documentosImplementacion.deleteDocumento(id);
    }

    public List<String> saveS3Documents(Long conductorId, List<MultipartFile> files){
        List<String> urls = new ArrayList<>();
        for (MultipartFile file:files) {
            if (Objects.equals(file.getContentType(), ContentType.getByMimeType("application/pdf").toString())){
                    urls.add(fileStorageService.createFilePdf(file,conductorId, file.getName()));
            }else if (Arrays.asList(IMAGE_JPEG.getMimeType(),
                        IMAGE_PNG.getMimeType(),
                        IMAGE_BMP.getMimeType()).contains(file.getContentType())){
                    urls.add(fileStorageService.createFileImage(file,conductorId, file.getName()));
            }
        }
        return urls;
    }

    public void deleteS3Documents(List<String> urls, Long conductorId){
        for (String url:urls) {
            String fileName = url.substring(url.lastIndexOf("/") + 1);
            fileStorageService.deleteFile(fileName, conductorId);
        }
    }

    public void setUrls(List<String> urls, DocumentosDTO documentos){
        documentos.setLicencia(urls.get(0));
        documentos.setDocCedula(urls.get(1));
        documentos.setSoat(urls.get(2));
        documentos.setTecnomecanica(urls.get(3));
        documentos.setTarjetaPropiedad(urls.get(4));
        documentos.setFotoConductor(urls.get(5));
        documentos.setFotoVehiculo(urls.get(6));
    }

    public List<String> getUrls(DocumentosDTO documentos){
        List<String> urls = new ArrayList<>();
        urls.add(documentos.getLicencia());
        urls.add(documentos.getDocCedula());
        urls.add(documentos.getSoat());
        urls.add(documentos.getTecnomecanica());
        urls.add(documentos.getTarjetaPropiedad());
        urls.add(documentos.getFotoConductor());
        urls.add(documentos.getFotoVehiculo());
        return urls;
    }
}
