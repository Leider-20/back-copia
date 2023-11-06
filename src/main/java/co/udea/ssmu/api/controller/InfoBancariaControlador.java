package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.IInfoBancariaServicio;
import co.udea.ssmu.api.model.jpa.model.InfoBancaria;
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
@RequestMapping("/api/v1/infobancaria")
public class InfoBancariaControlador {

    @Autowired
    private IInfoBancariaServicio iInfoBancariaServicio;

    @GetMapping
    public ResponseEntity<?> ListarInfoBancaria() {return ResponseEntity.ok(this.iInfoBancariaServicio.findAllInfoBancaria());}

    @GetMapping("{id}")
    public ResponseEntity<?>mostrarInfoBancaria(@PathVariable Long id){
        InfoBancaria infoBancaria = null; //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            infoBancaria = this.iInfoBancariaServicio.findInfoBancaria(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (infoBancaria == null){
            response.put("mensaje", "La información bancaria identificada con el ID: ".concat(id.toString()).concat(" No existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(infoBancaria, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>guardarInfoBancaria(@Valid @RequestBody InfoBancaria infoBancaria, BindingResult result){
        InfoBancaria infoBancariaNueva = null;
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
            infoBancariaNueva = this.iInfoBancariaServicio.saveInfoBancaria(infoBancaria);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir una nueva información bancaria a la base de datos");
        }
        response.put("mensaje", "La información bancaria se ha REGISTRADO con exito");
        response.put("Informacion bancaria", infoBancariaNueva);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
