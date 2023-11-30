package co.udea.ssmu.api.controller.admin;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.dto.rate.RateDTO;
import co.udea.ssmu.api.model.jpa.dto.serviceType.ServiceTypeDTO;
import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;
import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import co.udea.ssmu.api.model.jpa.repository.rate.RateRepository;
import co.udea.ssmu.api.services.drivers.facade.DriverFacade;
import co.udea.ssmu.api.services.rate.facade.RateFacade;
import co.udea.ssmu.api.services.rate.service.RateService;
import co.udea.ssmu.api.services.serviceType.facade.ServiceTypeFacade;
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

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Admin", description = "Gestión de administrador")
@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    @Autowired
    private RateRepository rateRepository;
    private final RateFacade rateFacade;

    private final RateService rateService;

    private final ServiceTypeFacade serviceTypeFacade;
    private final Messages messages;

    public AdminController(RateFacade rateFacade, ServiceTypeFacade serviceTypeFacade,
                           Messages messages, RateService rateService) {
        this.rateFacade = rateFacade;
        this.serviceTypeFacade = serviceTypeFacade;
        this.messages = messages;
        this.rateService = rateService;
    }

    @PutMapping("/rate/update")
    @Operation(summary = "Permite actualizar la informacion de tarifa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = RateDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La Tarifa fua actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<RateDTO>> update(@Valid @RequestBody RateDTO rate) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rate.update.successful"),
                rateFacade.update(rate)));
    }

    @PutMapping("/rate/update-multiplier-factor")
    @Operation(summary = "Permite actualizar el factor multiplicador de la tarifa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Rate.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La Tarifa fua actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Rate>> updateMultFactor(@Valid @RequestBody Double multFactor, Integer id) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rate.update.successful"),
                rateFacade.updateMultFactor(multFactor, id)));
    }

    @PutMapping("/rate/update-base")
    @Operation(summary = "Permite actualizar la tarifa Base")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Rate.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La Tarifa fua actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Rate>> updateBase(@Valid @RequestBody Double base, Integer id) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rate.update.successful"),
                rateService.updateBaseRate(base, id)));
    }

    @PostMapping("/rate/save")
    @Operation(summary = "Permite guardar una nueva tarifa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Rate.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La Tarifa fue guardada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Rate>> save(@Valid @RequestBody Rate rate) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rate.save.successful"),
                rateRepository.save(rate)));

    }

    @PostMapping("/serviceType/save")
    @Operation(summary = "Permite guardar un nuevo tipo de servicio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ServiceTypeDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El tipo de servicio fue guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ServiceTypeDTO>> save(@Valid @RequestBody ServiceTypeDTO serviceType) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rate.save.successful"),
                serviceTypeFacade.save(serviceType)));
    }


    @GetMapping("/rate/get-all")
    @Operation(summary = "Permite consultar todas las tarifas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Las tarifas fueron consultadas exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<RateDTO>>> findAll() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rate.get.all.successful"),
                rateFacade.findByAll()));
    }


}
