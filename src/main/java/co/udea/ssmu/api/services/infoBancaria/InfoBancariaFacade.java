package co.udea.ssmu.api.services.infoBancaria;

import co.udea.ssmu.api.model.jpa.dto.InfoBancariaDTO;
import co.udea.ssmu.api.model.jpa.mapper.InfoBancariaMapper;

import java.util.List;

public class InfoBancariaFacade {
    private final InfoBancariaImplementacion infoBancariaImplementacion;
    private final InfoBancariaMapper infoBancariaMapper;

    public InfoBancariaFacade(InfoBancariaImplementacion infoBancariaImplementacion, InfoBancariaMapper infoBancariaMapper) {
        this.infoBancariaImplementacion = infoBancariaImplementacion;
        this.infoBancariaMapper = infoBancariaMapper;
    }

    public InfoBancariaDTO save(InfoBancariaDTO infoBancaria){
        return infoBancariaMapper.toDto(infoBancariaImplementacion.saveInfoBancaria(infoBancariaMapper.toEntity(infoBancaria)));
    }
    public List<InfoBancariaDTO> findAll(){return infoBancariaMapper.toDto(infoBancariaImplementacion.findAllInfoBancaria());}

    public InfoBancariaDTO get(Long id){return infoBancariaMapper.toDto(infoBancariaImplementacion.findInfoBancaria(id));}

    public void delete(Long id){infoBancariaImplementacion.deleteInfoBancaria(id);}
}
