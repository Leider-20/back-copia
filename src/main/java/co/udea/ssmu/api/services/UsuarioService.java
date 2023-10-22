package co.udea.ssmu.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;
import co.udea.ssmu.api.model.jpa.model.TipoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.model.jpa.repository.TipoUsuarioRepository;
import co.udea.ssmu.api.model.jpa.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private TipoUsuarioRepository tipoUsuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.convertirEntidad(usuarioDTO);
        if (this.existeUsuario(usuario)) {
            throw new RuntimeException("El email o el número de documento ya existen.");
        }
        this.asignarTipoUsuario(usuario, 1L);
        return usuarioRepository.save(usuario);
    }

    private void asignarTipoUsuario(Usuario usuario, long idTipoUsuario) {
        TipoUsuario tipoNuevoUsuario = tipoUsuarioRepository.findById(idTipoUsuario).orElse(null);
        usuario.setTipoUsuario(tipoNuevoUsuario);
    }

    private boolean existeUsuario(Usuario usuario) {
        return usuarioRepository.existsByEmailOrNroDocumento(usuario.getEmail(), usuario.getNroDocumento());
    }
}
