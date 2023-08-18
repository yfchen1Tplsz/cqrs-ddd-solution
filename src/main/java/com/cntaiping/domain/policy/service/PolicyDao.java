package com.cntaiping.domain.policy.service;

import com.cntaiping.domain.policy.aggregation.Policy;

import java.util.UUID;

public interface PolicyDao {
    public void save(Policy policy);
}
