package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.manager.ManagerFacade;
import co.udea.ssmu.api.model.jpa.dto.ManagerDTO;
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
@RequestMapping("/api/v1/manager")
public class ManagerControlador {

    private final ManagerFacade managerFacade;
    private final Messages messages;

    private static final String RESPONSE400 = "La petición es inválida";
    private static final String RESPONSE500 = "Error interno al procesar la respuesta";

    @Autowired
    public ManagerControlador(ManagerFacade managerFacade, Messages messages) {
        this.managerFacade = managerFacade;
        this.messages = messages;
    }

    @GetMapping("/get-all")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Los managers fueron consultados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<List<ManagerDTO>>> listarManager() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("manager.get.all.successful"),
                managerFacade.findAll()));
    }

    @GetMapping("/get/{id}")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ManagerDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "El manger fue consultado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ManagerDTO>>mostrarManager(@PathVariable Long id){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("manager.get.successful"),
                managerFacade.get(id)));
    }

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ManagerDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "El manager fue guardado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ManagerDTO>>guardarManager(@Valid @RequestBody ManagerDTO manager){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("manager.save.successful"),
                managerFacade.save(manager)));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200", description = "El manager fue eliminado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ManagerDTO>>deleteManager(@PathVariable Long id){
        try {
            managerFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("manager.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("manager.delete.error"));
        }
    }
}
