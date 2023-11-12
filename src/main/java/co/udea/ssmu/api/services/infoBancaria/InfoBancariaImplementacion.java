package co.udea.ssmu.api.services.infoBancaria;

import co.udea.ssmu.api.model.jpa.model.InfoBancaria;
import co.udea.ssmu.api.model.jpa.repository.InfoBancariaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InfoBancariaImplementacion{

    private final InfoBancariaRepositorio infoBancariaRepositorio;

    @Autowired
    public InfoBancariaImplementacion(InfoBancariaRepositorio infoBancariaRepositorio) {
        this.infoBancariaRepositorio = infoBancariaRepositorio;
    }

    //GET
    @Transactional(readOnly = true)
    public List<InfoBancaria> findAllInfoBancaria() {return infoBancariaRepositorio.findAll();}

    //POST
    public InfoBancaria saveInfoBancaria(InfoBancaria infoBancaria) {return infoBancariaRepositorio.save(infoBancaria);}

    //GET ID
    @Transactional(readOnly = true)
    public InfoBancaria findInfoBancaria(Long id) { return infoBancariaRepositorio.findById(id).orElse(null);}

    //DELETE
    public void deleteInfoBancaria(Long id) { infoBancariaRepositorio.deleteById(id);}

}
