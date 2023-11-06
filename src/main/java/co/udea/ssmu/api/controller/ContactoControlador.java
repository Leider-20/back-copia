package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.services.contacto.IContactoServicio;
import co.udea.ssmu.api.model.jpa.model.Contacto;
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
@RequestMapping("/api/v1/contacto")
public class ContactoControlador {

    @Autowired
    private IContactoServicio contactoServicio;

    @GetMapping
    public ResponseEntity<?> ListarContacto() {return ResponseEntity.ok(this.contactoServicio.findAllContacto());}

    @GetMapping("{id}")
    public ResponseEntity<?>mostrarContacto(@PathVariable Long id){
        Contacto contacto = null; //Mensaje de exito o error
        Map<String, Object> response = new HashMap<>();

        try{
            contacto = this.contactoServicio.findContacto(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al consultar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (contacto == null){
            response.put("mensaje", "El contacto identificado con el ID: ".concat(id.toString()).concat(" No existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>guardarContacto(@Valid @RequestBody Contacto contacto, BindingResult result){
        Contacto contactoNuevo = null;
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
            contactoNuevo = this.contactoServicio.saveContacto(contacto);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al introducir un nuevo contacto a la base de datos");
        }
        response.put("mensaje", "El contacto se ha REGISTRADO con exito");
        response.put("contacto", contactoNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
