package com.cntaiping.infrastructure.query.executor;

import com.cntaiping.adapter.output.PolicyOutput;
import com.cntaiping.adapter.output.QPolicyOutput;
import com.cntaiping.domain.policy.entity.QPolicyDateInfo;
import com.cntaiping.domain.policy.entity.QPolicyEntity;
import com.cntaiping.domain.policy.entity.QPolicyImage;
import com.cntaiping.infrastructure.query.constants.ParamConstants;
import com.cntaiping.infrastructure.query.enums.QueryStrategyEnum;
import com.cntaiping.infrastructure.query.param.QueryParam;
import com.google.common.collect.Sets;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class PolicyOutputQueryExecutor extends AbstractQueryExecutor<PolicyOutput>{
    private static final Set<QueryStrategyEnum> QUERY_EXECUTOR_ENUM_SET = Sets.immutableEnumSet(QueryStrategyEnum.QUERY_POLICY_OUTPUT);

    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    @Override
    public PolicyOutput query(QueryParam queryParam) {
        QPolicyEntity policyEntity =QPolicyEntity.policyEntity;
        QPolicyDateInfo policyDateInfo = QPolicyDateInfo.policyDateInfo;
        return jpaQueryFactory.select(
                        new QPolicyOutput(
                                policyEntity.id,
                                policyEntity.policyNo,
                                policyEntity.policyStatus,
                                policyEntity.middleMan,
                                policyEntity.channel,
                                policyEntity.policyCurrency,
                                policyEntity.yearPremium,
                                policyEntity.paymentFrequency,
                                policyEntity.administrationType,
                                policyDateInfo.applicationDate,
                                policyDateInfo.policyEffectDate,
                                policyDateInfo.ensureEffectDate,
                                policyDateInfo.ensureExpireDate,
                                policyDateInfo.policyAdoptionDate,
                                policyEntity.proposalNo,
                                policyEntity.policyRemark,
                                policyEntity.policyPrp,
                                policyDateInfo.ndd
                        )
                )
                .from(policyEntity)
                .leftJoin(policyDateInfo)
                .on(policyEntity.id.eq(policyDateInfo.policyId))
                .where(policyEntity.id.eq((UUID) queryParam.getParams().get(ParamConstants.POLICY_ID)))
                .fetchOne();
    }

    @Override
    public Set<QueryStrategyEnum> matchQuerySource() {
        return QUERY_EXECUTOR_ENUM_SET;
    }
}
