package co.udea.ssmu.api.model.jpa.repository;

import co.udea.ssmu.api.model.jpa.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepositorio extends JpaRepository <Manager, Long> {
}
