package co.udea.ssmu.api.services.contacto;

import co.udea.ssmu.api.model.jpa.dto.ContactoDTO;
import co.udea.ssmu.api.model.jpa.mapper.ContactoMapper;

import java.util.List;

public class ContactoFacade {
    private final ContactoImplementacion contactoImplementacion;
    private final ContactoMapper contactoMapper;

    public ContactoFacade(ContactoImplementacion contactoImplementacion, ContactoMapper contactoMapper) {
        this.contactoImplementacion = contactoImplementacion;
        this.contactoMapper = contactoMapper;
    }

    public ContactoDTO save(ContactoDTO contacto){
        return contactoMapper.toDto(contactoImplementacion.saveContacto(contactoMapper.toEntity(contacto)));
    }

    public List<ContactoDTO> findAll() {
        return contactoMapper.toDto(contactoImplementacion.findAllContacto());
    }

    public ContactoDTO get(Long id){ return contactoMapper.toDto(contactoImplementacion.findContacto(id));}

    public void delete(Long id) {
        contactoImplementacion.deleteContacto(id);
    }
}
