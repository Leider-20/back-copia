package co.udea.ssmu.api.services;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import java.util.List;

public interface IConductorServicio {
    List<Conductor> findAllConductor();

    Conductor saveConductor(Conductor conductor);

    Conductor getConductor(Long id);

    void deleteConductor(Long id);
}
