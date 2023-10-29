package co.udea.ssmu.api.model.jpa.repository;

import co.udea.ssmu.api.model.jpa.model.ContactoConductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoConductorRepositorio extends JpaRepository <ContactoConductor, Long> {
}
