package co.udea.ssmu.api.controller.services;

import java.util.List;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.dto.services.ServiceDTO;
import co.udea.ssmu.api.services.drivers.facade.DriverFacade;
import co.udea.ssmu.api.services.services.facade.ServiceFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.udea.ssmu.api.model.jpa.model.services.Service;
import co.udea.ssmu.api.model.jpa.repository.services.ServiceRepository;

import javax.validation.Valid;

@RestController
@Tag(name = "Services", description = "Gestión de servicios")
@RequestMapping("/servicio")
public class ServiceController {

    private final ServiceFacade serviceFacade;

    @Autowired
    private ServiceRepository repository;

    public ServiceController(ServiceFacade serviceFacade) {
        this.serviceFacade = serviceFacade;
    }

    @GetMapping("/consultar")
    public List<Service> findAll(){
        return repository.findAll();
    }

    @GetMapping("/get-by-driver")
    @Operation(summary = "Permite consultar los servicion de acuerdo a las condiciones del conductor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Los servicios fueron consultados exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<ServiceDTO>>> findByDriver(Integer id) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                serviceFacade.findByDriver(id)));
    }

    @PostMapping("/save")
    @Operation(summary = "Permite guardar un servicio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ServiceDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El servicio fue guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ServiceDTO>> save(@Valid @RequestBody ServiceDTO service) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                serviceFacade.save(service)));
    }

    @PutMapping("/accept-service/{id}")
    @Operation(summary = "Permite aceptar la solicitud de servicio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = DriverDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El servicio fue aceptado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ServiceDTO>> update(@Valid @RequestBody Integer idDriver, @Valid @PathVariable Integer id) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
//                messages.get("driver.update.successful"),
                serviceFacade.acceptService(id, idDriver)));
    }

}

