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

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
@DynamicUpdate
@Entity
@Comment(value = "保单影像记录表")
@Table(name = "t_policy_image", schema = Constants.SCHEMA)
public class PolicyImage{

    @Id
    @Comment(value = "id")
    @Column(nullable = false)
    private UUID id;

    @Comment(value = "保单id")
    @Column(nullable = false)
    private UUID policyId;

    @Comment(value = "文件信息id：t_file_info.id")
    @Column( nullable = false)
    private UUID fileInfoId;

    @Comment(value = "保单号")
    @Column(length = 50, nullable = false)
    private String policyNo;

    @Comment(value = "理赔单号")
    @Column(length = 50)
    private String claimNo;

    @Comment(value = "主单证件号")
    @Column(length = 128)
    private String mainDoc;

    @Comment(value = "副单证件号")
    @Column(length = 128)
    private String subDoc;
}
