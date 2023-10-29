package co.udea.ssmu.api.model.jpa.repository;

import co.udea.ssmu.api.model.jpa.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepositorio extends JpaRepository <Solicitud, Long> {
}
