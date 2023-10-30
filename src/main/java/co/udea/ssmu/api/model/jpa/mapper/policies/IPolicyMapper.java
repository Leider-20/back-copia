package co.udea.ssmu.api.model.jpa.mapper.policies;

import co.udea.ssmu.api.model.jpa.dto.policies.PolicyDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.policies.Policy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPolicyMapper extends EntityMapper<PolicyDTO, Policy> {
}
