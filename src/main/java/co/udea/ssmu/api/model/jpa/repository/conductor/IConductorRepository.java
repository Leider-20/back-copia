package co.udea.ssmu.api.model.jpa.repository.conductor;

import co.udea.ssmu.api.model.jpa.model.conductor.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConductorRepository extends JpaRepository<Conductor, Integer> {
}
