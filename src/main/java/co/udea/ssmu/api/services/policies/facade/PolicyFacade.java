package co.udea.ssmu.api.services.policies.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.policies.PolicyDTO;
import co.udea.ssmu.api.model.jpa.mapper.policies.IPolicyMapper;
import co.udea.ssmu.api.services.policies.service.PolicyService;

@Service
@Transactional
public class PolicyFacade {
    private final PolicyService policyService;
    private final IPolicyMapper iPolicyMapper;

    @Autowired
    public PolicyFacade(PolicyService policyService, IPolicyMapper iPolicyMapper) {
        this.policyService = policyService;
        this.iPolicyMapper = iPolicyMapper;
    }

    public PolicyDTO createPolicy(PolicyDTO policyDTO) {
        return iPolicyMapper.toDto(policyService.createPolicy(iPolicyMapper.toEntity(policyDTO)));
    }

    public List<PolicyDTO> getAllPolicies() {
        return policyService.getAllPolicies();
    }
}
