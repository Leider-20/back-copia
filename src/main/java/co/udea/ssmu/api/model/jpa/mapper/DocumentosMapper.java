package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.DocumentosDTO;
import co.udea.ssmu.api.model.jpa.model.Documentos;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentosMapper extends EntityMapper<DocumentosDTO, Documentos>{
}