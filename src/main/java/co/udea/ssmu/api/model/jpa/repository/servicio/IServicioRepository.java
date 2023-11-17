package co.udea.ssmu.api.model.jpa.repository.servicio;

import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
}
