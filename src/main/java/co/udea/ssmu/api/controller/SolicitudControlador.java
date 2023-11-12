package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.solicitud.SolicitudFacade;
import co.udea.ssmu.api.model.jpa.dto.SolicitudDTO;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitud")
public class SolicitudControlador {
    private final SolicitudFacade solicitudFacade;
    private final Messages messages;

    private static final String RESPONSE400 = "La petición es inválida";
    private static final String RESPONSE500 = "Error interno al procesar la respuesta";

    @Autowired
    public SolicitudControlador(SolicitudFacade solicitudFacade, Messages messages) {
        this.solicitudFacade = solicitudFacade;
        this.messages = messages;
    }

    @GetMapping("/get-all")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Las solicitudes fueron consultadas exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<List<SolicitudDTO>>> listarSolicitud() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("solicitud.get.all.successful"),
                solicitudFacade.findAll()));
    }

    @GetMapping("/get/{id}")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = SolicitudDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "La solicitud fue consultada exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<SolicitudDTO>>mostrarContacto(@PathVariable Long id){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("solicitud.get.successful"),
                solicitudFacade.get(id)));
    }

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = SolicitudDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "La solicitud fue guardada exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<SolicitudDTO>>guardarSolicitud(@Valid @RequestBody SolicitudDTO solicitud){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("solicitud.save.successful"),
                solicitudFacade.save(solicitud)));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200", description = "La solicitud fue eliminada exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<SolicitudDTO>>deleteSolicitud(@PathVariable Long id){
        try {
            solicitudFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("solicitud.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("solicitud.delete.error"));
        }
    }
}
