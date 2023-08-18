package com.cntaiping.infrastructure.query.param;

import com.cntaiping.adapter.output.PolicyOutput;
import com.cntaiping.infrastructure.query.constants.ParamConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QueryPolicyOutputParam implements QueryParam{
    private  Map<String,Object> params =new HashMap<String,Object>();

    public QueryPolicyOutputParam(UUID policyId){
        params.put(ParamConstants.POLICY_ID,policyId);
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }
}
