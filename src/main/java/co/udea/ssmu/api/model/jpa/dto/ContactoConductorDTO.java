package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.dto.ConductorDTO;
import co.udea.ssmu.api.model.jpa.dto.ContactoDTO;

public class ContactoConductorDTO {
    private Long id;
    private ConductorDTO conductor;
    private ContactoDTO contacto;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConductorDTO getConductor() {
        return conductor;
    }

    public void setConductor(ConductorDTO conductor) {
        this.conductor = conductor;
    }

    public ContactoDTO getContacto() {
        return contacto;
    }

    public void setContacto(ContactoDTO contacto) {
        this.contacto = contacto;
    }
}
