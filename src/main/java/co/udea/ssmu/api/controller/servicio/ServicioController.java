package co.udea.ssmu.api.controller.servicio;

import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.services.servicio.facade.ServicioFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.DataBaseException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Servicios", description = "Gestión inicial de servicios")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/servicios")
public class ServicioController {

    private final ServicioFacade servicioFacade;
    private final Messages messages;

    public ServicioController(ServicioFacade servicioFacade, Messages messages) {
        this.servicioFacade = servicioFacade;
        this.messages = messages;
    }

    @PostMapping("/solicitar")
    @Operation(summary = "Permite solicitar un servicio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ServicioDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El servicio fue solicitado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public ResponseEntity<StandardResponse<ServicioDTO>> solicitar(@Valid @RequestBody ServicioDTO servicio) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("servicio.solicitar.succesful"),
                servicioFacade.solicitar(servicio)));
    }

    @PutMapping("/solicitar/{id}/aceptar")
    @Operation(summary = "Permite aceptar una solicitud")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ServicioDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El servicio fue aceptado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public ResponseEntity<StandardResponse<ServicioDTO>> aceptar(@PathVariable Integer id) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("servicio.solicitar.succesful"),
                servicioFacade.aceptar(id)));
    }

    @DeleteMapping("/solicitar/{id}/rechazar")
    @Operation(summary = "Permite descartar una solicitud de servicio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "La solcitud fue rechazada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public ResponseEntity<StandardResponse<Void>> rechazar(@PathVariable Integer id) {
        try {
            servicioFacade.rechazar(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("driver.delete.successful"),
                    StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("driver.delete.error"));
        }
    }

    @GetMapping("/solicitar/{id}")
    @Operation(summary = "Permite obtener el costo de una solicitud de servicio por medio de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud de servicio hallada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public Double getCostoById(@PathVariable Integer id) {
        return servicioFacade.getCostoById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Permite obtener un servicio por medio de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Servicio hallado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public ServicioDTO getServicioById(@PathVariable Integer id) {
        return servicioFacade.getServicioById(id);
    }
}
