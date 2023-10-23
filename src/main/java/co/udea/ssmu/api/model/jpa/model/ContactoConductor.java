package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ContactoConductor {
    @Id
    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @Id
    @ManyToOne
    @JoinColumn(name = "contacto_id")
    private Contacto contacto;
}
