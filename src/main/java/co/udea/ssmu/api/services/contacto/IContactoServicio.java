package co.udea.ssmu.api.services.contacto;

import co.udea.ssmu.api.model.jpa.model.Contacto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IContactoServicio {
    @Transactional(readOnly = true)
    List<Contacto> findAllContacto();

    //POST
    @Transactional
    Contacto saveContacto(Contacto contacto);

    //GET ID
    @Transactional(readOnly = true)
    Contacto findContacto(Long id);

    //DELETE
    @Transactional
    void deleteContacto(Long id);
}
