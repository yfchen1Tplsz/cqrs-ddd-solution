package com.cntaiping.domain.policy.entity;

import com.cntaiping.infrastructure.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
@DynamicUpdate
@Entity
@Comment(value = "保单表")
@Table(name = "t_policy", schema = Constants.SCHEMA)
public class PolicyEntity {

    @Id
    @Comment(value = "id")
    @Column(nullable = false)
    private UUID id;

    @Comment(value = "保单号码")
    @Column(length = 50, nullable = false)
    private String policyNo;

    @Comment(value = "保单状态")
    @Column(length = 20, nullable = false)
    private String policyStatus;

    @Comment(value = "中介人")
    @Column(name = "intermediary", length = 64)
    private String middleMan;

    @Comment(value = "渠道")
    @Column(name = "", length = 32)
    private String channel;

    @Comment(value = "保单币种")
    @Column(name = "currency", length = 20)
    private String policyCurrency;

    @Comment(value = "总年度保费")
    @Column(name = "annualized_premium", precision = 20, scale = 2)
    private BigDecimal yearPremium;

    @Comment(value = "缴费频率")
    @Column(name = "payment_frequency", length = 20)
    private String paymentFrequency;

    @Comment(value = "行政方式")
    @Column(name = "administration_type", length = 20)
    private String administrationType;

    @Comment(value = "报价单号")
    @Column(name = "proposal_no", length = 50)
    private String proposalNo;

    @Comment(value = "保单备注")
    @Column(name = "remark", length = 1024)
    private String policyRemark;

    @Comment(value = "保单问题件")
    @Column(name = "prp_ind", length = 1)
    private String policyPrp;

}
