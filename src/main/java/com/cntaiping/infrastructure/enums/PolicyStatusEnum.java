package com.cntaiping.infrastructure.enums;

public enum PolicyStatusEnum {

    POLICY_STATUS_NB("NB","新契约"),
    POLICY_STATUS_UW("UW","承保"),
    POLICY_STATUS_PRP("PRP","问题件"),
    POLICY_STATUS_ISSUE("ISSUE","标体通过"),
    POLICY_STATUS_EXPIRE("EXPIRE","废弃");

    private String code;
    private String desc;

    PolicyStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}
