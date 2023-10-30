package co.udea.ssmu.api.model.jpa.repository.policies;

import co.udea.ssmu.api.model.jpa.model.policies.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer> {
}
