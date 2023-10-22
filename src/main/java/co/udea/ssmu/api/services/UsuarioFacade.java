package co.udea.ssmu.api.services;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;

public class UsuarioFacade {
    private UsuarioService usuarioService;

    public UsuarioFacade(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO){
        return UsuarioMapper.convertirDTO(usuarioService.crearUsuario(usuarioDTO));
    }
}
