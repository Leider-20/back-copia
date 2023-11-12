package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.documentos.DocumentosFacade;
import co.udea.ssmu.api.model.jpa.dto.DocumentosDTO;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.DataBaseException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documentos")
public class DocumentosControlador {

    private final DocumentosFacade documentosFacade;
    private final Messages messages;

    private static final String RESPONSE400 = "La petición es inválida";
    private static final String RESPONSE500 = "Error interno al procesar la respuesta";

    @Autowired
    public DocumentosControlador(DocumentosFacade documentosFacade, Messages messages) {
        this.documentosFacade = documentosFacade;
        this.messages = messages;
    }

    @GetMapping("/get-all")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Los documentos fueron consultados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<List<DocumentosDTO>>> listarDocumentos() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("documentos.get.all.successful"),
                documentosFacade.findAll()));
    }

    @GetMapping("/get/{id}")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = DocumentosDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Los documentos del conductor fueron consultados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<DocumentosDTO>>mostrarDocumento(@PathVariable Long id){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("documentos.get.successful"),
                documentosFacade.get(id)));
    }

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = DocumentosDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Los documentos fueron guardados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<DocumentosDTO>>guardarDocumento(@Valid @RequestBody DocumentosDTO documentos, @RequestPart List<MultipartFile> files){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("documentos.save.successful"),
                documentosFacade.save(documentos,files)));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200", description = "Los documentos del conductor fueron eliminados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<DocumentosDTO>>deleteDocumentos(@PathVariable Long id){
        try {
            documentosFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("documentos.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("documentos.delete.error"));
        }
    }
}
