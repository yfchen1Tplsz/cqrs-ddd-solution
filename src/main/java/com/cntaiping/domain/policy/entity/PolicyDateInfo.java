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

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
@DynamicUpdate
@Entity
@Comment(value = "保单日期信息表")
@Table(name = "t_policy_date_info", schema = Constants.SCHEMA)
public class PolicyDateInfo {

    @Id
    @Comment(value = "id")
    @Column(nullable = false)
    private UUID id;

    @Comment(value = "保单id")
    @Column(nullable = false)
    private UUID policyId;

    @Comment(value = "申请日期")
    @Column(name = "proposal_date")
    private LocalDate applicationDate;

    @Comment(value = "保单生效日期")
    @Column(name = "commencement_date")
    private LocalDate policyEffectDate;

    @Comment(value = "保障生效日期")
    @Column(name = "benefit_effect_date")
    private LocalDate ensureEffectDate;

    @Comment(value = "保障终止日期")
    @Column(name = "termination_date")
    private LocalDate ensureExpireDate;

    @Comment(value = "保单通过日期")
    @Column(name = "adoption_date")
    private LocalDate policyAdoptionDate;

    @Comment(value = "下个保费到期日")
    @Column(name = "next_payment_date")
    private LocalDate ndd;



}
