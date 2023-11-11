package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.conductor.ConductorFacade;
import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;
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
@RequestMapping("/api/v1/conductores")
public class ConductorControlador {
    @Autowired
    private ConductorFacade conductorFacade;

    //Buscar todos los conductores
    @GetMapping("/get-all")
    public ResponseEntity<?>ListarConductor(){
        return ResponseEntity.ok(this.conductorFacade.findAll());
    }

    //Buscar conductor por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?>mostrarConductor(@PathVariable Long id){
        ConductorDTO conductor = null;
        //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            conductor = this.conductorFacade.get(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (conductor == null){
           response.put("mensaje", "El conductor identificado con el ID: ".concat(id.toString()).concat(" No existe en la base de datos"));
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(conductor, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?>guardarConductor(@Valid @RequestBody ConductorDTO conductor, BindingResult result){
        ConductorDTO conductorNuevo = null;
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
            conductorNuevo = this.conductorFacade.save(conductor);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir un nuevo conductor a la base de datos");
        }
        response.put("mensaje", "El conductor se ha REGISTRADO con exito");
        response.put("conductor", conductorNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteConductor(@PathVariable Long id){
        //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            this.conductorFacade.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
