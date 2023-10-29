package co.udea.ssmu.api.model.jpa.repository;

import co.udea.ssmu.api.model.jpa.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Long> {
}
