package com.cntaiping.domain.policy.aggregation;

import com.cntaiping.domain.policy.entity.*;
import com.cntaiping.domain.policy.service.PolicyService;
import com.cntaiping.infrastructure.query.enums.QueryStrategyEnum;
import com.cntaiping.infrastructure.query.factory.QueryExecutorStrategyFactory;
import com.cntaiping.infrastructure.query.param.ExistsByPolicyNoParam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.regex.Pattern;

@Data
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
public class Policy {
    @JsonIgnore
    private final PolicyService policyService;

    private PolicyEntity policyEntity;
    private PolicyDateInfo policyDateInfo;
    private List<PolicyImage> policyImage;
    private List<CommentInfo> policyComment;
    private List<Underwriting> policyUnderwriting;

    public void persist(){
        policyService.save(this);
    }

    public boolean validateNBPolicy() {
        String regex = "^TPLHK[0-9]{12}009$";
        if(!Pattern.matches(regex,this.getPolicyEntity().getPolicyNo())){
            return false;
        }
        return !(Boolean)QueryExecutorStrategyFactory
                .queryExecutor(QueryStrategyEnum.EXISTS_BY_POLICY_NO)
                .query(new ExistsByPolicyNoParam(this.getPolicyEntity().getPolicyNo()));
    }


}
