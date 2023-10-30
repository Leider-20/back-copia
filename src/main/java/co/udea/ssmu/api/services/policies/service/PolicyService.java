package co.udea.ssmu.api.services.policies.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.policies.PolicyDTO;
import co.udea.ssmu.api.model.jpa.model.policies.Policy;
import co.udea.ssmu.api.model.jpa.repository.policies.IPolicyRepository;
import co.udea.ssmu.api.utils.exception.PolicyNotFoundException;

@Service
public class PolicyService {
    private final IPolicyRepository policyRepository;

    @Autowired
    public PolicyService(IPolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy createPolicy(Policy policyToSave) {
        return policyRepository.save(policyToSave);
    }

    public List<PolicyDTO> getAllPolicies() {
        List<Policy> policies = policyRepository.findAll();
        List<PolicyDTO> policyDTOs = policies.stream()
                .map(policy -> new PolicyDTO(policy.getId(), policy.getAssociate(), policy.getTaxes(),
                        policy.getPlatform(), policy.getDate()))
                .collect(Collectors.toList());
        return policyDTOs;
    }
}
