package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.conductor.ConductorFacade;
import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;
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
@RequestMapping("/api/v1/conductores")
public class ConductorControlador {

    private final ConductorFacade conductorFacade;
    private final Messages messages;

    private static final String RESPONSE400 = "La petición es inválida";
    private static final String RESPONSE500 = "Error interno al procesar la respuesta";

    @Autowired
    public ConductorControlador(ConductorFacade conductorFacade, Messages messages) {
        this.conductorFacade = conductorFacade;
        this.messages = messages;
    }

    //Buscar todos los conductores
    @GetMapping("/get-all")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Los conductores fueron consultados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<List<ConductorDTO>>> listarConductor(){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("conductor.get.all.successful"),
                conductorFacade.findAll()));
    }

    //Buscar conductor por ID
    @GetMapping("/get/{id}")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ConductorDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "El conductor fue consultado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ConductorDTO>>mostrarConductor(@PathVariable Long id){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("conductor.get.successful"),
                conductorFacade.get(id)));
    }

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ConductorDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "El conductor fue guardado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ConductorDTO>>guardarConductor(@Valid @RequestBody ConductorDTO conductor){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("conductor.save.successful"),
                conductorFacade.save(conductor)));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200", description = "El conductor fue eliminado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ConductorDTO>>deleteConductor(@PathVariable Long id){
        try {
            conductorFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("conductor.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("conductor.delete.error"));
        }
    }
}
