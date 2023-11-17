package co.udea.ssmu.api.model.jpa.repository.usuario;

import co.udea.ssmu.api.model.jpa.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
