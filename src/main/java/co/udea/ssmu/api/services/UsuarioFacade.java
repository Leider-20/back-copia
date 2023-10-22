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

    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO){
        return UsuarioMapper.convertirDTO(usuarioService.actualizarUsuario(usuarioDTO));
    }

    public UsuarioDTO obtenerInformacionUsuario(String nroDocumento){
        return UsuarioMapper.convertirDTO(usuarioService.obtenerInformacionUsuario(nroDocumento));
    }
}
