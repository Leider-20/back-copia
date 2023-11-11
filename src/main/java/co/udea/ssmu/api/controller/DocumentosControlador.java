package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.documentos.DocumentosFacade;
import co.udea.ssmu.api.model.jpa.dto.DocumentosDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/documentos")
public class DocumentosControlador {

    @Autowired
    private DocumentosFacade documentosFacade;

    @GetMapping("/get-all")
    public ResponseEntity<?> ListarDocumentos() {return ResponseEntity.ok(this.documentosFacade.findAll());}

    @GetMapping("/get/{id}")
    public ResponseEntity<?>mostrarDocumento(@PathVariable Long id){
        DocumentosDTO documentos = null; //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            documentos = this.documentosFacade.get(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (documentos == null){
            response.put("mensaje", "El documento identificado con el ID: ".concat(id.toString()).concat(" No existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?>guardarDocumento(@Valid @RequestBody DocumentosDTO documentos, BindingResult result){
        DocumentosDTO documentosNuevo = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+ err.getField() + "' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            documentosNuevo = this.documentosFacade.save(documentos);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir un nuevo documento a la base de datos");
        }
        response.put("mensaje", "El documento se ha REGISTRADO con exito");
        response.put("documento", documentosNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteDocumentos(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try{
            this.documentosFacade.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
