package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.solicitud.SolicitudFacade;
import co.udea.ssmu.api.model.jpa.dto.SolicitudDTO;
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
@RequestMapping("/api/v1/solicitud")
public class SolicitudControlador {

    @Autowired
    private SolicitudFacade solicitudFacade;

    @GetMapping("/get-all")
    public ResponseEntity<?> ListarSolicitud() {return ResponseEntity.ok(this.solicitudFacade.findAll());}

    @GetMapping("/get/{id}")
    public ResponseEntity<?>mostrarContacto(@PathVariable Long id){
        SolicitudDTO solicitud = null; //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            solicitud = this.solicitudFacade.get(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (solicitud == null){
            response.put("mensaje", "La solicitud identificada con el ID: ".concat(id.toString()).concat(" No existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(solicitud, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?>guardarSolicitud(@Valid @RequestBody SolicitudDTO solicitud, BindingResult result){
        SolicitudDTO solicitudNueva = null;
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
            solicitudNueva = this.solicitudFacade.save(solicitud);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir la nueva solicitud a la base de datos");
        }
        response.put("mensaje", "la solicitud se ha CREADO con exito");
        response.put("contacto", solicitudNueva);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteSolicitud(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try{
            this.solicitudFacade.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
