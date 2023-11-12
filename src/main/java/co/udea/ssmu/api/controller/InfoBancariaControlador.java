package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.infoBancaria.InfoBancariaFacade;
import co.udea.ssmu.api.model.jpa.dto.InfoBancariaDTO;
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
@RequestMapping("/api/v1/infobancaria")
public class InfoBancariaControlador {

    private final InfoBancariaFacade infoBancariaFacade;
    private final Messages messages;

    private static final String RESPONSE400 = "La petición es inválida";
    private static final String RESPONSE500 = "Error interno al procesar la respuesta";

    @Autowired
    public InfoBancariaControlador(InfoBancariaFacade infoBancariaFacade, Messages messages) {
        this.infoBancariaFacade = infoBancariaFacade;
        this.messages = messages;
    }

    @GetMapping("/get-all")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Las Informaciones Bancarias fueron consultadas exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<List<InfoBancariaDTO>>> listarInfoBancaria() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("infoBancaria.get.all.successful"),
                infoBancariaFacade.findAll()));
    }

    @GetMapping("/get/{id}")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = InfoBancariaDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "La informacion bancaria fue consultada exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<InfoBancariaDTO>>mostrarInfoBancaria(@PathVariable Long id){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("infoBancaria.get.successful"),
                infoBancariaFacade.get(id)));
    }

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = InfoBancariaDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "La informacion bancaria fue guardada exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<InfoBancariaDTO>>guardarInfoBancaria(@Valid @RequestBody InfoBancariaDTO infoBancaria){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("infoBancaria.save.successful"),
                infoBancariaFacade.save(infoBancaria)));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200", description = "La informacion bancaria fue eliminada exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<InfoBancariaDTO>>deleteInfoBancaria(@PathVariable Long id){
        try {
            infoBancariaFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("infoBancaria.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("infoBancaria.delete.error"));
        }
    }

}
