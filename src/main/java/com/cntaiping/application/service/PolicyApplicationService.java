package com.cntaiping.application.service;

import com.cntaiping.adapter.output.PolicyOutput;
import com.cntaiping.application.mapper.PolicyMapper;
import com.cntaiping.domain.policy.aggregation.Policy;
import com.cntaiping.domain.policy.factory.PolicyFactory;
import com.cntaiping.infrastructure.exception.ApplicationException;
import com.cntaiping.infrastructure.query.enums.QueryStrategyEnum;
import com.cntaiping.infrastructure.query.factory.QueryExecutorStrategyFactory;
import com.cntaiping.infrastructure.query.param.QueryPolicyOutputParam;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {
    @Autowired
    private PolicyFactory policyFactory;
    @Resource
    private PolicyMapper policyMapper;

    public PolicyOutput createNBPolicy(String policyNo) {
        //工厂初审注册生成do
        Policy policy = policyFactory.createPolicy(policyNo);
        //校验No：
        if(policy.validateNBPolicy()){
            throw  new ApplicationException("保单号校验不通过，创建保单失败");
        }
        //持久化领域对象
        policy.persist();
        //查询PolicyOutput -- 避免使用mapstruct进行模型变换
        return (PolicyOutput)QueryExecutorStrategyFactory
                .queryExecutor(QueryStrategyEnum.QUERY_POLICY_OUTPUT)
                .query(new QueryPolicyOutputParam(policy.getPolicyEntity().getId()));
    }
}
