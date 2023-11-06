package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.services.manager.IManagerServicio;
import co.udea.ssmu.api.model.jpa.model.Manager;
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
@RequestMapping("/api/v1/manager")
public class ManagerControlador {

    @Autowired
    private IManagerServicio managerServicio;

    @GetMapping
    public ResponseEntity<?> ListarManager() {return ResponseEntity.ok(this.managerServicio.findAllManager());}

    @GetMapping("{id}")
    public ResponseEntity<?>mostrarManager(@PathVariable Long id){
        Manager manager = null; //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            manager = this.managerServicio.findManager(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (manager == null){
            response.put("mensaje", "El manager identificado con el ID: ".concat(id.toString()).concat(" No existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>guardarManager(@Valid @RequestBody Manager manager, BindingResult result){
        Manager managerNuevo = null;
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
            managerNuevo = this.managerServicio.saveManager(manager);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir un nuevo manager a la base de datos");
        }
        response.put("mensaje", "El manager se ha REGISTRADO con exito");
        response.put("manager", managerNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
