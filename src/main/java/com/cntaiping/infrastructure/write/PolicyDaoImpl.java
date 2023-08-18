package com.cntaiping.infrastructure.write;

import com.cntaiping.domain.policy.aggregation.Policy;
import com.cntaiping.domain.policy.service.PolicyDao;
import com.cntaiping.infrastructure.repository.policy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
public class PolicyDaoImpl implements PolicyDao {
    @Autowired
    private PolicyEntityRepository policyEntityRepository;
    @Autowired
    private PolicyDateRepository policyDateRepository;
    @Autowired
    private PolicyImageRepository policyImageRepository;
    @Autowired
    private CommentInfoRepository commentInfoRepository;
    @Autowired
    private UnderwritingRepository underwritingRepository;
    @Override
    public void save(Policy policy) {
        policyEntityRepository.save(policy.getPolicyEntity());

        if(!ObjectUtils.isEmpty(policy.getPolicyDateInfo())){
           policyDateRepository.save(policy.getPolicyDateInfo());
        }
        if(!ObjectUtils.isEmpty(policy.getPolicyImage())) {
            policyImageRepository.saveAll(policy.getPolicyImage());
        }
        if(!ObjectUtils.isEmpty(policy.getPolicyComment())) {
            commentInfoRepository.saveAll(policy.getPolicyComment());
        }
        if(!ObjectUtils.isEmpty(policy.getPolicyUnderwriting())) {
            underwritingRepository.saveAll(policy.getPolicyUnderwriting());
        }
    }

}
