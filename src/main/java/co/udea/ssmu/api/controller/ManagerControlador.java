package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.services.manager.ManagerFacade;
import co.udea.ssmu.api.model.jpa.dto.ManagerDTO;
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
    private ManagerFacade managerFacade;

    @GetMapping("/get-all")
    public ResponseEntity<?> ListarManager() {return ResponseEntity.ok(this.managerFacade.findAll());}

    @GetMapping("/get/{id}")
    public ResponseEntity<?>mostrarManager(@PathVariable Long id){
        ManagerDTO manager = null; //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            manager = this.managerFacade.get(id);
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

    @PostMapping("/save")
    public ResponseEntity<?>guardarManager(@Valid @RequestBody ManagerDTO manager, BindingResult result){
        ManagerDTO managerNuevo = null;
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
            managerNuevo = this.managerFacade.save(manager);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir un nuevo manager a la base de datos");
        }
        response.put("mensaje", "El manager se ha REGISTRADO con exito");
        response.put("manager", managerNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteManager(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try{
            this.managerFacade.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
