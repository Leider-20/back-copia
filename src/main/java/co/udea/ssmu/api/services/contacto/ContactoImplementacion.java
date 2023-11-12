package co.udea.ssmu.api.services.contacto;

import co.udea.ssmu.api.model.jpa.model.Contacto;
import co.udea.ssmu.api.model.jpa.repository.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactoImplementacion{

    private ContactoRepositorio contactoRepositorio;

    @Autowired
    public ContactoImplementacion(ContactoRepositorio contactoRepositorio) {
        this.contactoRepositorio = contactoRepositorio;
    }

    //GET
    @Transactional(readOnly = true)
    public List<Contacto> findAllContacto() { return contactoRepositorio.findAll();}

    //POST
    public Contacto saveContacto (Contacto contacto) {return contactoRepositorio.save(contacto);}

    //GET ID
    @Transactional(readOnly = true)
    public Contacto findContacto (Long id) {return contactoRepositorio.findById(id).orElse(null);}

    //DELETE
    public void deleteContacto (Long id) {contactoRepositorio.deleteById(id);}

}
