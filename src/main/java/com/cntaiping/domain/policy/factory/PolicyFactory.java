package com.cntaiping.domain.policy.factory;

import com.cntaiping.domain.policy.aggregation.Policy;
import com.cntaiping.domain.policy.entity.PolicyEntity;
import com.cntaiping.domain.policy.service.PolicyService;
import com.cntaiping.infrastructure.enums.PolicyStatusEnum;
import com.cntaiping.infrastructure.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PolicyFactory {

    @Autowired
    private PolicyService policyService;
    public Policy createPolicy(String policyNo){
        UUID uuid = UUID.randomUUID();
        PolicyEntity policyEntity = PolicyEntity.builder()
                .id(uuid)
                .policyNo(policyNo)
                .policyStatus(PolicyStatusEnum.POLICY_STATUS_NB.code())
                .build();

        return  Policy.builder()
                .policyService(policyService)
                .policyEntity(policyEntity)
                .build();
    }
}
