package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.contacto.ContactoFacade;
import co.udea.ssmu.api.model.jpa.dto.ContactoDTO;
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
@RequestMapping("/api/v1/contacto")
public class ContactoControlador {

    private final ContactoFacade contactoFacade;
    private final Messages messages;

    private static final String RESPONSE400 = "La petición es inválida";
    private static final String RESPONSE500 = "Error interno al procesar la respuesta";

    @Autowired
    public ContactoControlador(ContactoFacade contactoFacade, Messages messages) {
        this.contactoFacade = contactoFacade;
        this.messages = messages;
    }

    @GetMapping("/get-all")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "Los contactos fueron consultados exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<List<ContactoDTO>>> listarContacto(){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("contacto.get.all.successful"),
                contactoFacade.findAll()));
    }

    //Buscar conductor por ID
    @GetMapping("/get/{id}")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ContactoDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "El contacto fue consultado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ContactoDTO>>mostrarContacto(@PathVariable Long id){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("contacto.get.successful"),
                contactoFacade.get(id)));
    }

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ContactoDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)},
            description = "El contacto fue guardado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ContactoDTO>>guardarContacto(@Valid @RequestBody ContactoDTO contacto){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("contacto.save.successful"),
                contactoFacade.save(contacto)));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200", description = "El contacto fue eliminado exitosamente")
    @ApiResponse(responseCode = "400", description = RESPONSE400)
    @ApiResponse(responseCode = "500", description = RESPONSE500)
    public ResponseEntity<StandardResponse<ContactoDTO>>deleteContacto(@PathVariable Long id){
        try {
            contactoFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("contacto.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("contacto.delete.error"));
        }
    }
}
