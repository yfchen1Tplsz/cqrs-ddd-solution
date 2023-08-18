package com.cntaiping.infrastructure.query.enums;

public enum QueryStrategyEnum {
    EXISTS_BY_POLICY_NO("existsByPolicyNo","p0001","查询库中是否存在该保单号"),
    QUERY_POLICY_OUTPUT("queryPolicyOutput","p0002","查询保单域输出数据模型PolicyOutput");

    private String type;
    private String code;
    private String desc;

    QueryStrategyEnum(String type, String code, String desc) {
        this.type = type;
        this.code = code;
        this.desc = desc;
    }

    public String type() {
        return type;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}
