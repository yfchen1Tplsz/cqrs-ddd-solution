package com.cntaiping.infrastructure.query.executor;

import com.cntaiping.infrastructure.query.constants.ParamConstants;
import com.cntaiping.infrastructure.query.enums.QueryStrategyEnum;
import com.cntaiping.infrastructure.query.param.QueryParam;
import com.cntaiping.infrastructure.repository.policy.PolicyEntityRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExistsByPolicyQueryExecutor extends AbstractQueryExecutor<Boolean>{
    private static final Set<QueryStrategyEnum> QUERY_EXECUTOR_ENUM_SET = Sets.immutableEnumSet(QueryStrategyEnum.EXISTS_BY_POLICY_NO);
    @Autowired
    private PolicyEntityRepository policyEntityRepository;
    @Override
    public Boolean query(QueryParam queryParam) {
        return policyEntityRepository.existsByPolicyNo(queryParam.getParams().get(ParamConstants.POLICY_NO));
    }

    @Override
    public Set<QueryStrategyEnum> matchQuerySource() {
        return QUERY_EXECUTOR_ENUM_SET;
    }
}
