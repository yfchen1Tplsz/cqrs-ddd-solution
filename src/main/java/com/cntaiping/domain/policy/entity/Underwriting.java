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
@Comment(value = "核保记录表")
@Table(name = "t_underwriting", schema = Constants.SCHEMA)
public class Underwriting {

    @Id
    @Comment(value = "id")
    @Column(nullable = false)
    private UUID id;

    @Comment(value = "保单id")
    @Column(nullable = false)
    private UUID policyId;

    @Comment(value = "当事人id")
    @Column
    private UUID partyId;

    @Comment(value = "核保决定")
    @Column(name = "underwriting_result", length = 128)
    private String uwResult;

    @Comment(value = "加费项")
    @Column(name = "extra_option", length = 256)
    private String extraInfo;

    @Comment(value = "不保事项")
    @Column(name = "disagree_detail", length = 256)
    private String exclusionsInfo;

    @Comment(value = "IMP")
    @Column(name = "imp", length = 50)
    private String imp;

    @Comment(value = "核保日期")
    @Column(name = "underwriting_date")
    private LocalDate uwDate;

    @Comment(value = "使用标识状态")
    @Column(length = 1)
    private String userInd;

}
