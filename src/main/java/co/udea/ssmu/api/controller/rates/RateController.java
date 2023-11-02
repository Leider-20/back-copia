package co.udea.ssmu.api.controller.rates;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.services.rates.facade.RateFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.NoRatesFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rates")
public class RateController {
    private final RateFacade rateFacade;
    private final Messages messages;

    @Autowired
    public RateController(RateFacade rateFacade, Messages messages) {
        this.rateFacade = rateFacade;
        this.messages = messages;
    }

    @GetMapping("/list")
    public List<RateDTO> getRates() {
        List<RateDTO> rates = rateFacade.getAllRates();
        rates.sort(Comparator.comparing(RateDTO::getId));
        return rates;
    }

    @GetMapping("/latest")
    public RateDTO getLatestRate() {
        List<RateDTO> rates = rateFacade.getAllRates();
        if (!rates.isEmpty()) {
            rates.sort(Comparator.comparing(RateDTO::getId).reversed());
            return rates.get(0);
        } else {
            throw new NoRatesFoundException("No se encontraron tarifas.");
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Guardar tarifa base y factor multiplicador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = RateDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La tarifa base y factor multiplicador fueron guardados exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public ResponseEntity<StandardResponse<RateDTO>> save(@Valid @RequestBody RateDTO rateDTO) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rates.save.successful"),
                rateFacade.createRate(rateDTO)));
    }

}
