package co.udea.ssmu.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.services.UsuarioFacade;

@RestController

@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try{
            this.usuarioFacade.crearUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido cread correctamente.");
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
