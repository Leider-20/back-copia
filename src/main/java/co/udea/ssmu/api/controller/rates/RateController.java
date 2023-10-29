package co.udea.ssmu.api.controller.rates;

import co.udea.ssmu.api.model.jpa.dto.rates.RateDTO;
import co.udea.ssmu.api.services.rates.facade.RateFacade;
import co.udea.ssmu.api.services.rates.service.RateService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Rates", description = "Query basic transportation rates")
@RestController
@RequestMapping("/rates")
@CrossOrigin("*")
public class RateController {
    private final RateFacade rateFacade;
    private final Messages messages;

    public RateController(RateFacade rateFacade, Messages messages){
        this.rateFacade = rateFacade;
        this.messages = messages;
    }

    //POST: guarda una tarifa de transporte sin parada
    @PostMapping("/transportation")
    @Operation(summary = "Permite guardar tarifas de transporte sin paradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = RateDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La tarifa fue guardada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<RateDTO>> save(@Valid @RequestBody RateDTO rateDTO) {
        //System.out.println("########JSON deserializado: " + rateDTO.toString());
        System.out.println("#####################DTO recibido: " + rateDTO.toString());
        System.out.println();

        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("rates.save.successful"),
                rateFacade.save(rateDTO)));

    }

    //lista todas las tarifas existentes
    @GetMapping("/listAll")
    public ResponseEntity<List<RateDTO>> getAllRates() {
        List<RateDTO> rates = rateFacade.getAllRates();
        return ResponseEntity.ok(rates);
    }

    //lista tarifa por id
    @GetMapping("/{id}")
    public ResponseEntity<RateDTO> getRateById(@PathVariable Integer id) {
        RateDTO rate = rateFacade.getRateById(id);
        if (rate != null) {
            return ResponseEntity.ok(rate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}



