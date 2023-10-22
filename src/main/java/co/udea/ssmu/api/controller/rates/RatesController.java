package co.udea.ssmu.api.controller.rates;


import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.dto.rates.RatesByCityDTO;
import co.udea.ssmu.api.services.drivers.facade.DriverFacade;
import co.udea.ssmu.api.services.rates.facade.RatesFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Rates", description = "Query Cities")
@RestController
@RequestMapping("/api/rates")
public class RatesController {

    private final RatesFacade ratesFacade;
    private final Messages messages;

    public RatesController(RatesFacade ratesFacade, Messages messages) {
        this.ratesFacade = ratesFacade;
        this.messages = messages;
    }

    @PostMapping("/city")
    @Operation(summary = "Permite guardar un tarifa por ciudad")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = RatesByCityDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La tarifa fue guardada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<RatesByCityDTO>> save(@Valid @RequestBody RatesByCityDTO ratesByCityDTO) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rates.save.successful"),
                ratesFacade.save(ratesByCityDTO)));
    }

}
