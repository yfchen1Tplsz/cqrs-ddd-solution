package com.cntaiping.domain.policy.service;

import com.cntaiping.domain.policy.aggregation.Policy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
    @Autowired
    private PolicyDao policyDao;

    public void save(Policy policy) {
        policyDao.save(policy);
    }



}
