package co.udea.ssmu.api.controller.rate;

import org.springframework.beans.factory.annotation.Autowired;
import co.udea.ssmu.api.model.jpa.model.rate.Rate;
import co.udea.ssmu.api.model.jpa.repository.rate.RateRepository;
import co.udea.ssmu.api.services.rate.facade.RateFacade;
import co.udea.ssmu.api.services.rate.service.RateService;
import co.udea.ssmu.api.services.serviceType.facade.ServiceTypeFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.TarifaNotFoundException;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.DataBaseException;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/api/tarifa")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping("/calcular-tarifa-total")
    @Operation(summary = "Calcula la tarifa total según la distancia recorrida")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Double.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La tarifa total fue calculada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<Double> calcularTarifaTotal(@RequestParam Double distanciaRecorrida) {
        try {
            Double tarifaTotal = rateService.calcularTarifaTotal(distanciaRecorrida);
            return ResponseEntity.ok(tarifaTotal);
        } catch (TarifaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

