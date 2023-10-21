package co.udea.ssmu.api.controller.cities;


import co.udea.ssmu.api.model.jpa.dto.cities.CityDTO;
import co.udea.ssmu.api.services.cities.facade.CityFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Cities", description = "Query Cities")
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityFacade cityFacade;
    private final Messages messages;


    public CityController(CityFacade cityFacade, Messages messages) {
        this.cityFacade = cityFacade;
        this.messages = messages;
    }

    @GetMapping("/get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Las ciudades fueron consultados exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<CityDTO>>> findAll() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("driver.get.all.successful"),
                cityFacade.findAll()));
    }

}
