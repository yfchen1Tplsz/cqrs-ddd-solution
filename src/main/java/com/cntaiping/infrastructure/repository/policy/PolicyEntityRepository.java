package com.cntaiping.infrastructure.repository.policy;

import com.cntaiping.domain.policy.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PolicyEntityRepository extends JpaRepository<PolicyEntity, UUID> {

    Boolean existsByPolicyNo(Object policyNo);
}
