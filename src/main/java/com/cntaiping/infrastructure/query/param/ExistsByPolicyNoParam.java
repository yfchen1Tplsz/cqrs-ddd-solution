package com.cntaiping.infrastructure.query.param;

import com.cntaiping.infrastructure.query.constants.ParamConstants;

import java.util.HashMap;
import java.util.Map;

public class ExistsByPolicyNoParam implements QueryParam{
    private  Map<String,Object> params =new HashMap<String,Object>();

    public ExistsByPolicyNoParam(String policyNo){
        params.put(ParamConstants.POLICY_NO, policyNo);
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }
}
