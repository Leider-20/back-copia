package co.udea.ssmu.api.model.jpa.repository.services;

import co.udea.ssmu.api.model.jpa.model.services.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
